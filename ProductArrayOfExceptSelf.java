package leetcode;

import java.util.Arrays;

/**
 * @Classname ProductArrayOfExceptSelf
 * @Description TODO
 * @Date 2020/4/11 16:18
 * @Created by 14241
 */
public class ProductArrayOfExceptSelf {
    public static void main(String[] args) {
        int[] num={1,2,3,4};
        Arrays.stream(productExceptSelf(num)).forEach(t-> System.out.print(t+" "));

    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0, temp = 1; i < n; i++) {
            res[i] = temp;
            temp *= nums[i];
        }
        for (int i = n - 1, temp = 1; i >= 0; i--) {
            res[i] *= temp;
            temp *= nums[i];
        }
        return res;
    }
}
