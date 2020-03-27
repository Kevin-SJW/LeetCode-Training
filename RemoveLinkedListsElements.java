package leetcode;

/**
 * @Classname RemoveLinkedListsElements
 * @Description TODO
 * @Date 2020/3/27 16:01
 * @Created by 14241
 * Remove all elements from a linked list of integers that have value val.
 */
public class RemoveLinkedListsElements {
    public static void main(String[] args) {
        RemoveLinkedListsElements node =new RemoveLinkedListsElements();
        //链表的头指针
        ListNode head=null;
        head=node.insertNode(1,head);
        node.insertNode(2, head);
        node.insertNode(3, head);
        node.insertNode(4, head);
        node.insertNode(5, head);
        node.insertNode(6,head);
        printList(head);
        ListNode node2=removeElements(head,6);
        System.out.println();
        printList(node2);


    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode correct=new ListNode(0);
        correct.next=head;
        ListNode cur=correct;
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        //返回的时候从head开始返回
        return correct.next;
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
