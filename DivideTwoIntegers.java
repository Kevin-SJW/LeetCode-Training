package leetcode;

/**
 * @Classname DivideTwoIntegers
 * @Description TODO
 * @Date 2019/11/6 14:47
 * @Created by 14241
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        System.out.println(divide(dividend,divisor));
    }

    public static int divide(int dividend, int divisor) {
        int ret = 0;
        boolean up = true;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            up = false;
        }
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else {
                ret++;
                dividend += Math.abs(divisor);
            }
        }
        divisor = Math.abs(divisor);
        dividend = Math.abs(dividend);
        while (dividend >= divisor) {
            int count = 1;
            int power = divisor;
            while (dividend >> 2 >= power) {
                count = count << 1;
                power = power << 1;
            }
            ret += count;
            dividend -= power;
        }
        return up ? ret : -ret;
    }
}
