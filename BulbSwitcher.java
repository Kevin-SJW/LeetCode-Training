package leetcode;

/**
 * @Classname BulbSwitcher
 * @Description TODO
 * @Date 2020/5/1 15:55
 * @Created by 14241
 */
public class BulbSwitcher {
    public static void main(String[] args) {
        int n=3;
        System.out.println(bulbSwitch(n));

    }
    public static int bulbSwitch(int n) {
        if(n<1) return 0;
        return (int)Math.sqrt(n);
    }
}
