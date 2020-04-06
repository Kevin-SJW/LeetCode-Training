package leetcode;

/**
 * @Classname CountCompleteTreeNodes
 * @Description TODO
 * @Date 2020/4/6 14:54
 * @Created by 14241
 * Given a complete binary tree, count the number of nodes.
 * 因为是完全二叉树，满二叉树有一个性质是节点数等于2^h-1,h为高度，
 * 所以可以这样判断节点的左右高度是不是一样，如果是一样说明是满二叉树，
 * 就可以用刚才的公式，如果左右不相等就递归计算左右节点。

 */
public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);
        TreeNode node5=new TreeNode(6);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        int count=countNodes(root);
        System.out.println(count);

    }
    public static int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=getLeftNodes(root);
        int right=getRightNodes(root);
        if(left==right){
            return (1<<left)-1;
        }else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }

    }
    public static int getLeftNodes(TreeNode root){
        int height=0;
        while(root!=null){
            height++;
            root=root.left;
        }
        return height;
    }

    public static int getRightNodes(TreeNode root){
        int height=0;
        while(root!=null){
            height++;
            root=root.right;
        }
        return height;
    }
}
