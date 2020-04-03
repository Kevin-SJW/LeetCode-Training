package leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * @Classname SkyLineProblem
 * @Description TODO
 * @Date 2020/4/3 15:36
 * @Created by 14241
 */
public class SkyLineProblem {
    public static void main(String[] args) {

    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair<Integer, Integer>> lines = new ArrayList<>();
        TreeMap<Integer, Integer> h = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        for(int[] a:buildings){
            lines.add(new Pair(a[0], a[2]));
            lines.add(new Pair(a[1], -a[2]));
        }
        Collections.sort(lines, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int x1 = o1.getKey();
                int y1 = o1.getValue();
                int x2 = o2.getKey();
                int y2 = o2.getValue();
                if(x1 != x2)
                    return x1 - x2;
                else{
                    return y2 - y1;
                }
            }
        });
        h.put(0, 1);
        for(Pair p:lines){
            int x = (int)p.getKey();
            int height = (int)p.getValue();
            int maxHeight = h.firstKey();
            if(height > 0){
                if(height > maxHeight){
                    res.add(new ArrayList<>(Arrays.asList(x, height)));
                }
                h.put(height, h.getOrDefault(height, 0)+1);
            }else{
                height = -height;
                Integer v = h.get(height);
                if(v == 1){
                    h.remove(height);
                }else{
                    h.put(height, v-1);
                }
                if(maxHeight != h.firstKey()){
                    res.add(new ArrayList<>(Arrays.asList(x, h.firstKey())));
                }
            }
        }
        return res;
    }
}
