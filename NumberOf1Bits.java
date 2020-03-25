package leetcode;

/**
 * @Classname NumberOf1Bits
 * @Description TODO
 * @Date 2020/3/25 15:09
 * @Created by 14241
 * Write a function that takes an unsigned integer
 * and return the number of '1' bits it has (also known as the Hamming weight).
 */
public class NumberOf1Bits {
    public static void main(String[] args) {

    }
    public static int hammingWeight(int n) {
        int bits=0;
        int mask=1;
        for(int i=0;i<32;i++){
            while((n&mask)!=0){
                bits++;
            }
            mask<<=1;
        }
        return bits;
    }
}
