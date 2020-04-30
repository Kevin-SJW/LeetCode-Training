package leetcode;

/**
 * @Classname MaximumProductOfWordLength
 * @Description TODO
 * @Date 2020/4/30 15:32
 * @Created by 14241
 * Given a string array words, find the maximum value of
 * length(word[i]) * length(word[j]) where the two words do not share common letters.
 * You may assume that each word will contain only lower case letters.
 * If no such two words exist, return 0.
 */
public class MaximumProductOfWordLength {
    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(maxProduct(words));
    }

    public static int maxProduct(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length - 1; j++) {
                if (!havaCommonLetter(words[i], words[j])) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }

    public static boolean havaCommonLetter(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
