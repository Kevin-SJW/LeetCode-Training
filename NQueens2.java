package leetcode;

/**
 * @Classname NQueens2
 * @Description TODO
 * @Date 2019/12/15 15:21
 * @Created by 14241
 */
public class NQueens2 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalNQueens(n));

    }

    public static int totalNQueens(int n) {
        int[] res = {0};
        if (n <= 0) {
            return res[0];
        }
        int[] columnVal = new int[n];
        DFS_helper(res, n, 0, columnVal);
        return res[0];
    }

    public static void DFS_helper(int[] res, int nQueens, int row, int[] columnVal) {
        if (row == nQueens) {
            res[0]++;
        } else {
            for (int i = 0; i < nQueens; i++) {
                columnVal[row] = i;
                if (isValid(row, columnVal)) {
                    DFS_helper(res, nQueens, row + 1, columnVal);
                }
            }
        }
    }

    public static boolean isValid(int row, int[] columnVal) {
        for (int i = 0; i < row; i++) {
            if (columnVal[row] == columnVal[i] || Math.abs(columnVal[row] - columnVal[i]) == row - i) {
                return false;
            }
        }
        return true;
    }
}
