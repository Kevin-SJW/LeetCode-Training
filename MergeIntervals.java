package leetcode;

import java.util.Arrays;
import java.util.Comparator;

import static leetcode.SpiralMatrix.printMatrix;

/**
 * @Classname MergeIntervals
 * @Description TODO
 * @Date 2019/12/19 14:49
 * @Created by 14241
 * Given a collection of intervals, merge all overlapping intervals.
 */
public class MergeIntervals {
    public static void main(String[] args) {

        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        printMatrix(merge(intervals));
        System.out.println();


    }

    public static int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return intervals;
        }
        Arrays.sort(intervals,0,intervals.length,new ArrayComparater());
        int curIndex=0;
        for(int i=1;i<intervals.length;i++){
            //only reserve intervals[i-1]
            if(intervals[curIndex][1]>=intervals[i][1]){
                continue;
            }
            //integret
            if(intervals[curIndex][1]>=intervals[i][0]){
                intervals[curIndex][1]=intervals[i][1];
                //no interval
            }else{
                curIndex++;
                intervals[curIndex][0]=intervals[i][0];
                intervals[curIndex][1]=intervals[i][1];
            }

        }
        curIndex++;
        int[][] ret=new int[curIndex][2];
        System.arraycopy(intervals,0,ret,0,curIndex);
        return ret;

    }

    static class ArrayComparater implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            int[] a = (int[]) o1;
            int[] b = (int[]) o2;
            if (a[0] > b[0]) {
                //ascending order
                return 1;
            } else if (a[0] < b[0]) {
                return -1;
            } else {
                return 0;
            }

        }
    }
}
