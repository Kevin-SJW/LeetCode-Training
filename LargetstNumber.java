package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname LargetstNumber
 * @Description TODO
 * @Date 2020/3/21 15:40
 * @Created by 14241
 * 先把int数组转为String，然后做一个比较器，
 * 这里有一个小技巧可以用 (o2 + o1).compareTo(o1 + o2)作为比较器，
 * 可以将"大数字"放到前面，然后按照比较器的顺序输出即可
 */
public class LargetstNumber {
    public static void main(String[] args) {
        int[] nums={3,30,34,5,9};
        System.out.println(largestNumber(nums));

    }
    public static String largestNumber(int[] nums) {
        String[] str=new String[nums.length];
        for(int i=0;i<str.length;i++){
            str[i]=String.valueOf(nums[i]);
        }
        Comparator<String> comp=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        };
        Arrays.sort(str,comp);
        if(str[0].equals("0")){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        for(String s:str){
            sb.append(s);
        }
        return sb.toString();
    }
}
