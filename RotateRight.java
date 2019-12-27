package leetcode;

/**
 * @Classname RotateRight
 * @Description TODO
 * @Date 2019/12/27 15:01
 * @Created by 14241
 * 其实就是找到倒数第k个节点，然后把第k个节点之后的部分放到开始
 */
public class RotateRight {
    public static void main(String[] args) {
        RotateRight node=new RotateRight();
        //链表的头指针
        ListNode head=null;
        head=node.insertNode(1,head);
        node.insertNode(2, head);
        node.insertNode(3, head);
        node.insertNode(4, head);
        node.insertNode(5, head);
        int k=2;
        printList(rotateRight(head,k));



    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0){
            return head;
        }
        ListNode fast=head;
        int len=1;
        while(fast.next!=null){
            fast=fast.next;
            len++;
        }
        k%=len;
        if(k==0){
            return head;
        }
        ListNode res=new ListNode(0);
        ListNode slow=head;
        for(int i=0;i<len-k-1;i++){
            slow=slow.next;
        }
        fast.next=head;
        res.next=slow.next;
        slow.next=null;
        return res.next;

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
