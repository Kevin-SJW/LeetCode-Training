package leetcode;

/**
 * @Classname NumArray
 * @Description TODO
 * @Date 2020/6/21 17:58
 * @Created by Administrator
 */
public class NumArray {
    // sum数组中存的是和，sum[i]存储了nums中前i个元素的和，sum[0] = 0;
    // sum[i]存储的实际是nums[0....i-1]的和，所以初始化长度要是nums.length+1
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i < sum.length; i++)
            // 转移方程，前i个元素和=前i-1个元素和加上第i个元素，注意sum和nums索引有一个偏移
            sum[i] = sum[i - 1] + nums[i - 1];
    }

    public int sumRange(int i, int j) {
        // 由于计算和是闭区间，所以要取到sum[j+1]表示nums中前j+1个数，即索引为j那个数和它之前的数的和,减去sum[i]，即是nums[i]到nums[j]的和。
        return sum[j + 1] - sum[i];
    }

}
