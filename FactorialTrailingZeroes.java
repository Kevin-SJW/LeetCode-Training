package leetcode;

/**
 * @Classname FactorialTrailingZeroes
 * @Description TODO
 * @Date 2020/3/19 15:34
 * @Created by 14241
 * Given an integer n, return the number of trailing zeroes in n!.
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(trailingZeroes(n));

    }

    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
