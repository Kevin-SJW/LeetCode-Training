package leetcode;

/**
 * @Classname CountAndSay
 * @Description TODO
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * @Date 2019/11/26 14:50
 * @Created by 14241
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }

        String res = "1";
        int i = 1;
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == res.charAt(j - 1)) {

                    count++;
                } else {
                    sb.append(count);
                    sb.append(res.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(res.charAt(res.length()-1));
            res = sb.toString();
            i++;
        }
        return res;
    }
}
