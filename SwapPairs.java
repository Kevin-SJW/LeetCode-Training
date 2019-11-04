package leetcode;

/**
 * @Classname SwapPairs
 * @Description TODO
 * @Date 2019/11/4 14:57
 * @Created by 14241
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode x=new ListNode(1);
        ListNode c=swapPairs(x);
        MergeTwoLists.printList(c);

    }
    public static ListNode swapPairs(ListNode head) {
        if((head==null)||(head.next==null)){
            return head;
        }
        ListNode Next=head.next;
        head.next=swapPairs(head.next.next);
        Next.next=head;
        return Next;
    }
}
