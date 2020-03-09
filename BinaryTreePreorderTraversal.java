package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname BinaryTreePreorderTraversal
 * @Description TODO
 * @Date 2020/3/9 15:08
 * @Created by 14241
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(3);
//        root.right = node1;
//        node1.left = node2;
        BinaryTreePreorderTraversal node =new BinaryTreePreorderTraversal();
        TreeNode root=new TreeNode(1);
        node.add(2,root);
        node.add(3,root);


        List<Integer> res = preorderTraversal(root);
        for(int num:res){
            System.out.print(num+" ");
        }

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return res;
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
