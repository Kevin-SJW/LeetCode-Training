package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname CloneGraph
 * @Description TODO
 * @Date 2020/2/29 15:11
 * @Created by 14241
 */
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    private static Map<Node,Node> map=new HashMap<>();
    public static void main(String[] args) {
        Node node1=new Node(2);
        node1.neighbors.add(new Node(4));
        Node node2=new Node(1);
        node2.neighbors.add(new Node(3));
        Node node=cloneGraph(node1);
        for(Node neighbor:node.neighbors){
            System.out.print(neighbor.val);
        }
        System.out.println();
    }
    //dfs
    public static Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newHead=new Node(node.val);
        map.put(node,newHead);
        for(Node aNeighbor:node.neighbors){
            newHead.neighbors.add(cloneGraph(aNeighbor));
        }
        return newHead;
    }
}
