package leetcode;

/**
 * @Classname MergeTwoLists
 * @Description TODO
 * @Date 2019/11/1 15:22
 * @Created by 14241
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode lSum=mergeTwoList(l1,l2);
        printList(lSum);
    }

    /**
     * 打印链表
     * @param head
     * @return
     */
    public static void printList(ListNode head){
        ListNode curNode= head;
        //循环遍历到尾节点
        while(curNode!=null){

            System.out.print(curNode.val+" ");
            curNode=curNode.next;
        }
        System.out.println();

    }

    public static  ListNode mergeTwoList(ListNode one, ListNode two) {
        ListNode list = new ListNode(-1);
        ListNode tmp = list;
        while (one != null && two != null) {
            if (one.val < two.val) {
                tmp.next = one;
                one = one.next;
            } else {
                tmp.next = two;
                two = two.next;
            }
            tmp = tmp.next;
        }
        if (one != null) {
            tmp.next = one;
        }
        if (two != null) {
            tmp.next = two;
        }
        return list.next;
    }
}
