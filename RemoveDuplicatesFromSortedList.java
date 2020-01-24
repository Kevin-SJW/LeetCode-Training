package leetcode;

/**
 * @Classname RemoveDuplicatesFromSortedList
 * @Description TODO
 * @Date 2020/1/24 16:39
 * @Created by 14241
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList node=new RemoveDuplicatesFromSortedList();
        ListNode head=null;
        head=node.insertNode(1,head);
        node.insertNode(1,head);
        node.insertNode(2,head);
        printList(head);
        deleteDuplicates(head);
        printList(head);

    }
    /**
     * 删除链表中单个重复的元素
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current=head;
        while(current!=null&&current.next!=null){
            if(current.next.val==current.val){
                current.next=current.next.next;
            }else{
                current=current.next;
            }
        }
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
