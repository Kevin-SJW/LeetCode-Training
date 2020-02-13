package leetcode;

/**
 * @Classname MaximumDepthofBinaryTree
 * @Description TODO
 * @Date 2020/2/13 14:40
 * @Created by 14241
 */
public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {
        MaximumDepthofBinaryTree node=new MaximumDepthofBinaryTree();
        TreeNode root = new TreeNode(3);
        node.add(3, root);
        node.add(9, root);
        node.add(20, root);
        node.add(15, root);
        node.add(7, root);
        System.out.println(maxDepth(root));

    }
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l=0,r=0;
        if(root.left!=null){
            l=maxDepth(root.left);
        }
        if(root.right!=null){
            r=maxDepth(root.right);
        }
        return Math.max(l,r)+1;

    }
    /**
     * 添加节点
     *
     * @param val
     */
    public boolean add(int val, TreeNode root) {
        //创建新节点对象
        TreeNode node = new TreeNode(val);
//        TreeNode root=new TreeNode(val);
        //根结点不存在
        if (root == null) {
            root = node;
            return true;
        } else {
            TreeNode cur = root;
            while (true) {
                if (val < cur.val) {
                    if (cur.left == null) {
                        TreeNode newNode = new TreeNode(val);
                        cur.left = newNode;
                        return true;
                    }
                    cur = cur.left;
                } else if (val > cur.val) {
                    if (val > cur.val) {
                        if (cur.right == null) {
                            TreeNode newNode = new TreeNode(val);
                            cur.right = newNode;
                            return true;
                        }
                        cur = cur.right;
                    }
                } else {
                    //不允许重复
                    return false;
                }

            }
        }
    }
}
