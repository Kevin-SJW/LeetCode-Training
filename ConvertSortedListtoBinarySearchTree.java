package leetcode;

import AutumnRecruitment.chap5_1.LSD;

import java.util.*;

/**
 * @Classname ConvertSortedListtoBinarySearchTree
 * @Description TODO
 * @Date 2020/2/15 15:35
 * @Created by 14241
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class ConvertSortedListtoBinarySearchTree {
    public static void main(String[] args) {
        ListNode head=null;
        head=insertNode(-10,head);
        insertNode(-3,head);
        insertNode(0,head);
        insertNode(5,head);
        insertNode(9,head);
        TreeNode nodes=sortedListToBST(head);
        List<List<Integer>> res=levelOrder(nodes);
        for(List<Integer> nums:res){
            for(int num:nums){
                System.out.print(num+" ");
            }
        }


    }
    public static TreeNode sortedListToBST(ListNode head){
        if(head==null){
            return null;
        }
        return buildTree(head,null);

    }
    public static TreeNode buildTree(ListNode head,ListNode end){
        if(head==null||head==end){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;

        //slow就是链表中间节点
        while(fast!=end&&fast.next!=end){
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root=new TreeNode(slow.val);
        root.left=buildTree(head,slow);
        root.right=buildTree(slow.next,end);
        return root;
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
     * 插入节点
     * @param val
     * @param head
     */
    public static ListNode insertNode(int val,ListNode head){
        ListNode node=new ListNode(val);
        if(head==null){
            head=node;
            return head;
        }
        ListNode cur=head;
        //循环遍历找到尾节点
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
        return head;
    }
}
