package leetcode;

import java.util.PriorityQueue;

/**
 * @Classname SuperUglyNumber
 * @Description TODO
 * @Date 2020/6/10 16:45
 * @Created by Administrator
 * Write a program to find the nth super ugly number.
 *
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k
 *(最小堆法)
 */
public class SuperUglyNumber {
    public static void main(String[] args) {
        int n=12;
        int[] primes={2,7,13,19};
        System.out.println(nthSuperUglyNumber(n,primes));

    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        long res=1;
        for(int i=1;i<n;i++){
            for(int prime:primes){
                pq.add(prime*res);
            }
            res=pq.poll();
            while(!pq.isEmpty()&&res==pq.peek()){
                pq.poll();
            }
        }
        return (int)res;
    }
}
