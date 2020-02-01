package leetcode;

/**
 * @Classname DecodeWays
 * @Description TODO
 * @Date 2020/2/1 15:21
 * @Created by 14241
 * 本题考查动态规划。用nums数组记录解码种数，nums[i]表示到第 i 个字符，
 * 字符串s的解码种数，它由 nums[i - 1]和 nums[i - 2]的解码种数之和，但是会有一些限制，
 * 限制条件就是for循环中的2个if语句（第 i - 1个字符的值不能为0，
 * 第 i - 2和第 i - 1表示的2位数是大于0，且小于27的）
 */
public class DecodeWays {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));

    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] nums = new int[s.length() + 1];
        nums[0] = 1;
        nums[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                nums[i] = nums[i - 1];
            }
            if (s.charAt(i - 2) != '0' &&
                    Integer.parseInt("" + s.charAt(i - 2) + s.charAt(i - 1)) < 27) {
                nums[i] += nums[i - 2];
            }

        }
        return nums[s.length()];
    }
}
