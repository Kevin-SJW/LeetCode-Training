package leetcode;

/**
 * @Classname InsertionSortList
 * @Description TODO
 * @Date 2020/3/10 15:16
 * @Created by 14241
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode head=null;
        head=insertNode(4,head);
        insertNode(2,head);
        insertNode(1,head);
        insertNode(3,head);
        printList(head);
        System.out.println();
        ListNode node=insertionSortList(head);
        printList(node);


    }
    public static ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        //后面使用tmp.next与pre比较，所以增加一个新的newHead
        ListNode newHead=new ListNode(0);
        ListNode cur=head;

        while(cur!=null){
            //放这里而不放在循环末尾，防止out of index
            ListNode next=cur.next;
            ListNode temp=newHead;
            while(temp.next!=null&&temp.next.val<cur.val){
                temp=temp.next;
            }
            cur.next=temp.next;
            temp.next=cur;
            cur=next;
        }
        return newHead.next;

    }
    /**
     * 增加一个节点
     *
     * @param data
     * @param head
     * @return
     */
    public static ListNode insertNode(int data, ListNode head) {

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
