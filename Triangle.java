package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Triangle
 * @Description TODO
 * @Date 2020/2/20 15:30
 * @Created by 14241
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(2);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer> list3 = Arrays.asList(6, 5, 7);
        List<Integer> list4 = Arrays.asList(4, 1, 8, 3);

        res.add(list1);
        res.add(list2);
        res.add(list3);
        res.add(list4);
        System.out.println(minimumTotal(res));

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        //三角形行数, 定义row简化代码书写
        int row = triangle.size();
        //异常情形
        if (row == 0) {
            return 0;
        }

        //从倒数第二行开始，从下向上递推
        for (int i = row - 2; i >= 0; i--) {
            //行（从下向上）
            //列（从左向右）
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                //核心：动态规划状态转移方程
                triangle.get(i).set(j, min + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}
