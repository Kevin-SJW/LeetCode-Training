package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname LinkedListCycle
 * @Description TODO
 * @Date 2020/3/7 15:39
 * @Created by 14241
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos
 * which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1,
 * then there is no cycle in the linked list.
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycle node = new LinkedListCycle();
        ListNode head = null;
        head = node.insertNode(3, head);
        node.insertNode(2, head);
        node.insertNode(0, head);
        node.insertNode(-4, head);
        System.out.println(hasCycle(head));


    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            } else {
                nodeSet.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 添加新节点
     *
     * @param data
     * @param head
     * @return
     */
    public ListNode insertNode(int data, ListNode head) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            return head;
        }
        ListNode curNode = head;
        //循环找到当前链表的尾节点
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        //尾节点的指针指向新增加的节点
        curNode.next = node;
        return head;
    }
}
