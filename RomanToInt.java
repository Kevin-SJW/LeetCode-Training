package leetcode;

import java.util.HashMap;

/**
 * @Classname RomanToInt
 * @Description TODO
 * @Date 2019/10/23 15:20
 * @Created by 14241
 */
public class RomanToInt {
    public static void main(String[] args) {
        String s="III";
        System.out.println(romanToInt(s));

    }
    public static int romanToInt(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)<s.charAt(i+1)){
                sum-=map.get(s.charAt(i));
            }else{
                sum+=map.get(s.charAt(i));
            }
        }
        sum+=map.get(s.charAt(s.length()-1));
        return sum;
    }
}
