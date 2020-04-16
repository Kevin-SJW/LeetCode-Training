package leetcode;

/**
 * @Classname H_index2
 * @Description TODO
 * @Date 2020/4/16 18:39
 * @Created by 14241
 */
public class H_index2 {
    public static void main(String[] args) {
        int[] citations={3,0,6,1,5};
        System.out.println(hIndex(citations));

    }
    public static int hIndex(int[] citations){
        int l=0,r=citations.length;

        while(l<r){
            int mid=l+r+1>>1;
            if(citations[citations.length-mid]>=mid){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return r;
    }
}
