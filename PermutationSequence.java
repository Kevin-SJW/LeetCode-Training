package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PermutationSequence
 * @Description TODO
 * @Date 2019/12/24 14:52
 * @Created by 14241
 * 先把1到n的每个数存入list中，然后后边写一个数字，就可以从里面删掉一个了。
 * n个数字有n!个排列方式，n-1就有(n-1)！个排列方式，
 * 为了和下标保持一致，需要k--，k/（n-1）！是当前字符的下标（注意是从零开始啊，下标0对应的数字1）
 * 下一次的k就可以更新为 k%(n-1)!，循环n次
 * 需要一个times表示每次更新阶乘的除数。
 */
public class PermutationSequence {
    public static void main(String[] args) {
        int n=4,k=9;
        System.out.println(getPermutation(n,k));

    }
    public static String getPermutation(int n, int k) {
        k--;
        //注意存储1-n
        List<Integer> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        int times=n-1;
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int factorail=1;
        for(int i=2;i<n;i++){
            //阶乘
            factorail*=i;
        }
        while(times>=0){
            int indexList=k/factorail;
            sb.append(list.get(indexList));
            list.remove(indexList);
            k=k%factorail;
            if(times!=0){
                factorail/=times;
            }
            times--;
        }
        return sb.toString();
    }
}
