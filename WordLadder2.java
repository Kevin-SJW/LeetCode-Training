package leetcode;

import java.util.*;

/**
 * @Classname WordLadder2
 * @Description TODO
 * @Date 2020/2/24 14:45
 * @Created by 14241
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 */
public class WordLadder2 {
    static Map<String, List<String>> map;
    static List<List<String>> results;

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> res=findLadders(beginWord,endWord,wordList);
        for(List<String> string:res){
            for(String s:string){
                System.out.print(s+" ");
            }
        }

    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //方法一：dfs，超时

        //方法二：
        results = new ArrayList<>();
        if (wordList.size() == 0 || !wordList.contains(endWord)) return results;

        int min = Integer.MAX_VALUE;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        map = new HashMap<String, List<String>>();
        Map<String, Integer> ladder = new HashMap<>();   //用来记录每个string出现的最小序号

        for (String string : wordList) {
            ladder.put(string, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            if (step > min) //如果大于最小步数，直接跳出循环
                break;

            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    sb.setCharAt(i, c);
                    String new_word = sb.toString();
                    if (ladder.containsKey(new_word)) {
                        //只有第一次遍历到的new_word才回加入到queue/map,因为step是非递减的
                        if (step > ladder.get(new_word))
                            continue;
                        else if (step < ladder.get(new_word)) {
                            queue.add(new_word);
                            ladder.put(new_word, step);
                        }
                        //map中值存放word的所有前一个元素
                        if (map.containsKey(new_word))
                            map.get(new_word).add(word);
                        else {
                            List<String> list = new LinkedList<String>();
                            list.add(word);
                            map.put(new_word, list);
                        }
                        if (new_word.equals(endWord))
                            min = step;
                    }
                }
            }

        }

        // 只能用LinkedList，不能用ArrayList。原因见backTrace方法
        LinkedList<String> result = new LinkedList<String>();
        backTrace(endWord, beginWord, result);
        return results;
    }

    private static void backTrace(String word, String start, List<String> list) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        // 注意：这里的list是LinkedList类型，所以插入index=0的位置，其余元素全部后移
        // 如果是ArrayList，会把0处的元素替换
        list.add(0, word);
        if (map.get(word) != null)
            for (String s : map.get(word))
                backTrace(s, start, list);
        list.remove(0);
    }
}
