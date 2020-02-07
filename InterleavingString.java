package leetcode;

/**
 * @Classname InterleavingString
 * @Description TODO
 * @Date 2020/2/7 15:27
 * @Created by 14241
 * 分析：这道题，我觉得是比较难的。我最开始的想法是使用递归，但是觉得递归可能会超时，就利用两个指针吗，
 * 齐头并进，当遇到二者相等时，就把中间状态存到栈里面。如果以后走不通了，就出栈，恢复状态。再继续查找，恢复等等，
 * 当数据小规模时，可以work，但是数据量一大就TLE。
 * 于是使用二维DP算法（早该想到）。其核心的状态转移方程为：
 * f(i,j) = s1[i-1][j]==s3[i+j-1] && f[i-1,j] || (s2[i][j-1]==s3[i+j-1] && f[i][j-1])

 */
public class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1,s2,s3));

    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int row = s1.length();
        int col = s2.length();
        int length = s3.length();
        if (row + col != length) {
            return false;
        }
        if (row == 0) {
            return s1.equals(s2);
        }
        if (col == 0) {
            return s2.equals(s3);
        }
        boolean[][] matrix=new boolean[row+1][col+1];
        matrix[0][0]=true;

        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
                if(i>0){
                    matrix[i][j]=s1.charAt(i-1)==s3.charAt(i+j-1)&&matrix[i-1][j];
                }
                if(j>0){
                    matrix[i][j]|=s2.charAt(j-1)==s3.charAt(i+j-1)&&matrix[i][j-1];
                }
            }
        }
        return matrix[row][col];

    }
}
