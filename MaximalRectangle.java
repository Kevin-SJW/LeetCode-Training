package leetcode;

import java.util.Stack;

/**
 * @Classname MaximalRectangle
 * @Description TODO
 * @Date 2020/1/26 17:04
 * @Created by 14241
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        String[][] matrix={{"1","0","1","0","0"},{"1","0","1","1","1"},
                {"1","1","1","1","1"},{"1","0","0","1","0"}};
        char[][] charMatrix=new char[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                charMatrix[i][j]=matrix[i][j].charAt(0);
            }
        }
        System.out.println(maximalRectangle(charMatrix));

    }
    public static int maximalRectangle(char[][] matrix) {
        int rowNum=matrix.length;
        if(rowNum==0)
            return 0;
        int columnNum=matrix[0].length;


        int[][] height=new int[rowNum][columnNum+1];
        int maxarea=0;

        for(int i=0;i<rowNum;i++)
        {
            for(int j=0;j<columnNum;j++)
            {
                int k=i;
                height[i][j]=0;
                while(k>=0&&j<columnNum)
                {
                    if(matrix[k][j]=='1')
                        height[i][j]++;
                    else
                        break;
                    k--;
                }

            }
            height[i][columnNum]=-1;
        }

        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<rowNum;i++)
        {
            for(int j=0;j<=columnNum;j++)
            {
                int a=height[i][j];
                int b=stack.isEmpty()?-1:stack.peek();
                if(stack.isEmpty()||height[i][j]>=height[i][stack.peek()])
                    stack.push(j);
                else
                {


                    int tempPop=stack.pop();
                    maxarea=Math.max(maxarea, height[i][tempPop]*(stack.isEmpty()?j:j-1-stack.peek()));
                    j--;
                }
            }
            stack.clear();
        }

        return maxarea;
    }
}
