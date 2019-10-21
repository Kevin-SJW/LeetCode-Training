package leetcode;

/**
 * @Classname PalindromeNumber
 * @Description TODO
 * @Date 2019/10/21 15:47
 * @Created by 14241
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));

    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        // initialize how many zeros
        int div = 1;
        while (x / div >= 10) {
            div = div * 10;
        }
        while (x != 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;

    }
}
