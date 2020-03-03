package leetcode;

/**
 * @Classname GasStation
 * @Description TODO
 * @Date 2020/3/3 15:38
 * @Created by 14241
 * here are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas,cost));

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int j = -1;
        for (int i = 0; i < gas.length; i++) {
            sum = gas[i] - cost[i];
            total = gas[i] - cost[i];
            //之前的油量不够到达当前加油站
            if (sum < 0) {
                j = i;
                sum = 0;
            }
        }
        //所有加油站的油量都不够整个路程的消耗
        if (total < 0) {
            return -1;
        } else {
            return j + 1;
        }
    }
}
