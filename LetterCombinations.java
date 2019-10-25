package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname LetterCombinations
 * @Description phoneNumberCombinations
 * @Date 2019/10/25 15:43
 * @Created by 14241
 */
public class LetterCombinations {
    public static void main(String[] args) {
        String digits="23";
        System.out.println(letterCombinations(digits));

    }
    public static List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits==null||digits.length()==0){
            return null;
        }
        char[][] map = new char[8][];
        map[0]="abc".toCharArray();
        map[1]="def".toCharArray();
        map[2]="ghi".toCharArray();
        map[3]="jkl".toCharArray();
        map[4]="mno".toCharArray();
        map[5]="pqrs".toCharArray();
        map[6]="tuv".toCharArray();
        map[7]="wxyz".toCharArray();
        char[] input=digits.toCharArray();
        ans.add("");
        for(char c:input){
            ans=expand(ans,map[c-'2']);
        }
        return ans;

    }

    public static List<String> expand(List<String> list,char[] ch){
        List<String> next=new ArrayList<>();
        for(String l:list){
            for(char c:ch){
                next.add(l+c);
            }
        }
        return next;
    }

}
