package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname HouseRobber3
 * @Description TODO
 * @Date 2020/5/30 16:27
 * @Created by Administrator
 */
public class HouseRobber3 {
    public static void main(String[] args) {

    }
    public static int rob(TreeNode root){
        return robRecur(root,new HashMap<>());

    }
    public static int robRecur(TreeNode root, Map<TreeNode,Integer> map){
        if(root==null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        int val=0;
        if(root.left!=null){
            val+=robRecur(root.left.left,map)+robRecur(root.left.right,map);
        }
        if(root.right!=null){
            val+=robRecur(root.right.left,map)+robRecur(root.right.right,map);
        }
        int max=Math.max(root.val+val,//rob root
                robRecur(root.left,map)+robRecur(root.right,map));// no rob root
        map.put(root,max);
        return max;

    }

}
