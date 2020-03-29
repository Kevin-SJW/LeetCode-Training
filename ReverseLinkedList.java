package leetcode;

/**
 * @Classname ReverseLinkedList
 * @Description TODO
 * @Date 2020/3/29 16:09
 * @Created by 14241
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList node =new ReverseLinkedList();
        //链表的头指针
        ListNode head=null;
        head=node.insertNode(1,head);
        node.insertNode(2, head);
        node.insertNode(3, head);
        node.insertNode(4, head);
        node.insertNode(5, head);

        printList(head);
        ListNode node2=reverseList(head);
        System.out.println();
        printList(node2);

    }
    public static ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
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
}
