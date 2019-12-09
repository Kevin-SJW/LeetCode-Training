package leetcode;

/**
 * @Classname JumpGame2
 * @Description TODO
 * @Date 2019/12/9 14:38
 * @Created by 14241
 * Given an array of non-negative integers,
 *
 * you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 */
public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        System.out.println(jump(nums));

    }
    public static int jump(int[] nums) {
        int jmp = 0;
        // destination index
        int dest = nums.length - 1;

        // 不断向前移动dest
        while(dest != 0){
            for(int i = 0; i < dest; i++){
                // 说明从i位置能1步到达dest的位置
                if(i + nums[i] >= dest){
                    // 更新dest位置，下一步就是计算要几步能调到当前i的位置
                    dest = i;
                    jmp++;
                    // 没必要再继续找，因为越早找到的i肯定越靠前，说明这一跳的距离越远
                    break;
                }
            }
        }
        return jmp;

    }
}
