package leetcode;

import java.util.Arrays;

/**
 * @Classname ThreeSumClosest
 * @Description TODO
 * @Date 2019/10/25 15:00
 * @Created by 14241
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] num = {-1, 2, 1, -4};
        int target=1;
        System.out.println(threeSumClosest(num,target));
    }

    public static int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
            return 0;
        }
        Arrays.sort(num);
        int ret = 0;
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int l = i + 1, r = num.length - 1;
            int sum = num[i] + num[l] + num[r];
            if (sum < target) {
                if (target - sum < diff) {
                    diff = target - sum;
                    ret = sum;
                }
                l++;

            } else if (sum > target) {
                if (sum - target < diff) {
                    diff = sum - target;
                    ret = sum;
                }
                r--;
            } else {
                return sum;
            }

        }
        return ret;
    }
}
