package leetcode;

import static leetcode.InsertionSortList.insertNode;
import static leetcode.RotateRight.printList;

/**
 * @Classname SortList
 * @Description TODO
 * @Date 2020/3/10 15:46
 * @Created by 14241
 */
public class SortList {
    public static void main(String[] args) {
        ListNode head=null;
        head=insertNode(4,head);
        insertNode(2,head);
        insertNode(1,head);
        insertNode(3,head);
        printList(head);
        System.out.println();
        ListNode node=sortList(head);
        printList(node);

    }

    public static ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head,fast=head,pre=null;
        //注意，这里不能写成while (fast.next != null && fast.next.next != null)，
        // 因为，在只有两个node的情况下fast和slow指针还是需要向下走，否则无法分解成一个node.
        while(fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;

        }
        //note: 这里需要一个pre指针来保存slow的上一个node，因为需要把上一个node的next设为null.
        pre.next=null;
        //merge的时候，参数是两个sort好的linkedlist的head，需要使用sortList的返回值
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
       return merge(l1,l2);

    }

    public static ListNode merge(ListNode head, ListNode head2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while (head != null && head2 != null) {
            if (head.val < head2.val) {
                p.next = head;
                head = head.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if (head != null) {
            p.next = head;
        }
        if (head2 != null) {
            p.next = head2;
        }
        return dummy.next;
    }
}
