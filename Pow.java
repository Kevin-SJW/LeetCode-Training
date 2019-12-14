package leetcode;

/**
 * @Classname Pow
 * @Description TODO
 * @Date 2019/12/14 15:34
 * @Created by 14241
 */
public class Pow {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));

    }

    public static double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;

            }
            x *= x;
        }
        return res < 0 == true ? 1 / res : res;
    }
}
