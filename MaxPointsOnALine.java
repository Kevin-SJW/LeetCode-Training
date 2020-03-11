package leetcode;

/**
 * @Classname MaxPointsOnALine
 * @Description TODO
 * @Date 2020/3/11 16:20
 * @Created by 14241
 * Given n points on a 2D plane,
 * find the maximum number of points that lie on the same straight line.
 */

import java.util.HashMap;


//Definition for a point.
class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }

}


public class MaxPointsOnALine {
    public static void main(String[] args) {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(2, 2);
        Point point3 = new Point(3, 3);
        Point[] points = new Point[]{point1, point2, point3};

        System.out.println(maxPoints(points));
    }

    public static int maxPoints(Point[] points) {
        if (points.length <= 1)
            return points.length;
        int maxUniv = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            Point cur = points[i];
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int howManyCur = 1, maxLocal = 0;
            //这里可以从i+1开始，之前的都算过了
            for (int j = i + 1; j < points.length; j++) {
                Point iter = points[j];
                //同一顶点
                if (iter.x == cur.x && iter.y == cur.y) {
                    howManyCur += 1;
                } else {          //不同顶点
                    String key = getSlopeInString(cur, iter);
                    //map里存(过cur点,斜率key)代表的直线有多少除了cur的点
                    map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
                    maxLocal = Math.max(maxLocal, map.get(key));
                }
            }
            maxLocal = howManyCur + maxLocal;
            maxUniv = Math.max(maxLocal, maxUniv);
        }
        return maxUniv;
    }

    public static String getSlopeInString(Point cur, Point iter) {
        int numerator = iter.y - cur.y;
        int denominator = iter.x - cur.x;
        String sign = getSign(numerator, denominator);
        //0和任意一个非零数'a'的gcd为'a',0和0的gcd为0,所以斜率为无穷的情况分母为0
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        return sign + Math.abs(numerator) / gcd + "/" + Math.abs(denominator) / gcd;
    }

    //a和b为非负整数 且 a和b不同时为0
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static String getSign(int a, int b) {
        if (a <= 0 && b <= 0 || a >= 0 && b >= 0) {
            return "+";
        } else {
            return "-";
        }
    }
}
