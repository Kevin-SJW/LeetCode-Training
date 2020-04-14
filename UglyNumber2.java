package leetcode;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @Classname UglyNumber2
 * @Description TODO
 * @Date 2020/4/14 15:47
 * @Created by 14241
 * ugly是只能被2,3,5整除的数，要求求出第n个ugly数。通过观察可以发现：
 * 当前的数是由前面已存在的数乘以2/3/5，所以我们对每一个存在的数乘以2,3,5
 * 然后去重排序就可以产生后续的ugly数。用一个sortSet维护即可。ugly是只能被2,3,5整除的数，
 * 要求求出第n个ugly数。通过观察可以发现：当前的数是由前面已存在的数乘以2/3/5，
 * 所以我们对每一个存在的数乘以2,3,5然后去重排序就可以产生后续的ugly数。用一个sortSet维护即可。
 */
public class UglyNumber2 {
    public static void main(String[] args) {
        int n=10;
        System.out.println(nthUglyNumber(n));
    }
    public static int nthUglyNumber(int n) {
        if(n<=0){
            return 0;
        }
        SortedSet<Long> sortedSet=new TreeSet<>();
        sortedSet.add((long)1);
        long res;

        for(int i=0;i<n-1;i++){
            res=sortedSet.first();
            sortedSet.add(res*2);
            sortedSet.add(res*3);
            sortedSet.add(res*5);
            sortedSet.remove(res);
        }
        return (int)(long)sortedSet.first();

    }
}
