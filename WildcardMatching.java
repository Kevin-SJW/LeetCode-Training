package leetcode;

/**
 * @Classname WildcardMatching
 * @Description TODO
 * @Date 2019/12/6 15:31
 * @Created by 14241
 * 使用动态规划法。设输入字符串为s，长度为m，模式串为p，长度为n，boolean数组dp[m+1][n+1]。
 * <p>
 * dp[0][j+1]表示空串与p[0..j]是否匹配，dp[i+1][j+1]表示s[0..i]和p[0..j]是否匹配。
 * <p>
 * 如果p[j]=='*'，则dp[i+1][j+1]=dp[i][j+1]||dp[i+1][j]。
 * <p>
 * 如果p[j]=='?'||p[j]==s[i]，则dp[i+1][j+1]=dp[i][j]。
 * <p>
 * 其他情况dp[i+1][j+1]=false。
 */
public class WildcardMatching {
    public static void main(String[] args) {
        String s = "aa",p = "a";
        System.out.println(isMatch(s,p));

    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (dp[0][j] && p.charAt(j) == '*') {
                dp[0][j + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                } else if (p.charAt(j) == '?'||p.charAt(j)==s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
