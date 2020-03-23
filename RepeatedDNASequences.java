package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname RepeatedDNASequences
 * @Description TODO
 * @Date 2020/3/23 15:49
 * @Created by 14241
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA,
 * it is sometimes useful to identify repeated sequences within the DNA.
 */
public class RepeatedDNASequences {
    public static void main(String[] args) {
        String s="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> str=findRepeatedDnaSequences(s);
        System.out.print(str);



    }
    public static List<String> findRepeatedDnaSequences(String s) {
            List<String> res=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<s.length()-9;i++){
            String subString=s.substring(i,i+10);
            if(map.containsKey(subString)){
                int count=map.get(subString);
                if(count==1){
                    map.remove(subString);
                    map.put(subString,2);
                    res.add(subString);
                }
            }else{
                map.put(subString,1);
            }
        }
        return res;
    }
}
