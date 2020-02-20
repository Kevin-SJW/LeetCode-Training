package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PascalTriangle2
 * @Description TODO
 * @Date 2020/2/20 15:11
 * @Created by 14241
 * Given a non-negative index k where k ≤ 33,
 * return the kth index row of the Pascal's triangle.
 */
public class PascalTriangle2 {
    public static void main(String[] args) {
        int rowIndex=3;
        System.out.println(getRow(rowIndex));

    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        for(int i=1;i<rowIndex+1;i++){
            list.add((int)((long)list.get(i-1)*(rowIndex-i+1)/i));
        }
        return list;
    }
}
