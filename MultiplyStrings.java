package leetcode;

/**
 * @Classname MultiplyStrings
 * @Description TODO
 * @Date 2019/12/5 15:22
 * @Created by 14241
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        System.out.println(multiply(num1, num2));

    }

    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                res[i + j + 1] += digit1 * digit2;
                res[i + j] += res[i + j + 1] / 10;
                res[i + j + 1] = res[i + j + 1] % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (sb.length() == 0&&res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }

        if (sb.length() == 0) {
            sb.append(0);
        }
        return sb.toString();
    }
}
