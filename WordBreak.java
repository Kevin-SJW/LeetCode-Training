package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname WordBreak
 * @Description TODO
 * @Date 2020/3/6 15:02
 * @Created by 14241
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s,wordDict));

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=i-1;j>=0&!dp[i];j--){
                String check=s.substring(j,i);
                dp[i]=dp[j]&wordDict.contains(check);
            }
        }
        return dp[s.length()];
    }
}
