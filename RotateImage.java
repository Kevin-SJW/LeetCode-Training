package leetcode;

/**
 * @Classname RotateImage
 * @Description TODO
 * @Date 2019/12/12 15:25
 * @Created by 14241
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * <p>
 * You have to rotate the image in-place,
 * which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * 起始位置:matrix[i][j]
 * 逆时针90度位置:
 * matrix[lenh - j - 1][i]
 * 逆时针180度位置:
 * matrix[lenw- i- 1][lenh- j- 1]
 * 逆时针270度位置:
 * matrix[j][lenw - i - 1]
 * ]
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix);
        rotate(matrix);
        System.out.println();
        printMatrix(matrix);

    }

    public static void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int lenw = matrix.length;
        int lenh = matrix[0].length;
        int k = lenh, temp;
        for (int i = 0; i < lenh / 2; i++) {
            for (int j = i; j < k - 1; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[lenh - j - 1][i];
                matrix[lenh - j - 1][i] = matrix[lenw - i - 1][lenh - j - 1];
                matrix[lenw - i - 1][lenh - j - 1] = matrix[j][lenw - i - 1];
                matrix[j][lenw - i - 1] = temp;
            }
            k--;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println(" ");
        }

    }
}
