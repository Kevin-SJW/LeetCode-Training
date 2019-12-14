package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname NQueens
 * @Description TODO
 * @Date 2019/12/14 15:51
 * @Created by 14241
 * 首先需要一个简便的方法来表示Q的放置，一个N长的数组就可以解决 int[n]，
 * 例如int[0]=1表示在Q放在第1行的第2列，int[2]=3表示在Q放在第3行的第4列。
 * <p>
 * 为了方便表达，需要一个自定义函数
 * <p>
 * private boolean isValid(int[] queenList, int row, int col)
 * 函数返回是否可以在指定的行列放置Q，这里有一个前提就是该指定行上面的Q的放置是合法的。
 */
public class NQueens {
    public static void main(String[] args) {
        int n=4;
        System.out.println(solveNQueens(n));

    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queenList = new int[n]; //第i个位置存放的数表示row行时，Q的列
        placeQueen(queenList, 0, n, res);//在第0行放Q
        return res;
    }

    private static void placeQueen(int[] queenList, int row, int n, List<List<String>> res) {
        //如果已经填满，就生成结果
        if (row == n) {
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int col = 0; col < n; col++) {
                    if (queenList[i] == col) {
                        str += "Q";
                    } else {
                        str += ".";
                    }
                }
                list.add(str);
            }
            res.add(list);
        }
        for (int col = 0; col < n; col++) {//循环每一列
            if (isValid(queenList, row, col)) { //如果在该列放入Q不冲突的话
                queenList[row] = col;
                placeQueen(queenList, row + 1, n, res);
            }
        }
    }

    private static boolean isValid(int[] queenList, int row, int col) {
        for (int i = 0; i < row; i++) {
            int pos = queenList[i];
            if (pos == col) { //和新加入的Q处于同一列
                return false;
            }
            if (pos + row - i == col) { //在新加入的Q的右对角线上
                return false;
            }
            if (pos - row + i == col) { //在新加入的Q的左对角线上
                return false;
            }
        }
        return true;
    }
}
