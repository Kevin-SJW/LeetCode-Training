package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname HappyNumber
 * @Description TODO
 * @Date 2020/3/27 15:39
 * @Created by 14241
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 */
public class HappyNumber {
    public static void main(String[] args) {
        int n=19;
        System.out.println(isHappy(n));

    }

    public static boolean isHappy(int n) {
        int sum;
        int remin;
        int num = n;
        Set<Integer> set = new HashSet<>();

        while (set.add(num)) {
            sum = 0;
            while (num > 0) {
                remin = num % 10;
                sum += remin * remin;
                num /= 10;
            }
            if (sum == 1) {
                return true;
            }
            num=sum;
        }

        return false;
    }
}
