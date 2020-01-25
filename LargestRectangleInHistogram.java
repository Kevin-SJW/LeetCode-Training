package leetcode;

/**
 * @Classname LargestRectangleInHistogram
 * @Description TODO
 * @Date 2020/1/25 16:57
 * @Created by 14241
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));

    }
    public static int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=0;
        for(int i=0;i<n;i++){
            int minHeight=heights[i];
            for(int j=i;j<n;j++){
                minHeight=Math.min(minHeight,heights[j]);
                maxArea=Math.max(maxArea,(j-i+1)*minHeight);
            }
        }
        return maxArea;
    }
}
