package leetcode;

import java.util.Arrays;

/**
 * @Classname TwoSum2InputArrayIsSorted
 * @Description TODO
 * @Date 2020/3/18 15:21
 * @Created by 14241
 */
public class TwoSum2InputArrayIsSorted {
    public static void main(String[] args) {
        int[] numbers={2,7,11,15};
        int target=9;
        Arrays.stream(twoSum(numbers,target)).forEach(System.out::print);

    }

    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                int[] res = new int[]{l + 1, r + 1};
                return res;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }

        }
        throw new RuntimeException("the input has no solution");
    }
}
