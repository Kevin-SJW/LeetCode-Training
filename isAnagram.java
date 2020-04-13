package leetcode;

import java.util.Arrays;

/**
 * @Classname isAnagram
 * @Description TODO
 * @Date 2020/4/13 15:14
 * @Created by 14241
 */
public class isAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s,t));

    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] s_=s.toCharArray();
        char[] t_=t.toCharArray();
        Arrays.sort(s_);
        Arrays.sort(t_);
        return Arrays.equals(s_,t_);

    }
}
