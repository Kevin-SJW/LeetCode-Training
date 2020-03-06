package leetcode;

import java.util.*;

/**
 * @Classname WordBreak2
 * @Description TODO
 * @Date 2020/3/6 15:22
 * @Created by 14241
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 */
public class WordBreak2 {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> list=wordBreak(s,wordDict);
        for(String str:list){
            System.out.print(str+" ");
        }


    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s,wordDict,new HashMap<>());

    }
    public static List<String> DFS(String s, List<String> wordDict, Map<String, ArrayList<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        ArrayList<String> res=new ArrayList<>();
        if(s.length()==0){
            res.add("");
            return res;
        }
         for(String subStr:wordDict){
             if(s.startsWith(subStr)){
                 for(String str:DFS(s.substring(subStr.length()),wordDict,map)){
                     res.add(subStr+(str==""?"":" ")+str);
                 }
             }
         }
         map.put(s,res);
         return res;

    }
}
