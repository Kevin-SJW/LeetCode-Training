package leetcode;

import java.util.*;

/**
 * @Classname WordLadder
 * @Description TODO
 * @Date 2020/2/24 15:06
 * @Created by 14241
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note that beginWord is not a transformed word.
 * 只使用一个Queue的BFS，用一个queue来保存某一层所有可能的情况，
 * 这样当发现等于endWord时，就可以直接返回结果。
 */
public class WordLadder {
    public static void main(String[] args) {
       String beginWord = "hit";
       String endWord = "cog";
       List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord,endWord,wordList));

    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        queue.add(null);
        set.add(beginWord);
        int level=1;
        while(!queue.isEmpty()){
            String now=queue.poll();
            if(now!=null){
                for(int i=0;i<wordList.size();i++){
                    if(onlyOneWord(now,wordList.get(i))){
                        if(!set.contains(wordList.get(i))){
                            if(wordList.get(i).equals(endWord)){
                                return level+1;
                            }
                            queue.add(wordList.get(i));
                            set.add(wordList.get(i));
                        }
                    }
                }
            }else{
                //遍历完一层
                level++;
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }

        }
        return 0;



    }

    public static boolean onlyOneWord(String s1,String s2){
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
            }
        }
        return count==1;
    }
}
