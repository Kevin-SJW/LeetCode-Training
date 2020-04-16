package leetcode;

import java.util.Arrays;

/**
 * @Classname H_index
 * @Description TODO
 * @Date 2020/4/16 18:18
 * @Created by 14241
 */
public class H_index {
    public static void main(String[] args) {
        int[] citations={3,0,6,1,5};
        System.out.println(hIndex(citations));

    }
    public static int hIndex(int[] citations) {
        int res=0;
        Arrays.sort(citations);
        int len=citations.length;
        for(int i=len-1;i>=0;i--){
            if(citations[i]>=len-i){
                res=len-i;
            }else{
                break;
            }
        }
        return res;
    }
}
