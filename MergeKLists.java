package leetcode;

/**
 * @Classname MergeKLists
 * @Description TODO
 * @Date 2019/11/1 15:02
 * @Created by 14241
 */
public class MergeKLists {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = mergeTwoList(res, lists[i]);
        }
        return res;
    }

    public static ListNode mergeTwoList(ListNode one, ListNode two) {
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
