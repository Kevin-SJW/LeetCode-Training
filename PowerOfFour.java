package leetcode;

/**
 * @Classname PowerOfFour
 * @Description TODO
 * @Date 2020/6/1 15:35
 * @Created by Administrator
 */
public class PowerOfFour {
    public static void main(String[] args) {
        int num=16;
        System.out.println(isPowerOfFour(num));

    }

    public static boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        if (num % 4 != 0) {
            return false;
        }
        return isPowerOfFour(num /= 4);
    }
}
