package leetcode;

/**
 * @Classname StringToInteger
 * @Description TODO
 * @Date 2019/10/21 15:01
 * @Created by 14241
 */
public class StringToInteger {
    public static void main(String[] args) {
        String str = "42";
        System.out.println(myAtoi(str));

    }

    public static int myAtoi(String str) {
        str = str.trim();

        if (str == null || str.length() < 1) {
            return 0;
        }

        int i = 0;

        //判断正负号
        char flag = '+';
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        //用double防止存储越界
        double result = 0;

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }


        if (flag == '-') {
            result = -result;
        }
        // 判断是否越界
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;

    }
}
