package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PascalTriangle
 * @Description TODO
 * @Date 2020/2/19 15:37
 * @Created by 14241
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int numRows=5;
        List<List<Integer>> res=generate(numRows);
        for(List<Integer> nums:res){
            for(int num:nums){
                System.out.print(num+" ");
            }
            System.out.println();
        }

    }

    /**
     * 生成杨辉三角
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        if(result==null){
            return result;
        }
        for(int i=0;i<numRows;i++){
            List<Integer> rows=new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j==0||j==i){
                    rows.add(1);
                }else{
                    rows.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(new ArrayList<>(rows));
        }
        return result;
    }
}
