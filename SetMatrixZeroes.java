package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname SetMatrixZeroes
 * @Description TODO
 * @Date 2020/1/12 15:28
 * @Created by 14241
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix={{1,1,1},{1,0,1},{1,1,1}};

        printMatrix(matrix);
        setZeroes(matrix);
        System.out.println();
        printMatrix(matrix);

    }
    public static void setZeroes(int[][] matrix) {
        int R=matrix.length;
        int C=matrix[0].length;
        Set<Integer> rows=new HashSet<>();
        Set<Integer> cols=new HashSet<>();

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(rows.contains(i)||cols.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }

    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println(" ");
        }

    }
}
