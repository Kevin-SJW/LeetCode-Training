package leetcode;

import java.util.Arrays;

/**
 * @Classname SurroundedRegions
 * @Description TODO
 * @Date 2020/2/26 15:32
 * @Created by 14241
 * Given a 2D board containing 'X' and 'O' (the letter O),
 * capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * urrounded regions shouldn’t be on the border,
 * which means that any 'O' on the border of the board
 * are not flipped to 'X'. Any 'O' that is not on the border
 * and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected
 * if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {
    public static void main(String[] args) {

        char[][] board = {{'X', 'X', 'X', 'X'},
                {'X', '0', '0', 'X'},
                {'X', 'X', '0', 'X'},
                {'X', '0', 'X', 'X'}};
        solve(board);

    }

    public static void solve(char[][] board) {
        if (board == null) {
            return;
        }
        int rows = board.length;
        if (rows <= 0) {
            return;
        }
        int cols = board[0].length;
        if (cols <= 0) {
            return;
        }
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == '0') {
                dfsSearch(board, i, 0);
            }
            if (board[i][cols - 1] == '0') {
                dfsSearch(board, i, cols - 1);
            }
        }
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == '0') {
                dfsSearch(board, 0, i);
            }
            if (board[rows-1][i] == '0') {
                dfsSearch(board, rows - 1, i);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = '0';
                } else if (board[i][j] == '0') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

    }
    // 每遇到'O'后, 开始向四个方向 递归搜索. 搜到后变为'*',
    // 因为相邻的属于一个island. 然后开始继续找下一个'O'

    public static void dfsSearch(char[][] grid, int i, int j) {

        if (grid[i][j] == '0') {
            // 修改为一个不相干的字符，但不能是X
            grid[i][j] = '*';
            // 不需要处理四周边缘了，调用循环已经处理过，不然超时
            if (i < grid.length - 2) {
                dfsSearch(grid, i + 1, j);
            }
            if (i > 1) {
                dfsSearch(grid, i - 1, j);
            }
            if (j < grid[0].length - 2) {
                dfsSearch(grid, i, j + 1);
            }
            if (j > 1) {
                dfsSearch(grid, i, j - 1);
            }
        }

    }
}
