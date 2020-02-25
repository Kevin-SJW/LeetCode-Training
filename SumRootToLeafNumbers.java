package leetcode;

/**
 * @Classname SumRootToLeafNumbers
 * @Description TODO
 * @Date 2020/2/25 15:39
 * @Created by 14241
 * Given a binary tree containing digits from 0-9 only,
 * each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 */
public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        root.left=node1;
        root.right=node2;
        System.out.println(sumNumbers(root));

    }
    public static int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] sum=new int[1];
        build(sum,root,0);
        return sum[0];

    }
    public static void build(int[] sum,TreeNode node,int temp){

        int count=temp;
        if(node.left==null&&node.right==null){
            sum[0]+=count*10+node.val;
            return;
        }
        count=count*10+node.val;
        if(node.left!=null){
            build(sum,node.left,count);
        }
        if(node.right!=null){
            build(sum,node.right,count);
        }
    }
}
