package leetcode;

import java.util.Arrays;

/**
 * @Classname Candy
 * @Description TODO
 * @Date 2020/3/4 15:09
 * @Created by 14241
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Candy {
    public static void main(String[] args) {
        int[] ratings={1,0,2};
        System.out.println(candy(ratings));

    }
    public static int candy(int[] ratings) {
        int[] candies=new int[ratings.length];
        Arrays.fill(candies,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }
        int sum=candies[ratings.length-1];
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i]=Math.max(candies[i+1]+1,candies[i]);
            }
            sum+=candies[i];
        }
        return sum;
    }
}
