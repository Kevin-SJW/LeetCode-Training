package leetcode;

/**
 * @Classname BitwiseAndOfNumbersRange
 * @Description TODO
 * @Date 2020/3/27 15:28
 * @Created by 14241
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 * 通过不断地右移直到两个数字相等，然后再左移相同的位数，这样做的效果其实就是将位置不相同的都置为0
 */
public class BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        int m=5,n=7;
        System.out.println(rangeBitwiseAnd(m,n));

    }
    public static int rangeBitwiseAnd(int m, int n) {
        int count=0;
        while(m!=n){
            m=m>>1;
            n=n>>1;
            count++;

        }
        m=m<<count;
        return m;
    }
}
