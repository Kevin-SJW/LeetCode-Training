package leetcode;

/**
 * @Classname MergeTwoLists
 * @Description TODO
 * @Date 2019/11/1 15:22
 * @Created by 14241
 */
public class MergeTwoLists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoList(ListNode one, ListNode two) {
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
