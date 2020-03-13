package leetcode;

/**
 * @Classname ReverseWordsInAString
 * @Description TODO
 * @Date 2020/3/13 15:07
 * @Created by 14241
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        String str = reverseWords(s);
        System.out.print(str + " ");

    }

    public static String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuffer sb = new StringBuffer();
        for (int i = words.length-1; i >= 0; --i) {
            sb.append(words[i] + " ");
        }

        return sb.toString().trim();
    }
}
