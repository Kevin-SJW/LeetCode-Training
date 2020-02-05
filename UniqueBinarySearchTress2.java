package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname UniqueBinarySearchTress2
 * @Description TODO
 * @Date 2020/2/5 15:24
 * @Created by 14241
 * 大致思路如上，可以看出这也是一个可以划分成子问题求解的题目，所以考点是动态规划。
 * 但具体对于本题来说，采取的是自底向上的求解过程。
 * <p>
 * 1. 选出根结点后应该先分别求解该根的左右子树集合，也就是根的左子树有若干种，
 * 它们组成左子树集合，根的右子树有若干种，它们组成右子树集合。
 * <p>
 * 2. 然后将左右子树相互配对，每一个左子树都与所有右子树匹配，
 * 每一个右子树都与所有的左子树匹配。然后将两个子树插在根结点上。
 * <p>
 * 3. 最后，把根结点放入链表中。
 */
public class UniqueBinarySearchTress2 {
    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> res = generateTrees(n);
        for (TreeNode node : res) {
            printFromTopToBottom2(node);
            System.out.println();
        }
//        res.stream().forEach(System.out::print);

    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            ArrayList<TreeNode> res = new ArrayList<>();
            return res;
        }
        return generateTrees(1, n);
    }

    public static List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            //以i作为根节点，左子树由[1,i-1]构成
            List<TreeNode> lefts = generateTrees(left, i - 1);
            //右子树由[i+1, n]构成
            List<TreeNode> rights = generateTrees(i + 1, right);
            for (int j = 0; j < lefts.size(); j++) {
                for (int k = 0; k < rights.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(j);
                    root.right = rights.get(k);
                    //存储所有可能行
                    res.add(root);
                }
            }

        }
        return res;

    }

    /**
     * 层序遍历二叉树递归实现
     * @param pTreeRoot
     * @return
     */
    private static int depth(TreeNode pTreeRoot){
        if(pTreeRoot==null){
            return 0;
        }
        int l = depth(pTreeRoot.left);
        int r = depth(pTreeRoot.right);
        if(l > r){
            return l + 1;
        }else{
            return r + 1;
        }
    }

    /**
     * 层次遍历
     * @param pTreeNode
     * @param level
     */
    private static void levelOrder(TreeNode pTreeNode, int level) {
        if(pTreeNode == null || level < 1){
            return ;
        }
        if(level == 1){
            System.out.print(pTreeNode.val+ " ");
            return ;
        }
        //左子树
        levelOrder(pTreeNode.left, level-1);
        //右子树
        levelOrder(pTreeNode.right, level-1);
    }

    /**
     * 从上到下打印二叉树（递归）
     * @param pTreeRoot
     */
    public static void printFromTopToBottom(TreeNode pTreeRoot){
        if(pTreeRoot==null){
            return ;
        }
        int depth = depth(pTreeRoot);
        for (int i = 1; i <= depth; ++i) {
            levelOrder(pTreeRoot, i);
        }
    }

    /**
     * 从上到下打印二叉树（非递归）
     * @param pTreeRoot
     */
    public static ArrayList<Integer> printFromTopToBottom2(TreeNode pTreeRoot){ //非递归版本
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(pTreeRoot == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pTreeRoot);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
            list.stream().forEach(System.out::print);
        }
        return list;
    }


}
