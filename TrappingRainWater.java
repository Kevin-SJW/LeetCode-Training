package leetcode;

/**
 * @Classname TrappingRainWater
 * @Description TODO
 * @Date 2019/12/4 15:32
 * @Created by 14241
 * 我们使用两个指针，一个从左向右遍历，一个从右向左遍历。从左向右遍历时，
 * 记录下上次左边的峰值，如果右边一直没有比这个峰值高的，就已经加上这些差值。
 * 从右向左遍历时，记录下上次右边的峰值，如果左边一直没有比这个峰值高的，
 * 就加上这些差值。难点在于，当两个指针遍历到相邻的峰时，我们要选取较小的那个峰值来计算差值。
 * 所以，我们在遍历左指针或者右指针之前，要先判断左右两个峰值的大小。
 * <p>
 * 注意
 * 移动左指针或者右指针时，要先判断left < right
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));

    }

    public static int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int left = 0;
        int sum = 0;
        int right = height.length - 1;
        //找到左边的第一个峰值
        while (left < right && height[left] <= height[left + 1]) {
            left++;
        }
        //找到右边的第一个峰值
        while (left < right && height[right] <= height[right - 1]) {
            right--;
        }
        while (left < right) {
            int leftVal = height[left];
            int rightVal = height[right];
            // 如果左边峰值较小，先计算左边
            if (leftVal < rightVal) {
                while (left < right && leftVal >= height[++left]) {
                    sum += leftVal - height[left];
                }
                // 如果右边峰值较小，先计算右边
            } else {
                while (left < right && rightVal >= height[--right]) {
                    sum += rightVal - height[right];
                }
            }
        }
        return sum;
    }

}

