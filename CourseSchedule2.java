package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname CourseSchedule2
 * @Description TODO
 * @Date 2020/3/31 15:43
 * @Created by 14241
 */
public class CourseSchedule2 {
    public static void main(String[] args) {
        int numCourses=2;
        int[][] prerequisites={{1,0}};
        Arrays.stream(findOrder(numCourses, prerequisites)).forEach(t->{
            System.out.print(t+" ");
        });

    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] map = new int[numCourses];
        int n = prerequisites.length;
        int[] res = new int[numCourses];

        for(int i=0; i<n; i++) {
            map[ prerequisites[i][1] ] ++;
        }

        Queue<Integer> que = new LinkedList<Integer>();
        int index = numCourses-1;
        for(int i=0; i<numCourses; i++) {
            if(map[i] == 0) {
                que.add(i);
                res[index--] = i;
            }
        }

        while(!que.isEmpty() ){
            int k = que.remove();
            for(int i=0; i<n; i++) {
                int l = prerequisites[i][1];
                if(k==prerequisites[i][0]) {
                    map[l]--;
                    if(map[l] == 0) {
                        que.add(l);
                        res[index--] = l;
                    }
                }
            }
        }
        if(index!=-1) return new int[0];
        else return res;
    }
}
