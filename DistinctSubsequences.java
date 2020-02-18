package leetcode;

/**
 * @Classname DistinctSubsequences
 * @Description TODO
 * @Date 2020/2/18 15:20
 * @Created by 14241
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string
 * by deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        String S = "rabbbit", T = "rabbit";
        System.out.println(numDistinct(S, T));

    }

    public static int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= t.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= s.length(); j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                dp[i][j] = dp[i][j - 1];
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
