package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname PalindromePatitioning
 * @Description TODO
 * @Date 2020/2/27 15:34
 * @Created by 14241
 * 使用DFS方法查找，每次查找字符串头可能的回文串，然后切割掉，继续查找剩余的字符串s，
 * 如果最后s.length ==0 ，
 * 那么说明字符串可以全部分割为回文串，满足条件。添加到结果集中。
 */
public class PalindromePatitioning {
    public static void main(String[] args) {
        String s="aab";
        List<List<String>> res=partition(s);
        for(List<String> list:res){
            for(String str:list){
                System.out.print(str +" ");
            }
            System.out.println();
        }

    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        if(s==null||s.length()==0){
            return res;
        }
        DFS(res,new ArrayList<>(),s);
        return res;

}

    public static void DFS(List<List<String>> res,List<String> list,String s){
        if(s.length()==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<s.length();i++){
            String str=s.substring(0,i+1);
            if(isPalindrome(str)){
                list.add(str);
                DFS(res,list,s.substring(str.length()));
                list.remove(list.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
