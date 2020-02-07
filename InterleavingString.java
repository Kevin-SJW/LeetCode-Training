package leetcode;

/**
 * @Classname InterleavingString
 * @Description TODO
 * @Date 2020/2/7 15:27
 * @Created by 14241
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
