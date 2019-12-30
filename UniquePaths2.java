package leetcode;

/**
 * @Classname UniquePaths2
 * @Description TODO
 * @Date 2019/12/30 14:44
 * @Created by 14241
 */
public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R=obstacleGrid.length;
        int C=obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1){
            return 0;
        }
        obstacleGrid[0][0]=1;
        //填充列
        for(int i=1;i<R;i++){
            obstacleGrid[i][0]=(obstacleGrid[i][0]==0&&(obstacleGrid[i-1][0]==1)?1:0);
        }
        //填充行
        for(int i=1;i<C;i++){
            obstacleGrid[0][i]=(obstacleGrid[0][i]==0&&(obstacleGrid[0][i-1]==1)?1:0);
        }
        //填充所有
        for(int i=1;i<R;i++){
            for(int j=1;j<C;j++){
                if(obstacleGrid[i][j]==0){
                    obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }else{
                    obstacleGrid[i][j]=0;
                }
            }
        }
        return obstacleGrid[R-1][C-1];

    }
}
