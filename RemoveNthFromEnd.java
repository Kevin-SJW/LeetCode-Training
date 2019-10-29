package leetcode;

/**
 * @Classname RemoveNthFromEnd
 * @Description TODO
 * @Date 2019/10/29 14:05
 * @Created by 14241
 */

import java.util.Scanner;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


public class RemoveNthFromEnd {
    private static ListNode head = null;
    private static ListNode tem = null;

    public static void main(String[] args) {
        int[] num = new int[5];
        RemoveNthFromEnd object = new RemoveNthFromEnd();

        for (int i = 0; i < 5; i++) {
            Scanner input = new Scanner(System.in);
            num[i] = input.nextInt();
            object.addNode(num[i]);
        }
        tem = head;
        ListNode res = removeNthFromEnd(tem, 3);
        while(res!=null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }

    public void addNode(int d) {
        ListNode N = new ListNode(d);
        if (head == null) {
            head = N;
            return;  /*由于每次是增加一个节点，所以对头结点进行初始化之后就要退出函数*/
        }
        tem = head;  /*一般一个链表的头结点是不能动的，因此需要把头结点赋值给一个临时变量
		这样在对链表进行访问的时候，就可以用这个临时变量进行逐个的访问，不对头结点产生影响*/
        while (tem.next != null) {
            tem = tem.next;
        }
        tem.next = N;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i < n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;

    }
}
