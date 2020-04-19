package leetcode;

/**
 * @Classname NimGame
 * @Description TODO
 * @Date 2020/4/19 16:23
 * @Created by 14241
 */
public class NimGame {
    public static void main(String[] args) {
        int n=4;
        System.out.println(canWinNim(n));
    }
    public static boolean canWinNim(int n) {
        int val = n%4;
        if(val >= 1 && val <= 3)
            return true;
        return false;
    }
}
