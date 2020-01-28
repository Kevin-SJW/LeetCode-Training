package leetcode;

import java.util.Arrays;

/**
 * @Classname ScrambleString
 * @Description TODO
 * @Date 2020/1/28 16:07
 * @Created by 14241
 * “简单的说，就是s1和s2是scramble的话，那么必然存在一个在s1上的长度l1，
 *  将s1分成s11和s12两段，同样有s21和s22。
 *  那么要么s11和s21是scramble的并且s12和s22是scramble的；
 *  要么s11和s22是scramble的并且s12和s21是scramble的。”
 */
public class ScrambleString {
    public static void main(String[] args) {
        String s1 = "great", s2 = "rgeat";
        System.out.println(isScramble(s1,s2));

    }
    public static boolean isScramble(String s1, String s2) {
        if(s1.length()!= s2.length()){
            return false;
        }
        if(s1.length()==1&&s2.length()==1){
            return s1.charAt(0)==s2.charAt(0);
        }
        char[] t1=s1.toCharArray(),t2=s2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        if(!new String(t1).equals(new String(t2))){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        for(int split=1;split<s1.length();split++){
            String s11=s1.substring(0,split);
            String s12=s1.substring(split);

            String s21=s2.substring(0,split);
            String s22=s2.substring(split);
            if(isScramble(s11,s21)&&isScramble(s12,s22)){
                return true;
            }
            s21=s2.substring(0,s2.length()-split);
            s22=s2.substring(s2.length()-split);
            if(isScramble(s11,s22)&&isScramble(s21,s12)){
                return true;
            }

        }
        return false;
    }
}
