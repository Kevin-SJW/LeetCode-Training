package leetcode;

/**
 * @Classname DeleteNodeInALinkedList
 * @Description TODO
 * @Date 2020/4/10 15:57
 * @Created by 14241
 */
public class DeleteNodeInALinkedList {
    public static void main(String[] args) {

    }
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
