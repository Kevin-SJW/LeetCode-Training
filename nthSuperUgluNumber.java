package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Classname nthSuperUgluNumber
 * @Description TODO
 * @Date 2020/4/28 15:49
 * @Created by 14241
 * 小顶堆
 */
public class nthSuperUgluNumber {
    public static void main(String[] args) {
        int n=12;
        int[] primes={2,7,13,19};
        System.out.println(nthSuperUglyNumber(n,primes));

    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        Queue<Long> q = new PriorityQueue<>();
        long res = 0L;
        q.offer(1L);
        while (n > 0) {
            res = q.poll();
            while (!q.isEmpty() && res==q.peek()) {
                res = q.poll();
            }
            for (int num : primes) {
                q.offer(res * num);
            }
            n--;
        }
        return (int)res;
    }
}
