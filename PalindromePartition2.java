package leetcode;

/**
 * @Classname PalindromePartition2
 * @Description TODO
 * @Date 2020/2/28 14:55
 * @Created by 14241
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 */
public class PalindromePartition2 {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));

    }

    public static int minCut(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int[] cut = new int[s.length()+1];

        for (int i = s.length() - 1; i >= 0; i--) {
            cut[i] = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;
                    cut[i] = Math.min(1 + cut[j + 1], cut[i]);
                }
            }

        }
        return cut[0] - 1;
    }
}
