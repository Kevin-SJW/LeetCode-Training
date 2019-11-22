package leetcode;

import java.util.HashSet;

/**
 * @Classname IsValidSudoku
 * @Description TODO
 * @Date 2019/11/22 15:11
 * @Created by 14241
 */
public class IsValidSudoku {
    public static void main(String[] args) {
        String[][] board={
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"},
        };
        //String转char
        char[][] boardChar=new char[board.length][];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                boardChar[i][j]=board[i][j].charAt(0);
            }
        }
        System.out.println(isValidSudoku(boardChar));


    }
    public static boolean isValidSudoku(char[][] board){
        for(int i=0;i<9;i++){
            HashSet<Character> row=new HashSet<>();
            HashSet<Character> col=new HashSet<>();
            HashSet<Character> cube=new HashSet<>();
            for(int j=0;j<9;j++){
                // 检查第i行，在横坐标位置
                if(board[i][j]!='.'&&!row.add(board[i][j])){
                    return false;
                }
                // 检查第i列，在纵坐标位置
                if(board[i][j]!='.'&&!col.add(board[i][j])){
                    return false;
                }
                // 行号+偏移量
                int RowIndex = 3 * (i / 3) + j / 3;
                // 列号+偏移量
                int ColIndex = 3 * (i % 3) + j % 3;
                //每个小九宫格，总共9个
                if(board[RowIndex][ColIndex]!='.'&&!cube.add(board[RowIndex][ColIndex])){
                    return false;
                }
            }
        }
        return true;
    }
}
