package leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname LengthOfLongestSubstring
 * @Description 最长的不重复子串
 * @Date 2019/10/16 16:17
 * @Created by 14241
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s){
        int ans=0,i=0,j=0;
        int n=s.length();
        Set<Character> set=new HashSet<>();
        while (i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return Math.max(ans,j-i);
    }

}
