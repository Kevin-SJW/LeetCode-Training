package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname CopyListWithRandomPointer
 * @Description TODO
 * @Date 2020/3/5 15:15
 * @Created by 14241
 */

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

/**
 * 推荐解答：使用map,每一个原链表节点，在map中对应新链表的节点
 */
public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        RandomListNode node1=new RandomListNode(11);
        RandomListNode node2=new RandomListNode(4);
        node1.next=node2;
        RandomListNode node=copyRandomList(node1);
        System.out.println(node);

    }
    public static RandomListNode copyRandomList(RandomListNode head){
        if(head==null){
            return null;
        }
        RandomListNode node=head;
        Map<RandomListNode,RandomListNode> map=new HashMap<>();

        while(node!=null){
            map.put(node,new RandomListNode(node.label));
            node=node.next;
        }
        node=head;
        while(node!=null){
            map.get(node).next=map.get(node.next);
            map.get(node).random=map.get(node.random);
            node=node.next;
        }
        return map.get(head);


    }

}
