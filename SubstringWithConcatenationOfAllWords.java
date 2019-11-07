package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SubstringWithConcatenationOfAllWords
 * @Description TODO
 * @Date 2019/11/7 14:49
 * @Created by 14241
 */
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s,words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words.length == 0 || s.length() < words.length * words[0].length()) {
            return r;
        }
        ArrayList<String> t = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            t.add(words[i]);
        }
        for (int i = 0; i <= s.length() - words[0].length(); i++) {
            String tmp = s.substring(i, i + words[0].length());
            ArrayList<String> t1 = new ArrayList<>(t);
            if (t1.contains(tmp)) {
                t1.remove(tmp);
                for (int k = i + words[0].length(); k <= s.length() - words[0].length(); k += words[0].length()) {
                    tmp = s.substring(k, k + words[0].length());
                    if (t1.contains(tmp)) {
                        t1.remove(tmp);
                    } else {
                        break;
                    }
                }
                if (t1.size() == 0) {
                    r.add(i);
                }
            }
        }
        return r;
    }
}
