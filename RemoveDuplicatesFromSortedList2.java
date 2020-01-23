package leetcode;

/**
 * @Classname RemoveDuplicatesFromSortedList2
 * @Description TODO
 * @Date 2020/1/23 15:23
 * @Created by 14241
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 */
public class RemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList2 node=new RemoveDuplicatesFromSortedList2();
        ListNode head=null;
        head=node.insertNode(1,head);
        node.insertNode(2,head);
        node.insertNode(3,head);
        node.insertNode(3,head);
        node.insertNode(4,head);
        node.insertNode(4,head);
        node.insertNode(5,head);
        printList(head);
        deleteDuplicates(head);
        printList(head);

    }

    /**
     * 删除链表中重复的元素
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode t=new ListNode(0);
        t.next=head;
        ListNode p=t;

        while(p.next!=null&&p.next.next!=null){
            if(p.next.val==p.next.next.val){
                int dup=p.next.val;
                while(p.next!=null&&p.next.val==dup){
                    p.next=p.next.next;
                }
            }else{
                p=p.next;
            }
        }
        return t.next;
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
