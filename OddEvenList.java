package leetcode;

/**
 * @Classname OddEvenList
 * @Description TODO
 * @Date 2020/5/12 16:05
 * @Created by 14241
 */
public class OddEvenList {
    public static void main(String[] args) {
        OddEvenList node=new OddEvenList();
        ListNode head=null;
        head=node.insertNode(1,head);
        node.insertNode(2, head);
        node.insertNode(3, head);
        node.insertNode(4, head);
        node.insertNode(5, head);
        node.insertNode(0,head);
        printList(head);
        ListNode node_=oddEvenList(head);
        printList(node_);

    }

    public static ListNode oddEvenList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        // head 为奇链表头结点，o 为奇链表尾节点
        ListNode o = head;
        // p 为偶链表头结点
        ListNode p = head.next;
        // e 为偶链表尾节点
        ListNode e = p;
        while (o.next != null && e.next != null) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return head;
    }
    public static void printList(ListNode head){
        if(head==null){
            return;
        }
        ListNode node=head;
        while(node.next!=null){
            System.out.print(node.val+" ");
            node=node.next;
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
