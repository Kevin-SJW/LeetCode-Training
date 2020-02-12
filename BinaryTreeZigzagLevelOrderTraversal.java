package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname BinaryTreeZigzagLevelOrderTraversal
 * @Description TODO
 * @Date 2020/2/12 14:54
 * @Created by 14241
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal node = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        node.add(3, root);
        node.add(9, root);
        node.add(20, root);
        node.add(15, root);
        node.add(7, root);
        List<List<Integer>> res = zigzagLevelOrder(root);
        for (List<Integer> re : res) {
            for (int nu : re) {
                System.out.print(nu + " ");
            }
        }

    }

    /**
     * 之字形层次遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean isZigzag=false;
        while(!queue.isEmpty()){

            LinkedList<Integer> subList=new LinkedList<>();
            int count=queue.size();

            for(int i=0;i<count;i++){
                TreeNode node=queue.poll();
                if(isZigzag){
                    subList.add(0,node.val);
                }else {
                    subList.add(node.val);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

            }
            res.add(subList);
            isZigzag=!isZigzag;

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
