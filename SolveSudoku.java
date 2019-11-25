package leetcode;

/**
 * @Classname SolveSudoku
 * @Description TODO
 * @Date 2019/11/25 15:47
 * @Created by 14241
 */
public class SolveSudoku {
    public static void main(String[] args) {
        String[][] board = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"},
        };
        //String转char
        char[][] boardChar = new char[board.length][];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boardChar[i][j] = board[i][j].charAt(0);
            }
        }
        solveSudoku(boardChar);

    }

    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        helper(board);

    }

    private static boolean helper(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char num = '0'; num < '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (helper(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }

                    }

                }
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int i, int j, char c) {
        for (int row = 0; row < 9; row++) {
            //行是否合法
            if (board[row][j] == c) {
                return false;
            }
        }
        for (int col = 0; col < 9; col++) {
            //列是否合法
            if (board[i][col] == c) {
                return false;
            }
        }
        //小的block是否合法
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < i / 3 * 3 + 3; col++) {
                if (board[row][col] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
