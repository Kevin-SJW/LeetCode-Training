package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname CourseSchedule
 * @Description TODO
 * @Date 2020/3/30 15:08
 * @Created by 14241
 */
public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(canFinish(numCourses,prerequisites));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
            //Array-List
        List<Integer>[] nodes=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            nodes[i]=new ArrayList<>();
        }

        //count in degree
        int[] inDegrees=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            (nodes[prerequisites[i][0]]).add(prerequisites[i][1]);
            inDegrees[prerequisites[i][1]]+=1;
        }

        //count zero in degree
        int zeroInDegreeCount=0;
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<inDegrees.length;i++){
            if(inDegrees[i]<=0){
                queue.add(i);
                zeroInDegreeCount++;
            }
        }

        //bfs
        while(!queue.isEmpty()){
            for(Integer i:nodes[queue.poll()]){
                if(--inDegrees[i]<=0){
                    queue.add(i);
                    zeroInDegreeCount++;
                }
            }
        }
        return zeroInDegreeCount==numCourses;
    }
}
