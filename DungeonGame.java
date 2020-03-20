package leetcode;

/**
 * @Classname DungeonGame
 * @Description TODO
 * @Date 2020/3/20 15:34
 * @Created by 14241
 */
public class DungeonGame {
    public static void main(String[] args) {
        int[][] dungeon=new int[][]{
                {-2,-3,3},{-5,-10,1},{10,30,-5}
        };
        System.out.println(calculateMinimumHP(dungeon));

    }
    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 1 && dungeon[0].length == 1){
            if (dungeon[0][0] > 0){
                return 1;
            } else {
                return -dungeon[0][0] + 1;
            }
        }
        int len = dungeon[0].length;
        int row = dungeon.length;
        int[] min = new int[len];
        min[len - 1] = -dungeon[row - 1][len - 1] + 1;
        min[len - 1] = Math.max(min[len - 1], 1);
        for (int i = len - 2; i >= 0; i--){
            min[i] = min[i + 1] - dungeon[row - 1][i];
            min[i] = Math.max(min[i], 1);
        }
        for (int i = row - 2; i >= 0; i--){
            min[len - 1] = min[len - 1] - dungeon[i][len - 1];
            min[len - 1] = Math.max(min[len - 1], 1);
            for (int j = len - 2; j >= 0; j--){
                min[j] = Math.min(min[j + 1], min[j]) - dungeon[i][j];
                min[j] = Math.max(min[j], 1);
            }
        }
        return min[0];
    }
}
