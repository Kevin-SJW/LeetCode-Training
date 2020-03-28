package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname IsomorphicStrings
 * @Description TODO
 * @Date 2020/3/28 16:09
 * @Created by 14241
 * 同形态字符串
 * Given two strings s and t, determine if they are isomorphic.
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic(s,t));

    }

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> hms = new HashMap<>();
        Map<Character, Character> hmt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ss = s.charAt(i);
            Character tt = t.charAt(i);
            if (hms.containsKey(ss) || hmt.containsKey(tt)) {
                if (!hms.get(ss).equals(tt) || !hmt.get(tt).equals(ss)) {
                    return false;
                }
            } else {
                hms.put(ss, tt);
                hmt.put(tt, ss);

            }
        }
        return true;
    }
}
