package leetcode;

/**
 * @Classname ReverseLinkedList2
 * @Description TODO
 * @Date 2020/2/2 15:08
 * @Created by 14241
 * Reverse a linked list from position m to n. Do it in one-pass.
 */
public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ReverseLinkedList2 node=new ReverseLinkedList2();
        //链表的头指针
        ListNode head=null;
        head=node.insertNode(1,head);
        node.insertNode(2, head);
        node.insertNode(3, head);
        node.insertNode(4, head);
        node.insertNode(5, head);
        int m=2,n=4;
        printList(head);
        reverseBetween(head,m,n);
        printList(head);

    }

    /**
     * 反转链表（1步）
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null||m>=n){
            return head;
        }
            ListNode cur=new ListNode(0);
            cur.next=head;
            head=cur;

            ListNode pre=head;
            for(int i=1;i<m;i++){
                pre=pre.next;
            }
            ListNode nodeA=pre.next;
            ListNode nodeB=pre.next.next;

            for(int i=0;i<n-m;i++){
                nodeA.next=nodeB.next;
                nodeB.next=pre.next;
                pre.next=nodeB;
                nodeB=nodeA.next;
            }
            return cur.next;
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
