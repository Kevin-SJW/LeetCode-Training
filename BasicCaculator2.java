package leetcode;

/**
 * @Classname BasicCaculator2
 * @Description TODO
 * @Date 2020/4/6 16:03
 * @Created by 14241
 */
public class BasicCaculator2 {
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));

    }

    public static int calculate(String s) {
        int result = 0;
        int num = 0;
        int tempSum = 0;
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (i == s.length() - 1 || !Character.isDigit(c) && c != ' ') {
                switch (lastSign) {
                    case '+':
                        result += tempSum;
                        tempSum = num;
                        break;
                    case '-':
                        result += tempSum;
                        tempSum = -num;
                        break;
                    case '*':
                        tempSum *= num;
                        break;
                    case '/':
                        tempSum /= num;
                        break;
                    default:
                        break;
                }
                lastSign = c;
                num = 0;
            }
        }
        return result + tempSum;
    }

}
