package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname SymmtricTree
 * @Description TODO
 * @Date 2020/2/10 15:49
 * @Created by 14241
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 */
public class SymmtricTree {
    public static void main(String[] args) {
        SymmtricTree node = new SymmtricTree();
        TreeNode root = new TreeNode(1);
        node.add(1, root);
        node.add(2, root);
//        node.add(2,root);
        node.add(3, root);
        node.add(4, root);
        node.add(4, root);
        node.add(3, root);
//        levelOrder(root);
//        printTree(root,3);
        System.out.println(isSymmetric(root));
        System.out.println();
        insertBNode(1,root);
        insertBNode(2,root);
        insertBNode(2,root);
        printTree(root,2);

    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirrors(root, root);
    }

    public static boolean isMirrors(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirrors(t1.right, t2.left) && isMirrors(t1.left, t2.right);

    }

    /**
     * 添加节点
     *
     * @param val
     */
    public void add(int val, TreeNode root) {
        //根结点不存在
        if (root == null) {

            return;
        } else {
            TreeNode cur = root;
            while (true) {
                if (val < cur.val) {
                    if (cur.left == null) {
                        TreeNode newNode = new TreeNode(val);
                        cur.left = newNode;
                        return;
                    }
                    cur = cur.left;
                } else if (val > cur.val) {
                    if (cur.right == null) {
                        TreeNode newNode = new TreeNode(val);
                        cur.right = newNode;
                        return;
                    }
                    cur = cur.right;

                } else {
                    //不允许重复
                    return;
                }

            }
        }
    }

    /**
     * 桉树状打印二叉树
     *
     * @param node
     * @param high
     */
    public static void printTree(TreeNode node, int high) {
        if (node == null) {
            return;
        }
        printTree(node.right, high + 1);
        for (int i = 0; i < high; i++) {
            System.out.print(" ");
        }
        System.out.println(node.val + " ");
        printTree(node.left, high + 1);
    }

    /**
     * 层序遍历队列
     *
     * @param Node
     */
    public static void levelOrder(TreeNode Node) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(Node);
        while (!list.isEmpty()) {
            Node = list.poll();
            System.out.print(Node.val + " ");
            if (Node.left != null) {
                list.offer(Node.left);
            }
            if (Node.right != null) {
                list.offer(Node.right);
            }
        }

    }

    /**
     * 从上到下打印二叉树（非递归）
     *
     * @param pTreeRoot
     */
    public static ArrayList<Integer> printFromTopToBottom(TreeNode pTreeRoot) { //非递归版本
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (pTreeRoot == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pTreeRoot);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
            list.stream().forEach(System.out::print);
        }
        return list;
    }

    /**
     * 向二叉排序树中插入结点
     */
    public static void insertBNode(int key, TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur  != null) {
            pre = cur ;
            if (key < cur .val) {
                cur  = cur .left;
            } else if (key > cur .val) {
                cur  = cur .right;
            } else {
                return;
            }
        }
        if (root == null) {
            root = new TreeNode(key);
        } else if (key < pre.val) {
            pre.left = new TreeNode(key);
        } else {
            pre.right = new TreeNode(key);
        }

    }

}
