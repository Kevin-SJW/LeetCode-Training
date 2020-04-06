package leetcode;

/**
 * @Classname RectangleArea
 * @Description TODO
 * @Date 2020/4/6 15:24
 * @Created by 14241
 */
public class RectangleArea {
    public static void main(String[] args) {
        int A=-3,B=0,C=3,D=4,E=0,F=-1,G=9,H=2;
        System.out.println(computeArea(A,B,C,D,E,F,G,H));

    }
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaOfA = (C - A) * (D - B);
        int areaOfB = (G - E) * (H - F);

        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);

        int overlap = 0;
        if(right > left && top > bottom)
            overlap = (right - left) * (top - bottom);
        return areaOfA + areaOfB - overlap;
    }
}
