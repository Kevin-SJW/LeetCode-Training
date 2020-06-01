package leetcode;

/**
 * @Classname IntegerBreak
 * @Description TODO
 * @Date 2020/6/1 15:45
 * @Created by Administrator
 */
public class IntegerBreak {
    public static void main(String[] args) {
        int n=10;
        System.out.println(integerBreak(n));

    }
    public static int integerBreak(int n) {
        if(n==1){
            return 0;
        }
        if(n<=3){
            return n-1;
        }
        int res=1;
        while(n>4){
            n-=3;
            res*=3;
        }
        return res*n;
    }
}
