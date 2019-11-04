package leetcode;

import java.util.Stack;

/**
 * @Classname ReverseKGroup
 * @Description TODO
 * @Date 2019/11/4 15:33
 * @Created by 14241
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        ListNode res = reverseKGroup(x, 1);
        printList(res);


    }

    public static void printList(ListNode head) {
        ListNode curNode = head;
        while (curNode != null) {
            System.out.println(curNode.val + " ");
            curNode = curNode.next;
        }
        System.out.println();

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (head != null) {
                st.push(head);
            } else {
                return temp;
            }
            head = head.next;
        }
        ListNode first = st.pop();
        ListNode res = first;
        for (int i = 0; i < k - 1; i++) {
            first.next = st.pop();
            first = first.next;
        }
        first.next = reverseKGroup(head, k);
        return res;

    }
}
