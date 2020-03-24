package leetcode;

/**
 * @Classname ReverseBits
 * @Description TODO
 * @Date 2020/3/24 15:45
 * @Created by 14241
 * 00000010100101000001111010011100
 * 用一个temp来存n的最后一位，通过n&1就能取到最后一位，然后n进行右移一位，
 * 然后把result进行左移，并把temp放在后面。如此循环31次。
 */
public class ReverseBits {
    public static void main(String[] args) {



    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 1; i < 31; i++) {
            int temp = n & 1;
            n = (n >> 1);
            result = (result << 1) | temp;
        }
        return result;

    }
}
