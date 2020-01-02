package leetcode;

import java.util.Arrays;

/**
 * @Classname PlusOne
 * @Description TODO
 * @Date 2020/1/2 15:37
 * @Created by 14241
 * Given a non-empty array of digits representing a non-negative integer,
 * plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero,
 * except the number 0 itself.
 * 先对原数组进行处理。从数组最后一位开始往前检查，如果当前数字是<9的，
 * 说明你加1无需进位，从循环跳出即可，如果当前数字等于9，说明加1涉及进位，
 * 且加1后当前数字应记为0，继续循环处理。
 * <p>
 * 当对原数组处理完后，还需要判断当前第0位是不是已经变为0了，
 * 如果已经变为0了说明是类似99+1这种，需要进位。其他则不需要。
 * <p>
 * 一般对数字进行操作的题都要考虑边界，尤其是溢出问题。
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        Arrays.stream(plusOne(digits)).forEach(System.out::print);

    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = 1 + digits[i];
            if (digits[i] == 10) {
                digits[i] = 0;

            } else {
                return digits;
            }
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;

        for (int i = 1; i < newDigits.length; i++) {
            newDigits[i] = digits[i - 1];
        }
        return newDigits;
    }
}
