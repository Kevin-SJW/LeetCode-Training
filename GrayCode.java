package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname GrayCode
 * @Description TODO
 * @Date 2020/1/30 15:59
 * @Created by 14241
 * The gray code is a binary numeral system where two successive values
 * differ in only one bit.
 * 1. 如果格雷码n位数，那么返回的数组长度是2^n（即1 << n)
 *
 * 2. 二进制-->格雷码：如果二进制码字的第i位和i+1位相同，则对应的格雷码的第i位为0，否则为1。最高为之前可以看作还有一位0，即最高位是和0异或。
 *
 * *格雷码-->二进制：最左边一位不变，从左边第二位起，将每位与左边一位解码后的值异或，作为该位解码后的值。
 */
public class GrayCode {
    public static void main(String[] args) {
        int n=2;
        System.out.println(grayCode(n));

    }
    public static List<Integer> grayCode(int n) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<1<<n;i++){
            int temp=i>>1;
            list.add(temp^i);
        }
        return list;
    }
}
