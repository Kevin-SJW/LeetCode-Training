package leetcode;

/**
 * @Classname ValidPalindrome
 * @Description TODO
 * @Date 2020/2/23 15:42
 * @Created by 14241
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
