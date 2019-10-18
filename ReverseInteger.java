package leetcode;

/**
 * @Classname ReverseInteger
 * @Description TODO
 * @Date 2019/10/18 15:39
 * @Created by 14241
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int x=123;
        System.out.println(reverse(x));

    }
    public static int reverse(int x){
        int res=0;
        while(x!=0){
            res=res*10+x%10;
            x/=10;
        }
        if(res<Integer.MIN_VALUE||res>Integer.MAX_VALUE){
            return 0;
        }else{
            return res;
        }
    }
}
