package leetcode;
import java.util.*;
/**
 * @Classname CountingBits
 * @Description TODO
 * @Date 2020/5/30 17:07
 * @Created by Administrator
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 */
public class CountingBits {
    public static void main(String[] args) {
        int num=2;
        Arrays.stream(countBits(num)).forEach(t-> System.out.print(t+","));
//        System.out.println(countBits(num).toString());
    }
    public static int[] countBits(int num){
        int[] res=new int[num+1];
        for(int i=0;i<=num;i++){
            res[i]=res[i>>1]+(i&1);
        }
        return res;
    }
}
