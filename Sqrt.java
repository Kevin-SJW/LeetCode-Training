package leetcode;

/**
 * @Classname Sqrt
 * @Description TODO
 * @Date 2020/1/7 15:19
 * @Created by 14241
 * <p>
 * Implement int sqrt(int x).
 * Compute and return the square root of x,
 * where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer,
 * the decimal digits are truncated and only the integer part of the result is returned.
 */
public class Sqrt {
    public static void main(String[] args) {
        int x=8;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long low = 0;
        //平方根的值按规律发现不会大于它的中值+1。这样每个查找就少了一次
        long high = x / 2 + 1;
        long tmp;
        long mid = 1;
        while (low <= high) {
            mid = (low + high) / 2;
            tmp = mid * mid;
            if (tmp == x) {
                return (int) mid;
            } else if (tmp > x) {
                high = mid - 1;
            } else if (tmp < x) {
                low = mid + 1;
            }

        }
        return (int) high;

    }
}
