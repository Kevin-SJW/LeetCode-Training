package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SpiralMatrix2
 * @Description TODO
 * @Date 2019/12/23 15:11
 * @Created by 14241
 * Given a positive integer n,
 * generate a square matrix filled with elements from 1 to n2 in spiral order.
 */
public class SpiralMatrix2 {
    public static void main(String[] args) {
        int n = 3;
        printMatrix(generateMatrix(n));

    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }

        int r1 = 0, c1 = 0;
        int r2 = n - 1, c2 = n - 1;
        int num = 1;

        while (r1 <= r2 && c1 <= c2) {
            // Traverse right
            for (int j = c1; j <= c2; j++) {
                matrix[r1][j] = num++;
            }
            r1++;
            // Traverse down
            for (int i = r1; i <= r2; i++) {
                matrix[i][c2] = num++;
            }
            c2--;
            if (r1 <= r2) {
                // Traverse left
                for (int j = c2; j >= c1; j--) {
                    matrix[r2][j] = num++;
                }
                r2--;
            }
            if (c1 <= c2) {
                // Traverse up
                for (int i = r2; i >= r1; i--) {
                    matrix[i][c1] = num++;
                }
                c1++;
            }
        }
        return matrix;

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }

    }
}
