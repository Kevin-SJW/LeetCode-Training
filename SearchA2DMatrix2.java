package leetcode;

/**
 * @Classname SearchA2DMatrix2
 * @Description TODO
 * @Date 2020/4/12 15:34
 * @Created by 14241
 */
public class SearchA2DMatrix2 {
    public static void main(String[] args) {
        int[][] matrix={
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target=5;
        System.out.println(searchMatrix(matrix,target));

    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        int i=0,j=matrix[0].length-1;
        while(i<matrix.length&&j>=0){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]<target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
