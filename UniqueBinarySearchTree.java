package leetcode;

/**
 * @Classname UniqueBinarySearchTree
 * @Description TODO
 * @Date 2020/2/6 15:14
 * @Created by 14241
 * 假如整个树有 n 个节点，根节点为 1 个节点，两个子树平分剩下的 n-1 个节点。
 *
 * 假设我们已经知道节点数量为 i 的二叉树有dp[i]种不同的形态。
 *
 * 则一颗二叉树左节点节点数量为 k 时，其形态数为dp[k] * dp[i - 1 - k]
 */
public class UniqueBinarySearchTree {
    public static void main(String[] args) {
        int n=3;
        System.out.println(numTrees(n));

    }
    public static int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
}
