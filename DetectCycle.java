package leetcode;

/**
 * @Classname DetectCycle
 * @Description TODO
 * @Date 2020/5/13 15:57
 * @Created by 14241
 */
public class DetectCycle {
    public static void main(String[] args) {
        DetectCycle node =new DetectCycle();
        ListNode head=null;
        head=node.insertNode(3,head);
        node.insertNode(2,head);
        node.insertNode(0,head);
        node.insertNode(-4,head);
        node.insertNode(0,head);
        printList(head);
        ListNode node_=detectCycle(head);
        printList(node_);


    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fp = head, sp = head;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            //判断是否成环
            if (fp == sp) {
                return null;
            }
        }
        if (fp == null || fp.next == null) {
            return null;
        }
        //fp到环入口距离 = head到环入口距离
        sp = head;
        while (fp != sp) {
            sp = sp.next;
            fp = fp.next;
        }
        return sp;

    }

    /**
     * 插入新节点
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
}
