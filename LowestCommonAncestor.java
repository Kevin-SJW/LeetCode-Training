package leetcode;

/**
 * @Classname LowestCommonAncestor
 * @Description TODO
 * @Date 2020/4/9 16:03
 * @Created by 14241
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        int parentVal=root.val;

        int pVal=p.val;
        int qVal=q.val;
        if(pVal>parentVal&&qVal>parentVal){
            return lowestCommonAncestor(root.right,p,q);
        }else if(pVal<parentVal&&qVal<parentVal){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }
}
