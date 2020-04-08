package leetcode;

import java.util.ArrayList;

/**
 * @Classname KthSmallestElementInABST
 * @Description TODO
 * @Date 2020/4/8 15:30
 * @Created by 14241
 */
public class KthSmallestElementInABST {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(4);
        TreeNode node3=new TreeNode(2);
        root.left=node1;
        root.right=node2;
        node1.right=node3;
        System.out.println(kthSmallest(root,1));

    }
    public static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ans=inorder(root,new ArrayList<Integer>());
        return ans.get(k-1);

    }
    public static ArrayList<Integer> inorder(TreeNode root,ArrayList<Integer> arr){
        if(root==null){
            return arr;
        }
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        return arr;
    }
}
