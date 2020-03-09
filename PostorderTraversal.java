package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PostorderTraversal
 * @Description TODO
 * @Date 2020/3/9 15:28
 * @Created by 14241
 */
public class PostorderTraversal {


    public static void main(String[] args) {
        PostorderTraversal node = new PostorderTraversal();
        TreeNode root = new TreeNode(1);
        node.add(2, root);
        node.add(3, root);


        List<Integer> res = postorderTraversal(root);
        for (int num : res) {
            System.out.print(num + " ");
        }

    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postOrder(res, root);
        return res;
    }

    public static void postOrder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(res, root.left);
        postOrder(res, root.right);
        res.add(root.val);
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
