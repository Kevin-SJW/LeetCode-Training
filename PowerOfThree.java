package leetcode;

/**
 * @Classname PowerOfThree
 * @Description TODO
 * @Date 2020/5/11 20:35
 * @Created by 14241
 */
public class PowerOfThree {
    public static void main(String[] args) {
        int n = 27;
        System.out.println(isPowerOfThree(n));


    }

    public static boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        } else if (n == 0) {
            return false;
        } else if (n % 3 == 0) {
            n = n / 3;
            return isPowerOfThree(n);
        } else {
            return false;
        }
    }
}
