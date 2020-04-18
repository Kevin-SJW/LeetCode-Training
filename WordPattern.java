package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname WordPattern
 * @Description TODO
 * @Date 2020/4/18 16:04
 * @Created by 14241
 */
public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat dog";
        System.out.println(wordPattern(pattern,str));

    }
    public static boolean wordPattern(String pattern, String str) {
        String[] words=str.split(" ");
        if(pattern.length()!=words.length){
            return false;
        }
        Map map=new HashMap<>();
        for(int i = 0; i<words.length; ++i){
            if(map.put(pattern.charAt(i),i)!=(map.put(words[i],i))){
                return false;
            }
        }
        return true;
    }
}
