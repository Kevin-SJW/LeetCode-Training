package leetcode;

/**
 * @Classname ReorderList
 * @Description TODO
 * @Date 2020/3/8 15:49
 * @Created by 14241
 */
public class ReorderList {
    public static void main(String[] args) {
        ReorderList node = new ReorderList();
        ListNode head = null;
        head = node.insertNode(1, head);
        node.insertNode(2, head);
        node.insertNode(3, head);
        node.insertNode(4, head);
        printList(head);
        System.out.println();
        reorderList(head);
        printList(head);

    }
    public static void reorderList(ListNode head) {
        ListNode headCopy=head;
        while(headCopy!=null&&head.next!=null&&headCopy.next.next!=null){
            ListNode temp=headCopy;
            while(temp.next.next!=null){
                temp=temp.next;
            }
            temp.next.next=headCopy.next;
            headCopy.next=temp.next;
            temp.next=null;
            temp=headCopy.next.next;
            headCopy=headCopy.next.next;
        }
    }

    /**
     * 添加新节点
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
