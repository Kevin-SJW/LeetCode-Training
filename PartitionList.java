package leetcode;

/**
 * @Classname PartitionList
 * @Description TODO
 * @Date 2020/1/27 15:50
 * @Created by 14241
 */
public class PartitionList {
    public static void main(String[] args) {
        PartitionList node =new PartitionList();
        ListNode head=null;
        head=node.insertNode(1,head);
        node.insertNode(4,head);
        node.insertNode(3,head);
        node.insertNode(2,head);
        node.insertNode(5,head);
        node.insertNode(2,head);
        printList(head);
        int x=3;
        partition(head,x);
        printList(head);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode start = head;

        while (start != null) {
            int value = start.val;
            if (value < x) {
                p1.next = start;
                p1 = p1.next;
            } else {
                p2.next = start;
                p2 = p2.next;
            }
            start = start.next;
        }
        p2.next = null;
        p1.next = list2.next;
        return list1.next;
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
    /**
     * 增加一个节点
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
