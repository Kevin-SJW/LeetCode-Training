package leetcode;

/**
 * @Classname NumberOfIslands
 * @Description TODO
 * @Date 2020/3/26 15:47
 * @Created by 14241
 * 若是碰到一个1, 用DFS把与它相连的1 都换成0. 继续扫描，最后算出能有多少个 单独的 1.
 * <p>
 * Time Complexity: O(m*n), m = grid.length, n = grid[0].length.
 * 看起来像 O(m^2 * n^2), 对于每一个点 做DFS 用O(m*n). 一共m*n个点，其实每个点最多扫描两遍。
 * <p>
 * Space: O(m*n) 最多可以有O(m*n)层 stack.
 */
public class NumberOfIslands {
    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));

    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    replace(grid, i, j);
                }
            }

        }
        return res;

    }

    public static void replace(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        replace(grid, i - 1, j);
        replace(grid, i + 1, j);
        replace(grid, i, j - 1);
        replace(grid, i, j + 1);
    }
}
