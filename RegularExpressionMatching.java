package leetcode;

/**
 * @Classname RegularExpressionMatching
 * @Description Regular Expression Matching
 * @Date 2019/10/22 15:58
 * @Created by 14241
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        //解决初始栈为空的问题
        dp[0][0] = true;
        for (int i = 2; i <= p.length(); i += 2) {
            if (p.length() > 1 && p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        // 从s第一个字符开始慢慢验证更长的字符串，保留中间结果到dp中。
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                //如果不是*则如果s-1,p-1匹配则 s,p匹配。
                if (equal(s.charAt(i - 1), p.charAt(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                //如果是* 例如正则中出现 a* 匹配0次则取dp[i][j-2]的结果 匹配一次取dp[i][j-1]的结果
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i][j - 2];
                    //如果第i个字符正好与p中*前的相等则取dp[i-1][j]的结果
                    if (equal(s.charAt(i - 1), p.charAt(j - 2))) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];

    }

    public static boolean equal(char s, char p) {
        return s == p || p == '.';
    }

}
