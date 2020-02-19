package leetcode;

/**
 * @Classname PopulatingNextRightPointerInEachNode
 * @Description TODO
 * @Date 2020/2/19 15:13
 * @Created by 14241
 */
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


public class PopulatingNextRightPointerInEachNode {
    public static void main(String[] args) {

    }
    public static void connect(Node root) {
        if(root==null){
            return;
        }
        if(root.left!=null){
            root.left.next=root.right;
            // 如果左子树不空，那么右子树不空，因为每个都有两个孩子
            // every parent has two children
            if(root.next!=null){
                root.right.next=root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
    }
}
