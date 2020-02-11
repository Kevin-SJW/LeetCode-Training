package leetcode;

import java.util.*;

/**
 * @Classname BinaryTreeLevelOrderTraversal
 * @Description TODO
 * @Date 2020/2/11 15:06
 * @Created by 14241
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal node = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(3);
        node.add(3, root);
        node.add(9, root);
        node.add(20, root);
        node.add(15, root);
        node.add(7, root);
        List<List<Integer>> res = levelOrder(root);
        for (List<Integer> re : res) {
            for (int num : re) {
                System.out.print(num + " ");
            }
        }

    }

    /**
     * 按层次遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            for (TreeNode child : queue) {
                list.add(child.val);
            }
//            TreeNode node=queue.poll();
//            list.add(node.val);
            res.add(list);

            Queue<TreeNode> queue2 = queue;
            queue = new LinkedList<TreeNode>();
            for (TreeNode child : queue2) {
                if (child.left != null) {
                    queue.add(child.left);
                }
                if (child.right != null) {
                    queue.add(child.right);
                }
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
