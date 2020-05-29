package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname SerializeAndDeserializeBinaryTree
 * @Description TODO
 * @Date 2020/5/29 16:43
 * @Created by Administrator
 */
public class SerializeAndDeserializeBinaryTree {
    //Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode curt = queue.poll();
            if (curt == null){
                sb.append("null,");
                continue;
            }
            sb.append(curt.val);
            sb.append(",");
            queue.offer(curt.left);
            queue.offer(curt.right);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    //"[1,2,3,null,null,4,5,null,null]"
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")){
            return null;
        }
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < nodes.length; i++){
            TreeNode curt = queue.poll();
            if (!nodes[i].equals("null")){
                curt.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curt.left);
            }
            i += 1;
            if (!nodes[i].equals("null")){
                curt.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curt.right);
            }
        }
        return root;
    }
}
