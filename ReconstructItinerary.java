package leetcode;

import java.util.*;

/**
 * @Classname ReconstructItinerary
 * @Description TODO
 * @Date 2020/5/31 15:38
 * @Created by Administrator
 */
public class ReconstructItinerary {

    private static Map<String, PriorityQueue<String>> map = new HashMap<>();

    private static List<String> resList = new LinkedList<>();

    public static void main(String[] args) {
        List<String> list1=Arrays.asList("MUC", "LHR");
        List<String> list2=Arrays.asList("JFK", "MUC");
        List<String> list3=Arrays.asList("SFO", "SJC");
        List<String> list4=Arrays.asList("LHR", "SFO");
        List<List<String>> tickets=Arrays.asList(list1,list2,list3,list4);
        List<String> res=findItinerary(tickets);
//       res.forEach(t-> System.out.print(t+","));
//        Collections.reverse(res);
        System.out.println(res.toString());



    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if (!map.containsKey(src)) {
                PriorityQueue<String> pq=new PriorityQueue<>();
                map.put(src,pq);
            }
            map.get(src).add(dst);
        }
        dfs("JFK");
        return resList;
    }

    public static void dfs(String src) {
        PriorityQueue<String> pq = map.get(src);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }
//        resList.add(src);
        ((LinkedList<String>) resList).addFirst(src);
    }

}



