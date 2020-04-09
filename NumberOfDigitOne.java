package leetcode;

/**
 * @Classname NumberOfDigitOne
 * @Description TODO
 * @Date 2020/4/9 14:51
 * @Created by 14241
 */
public class NumberOfDigitOne {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(countDigitOne(n));

    }

    public static int countDigitOne(int n) {
        if (n <= 0) return 0;
        int q = n;
        int x = 1;
        int ans = 0;
        int temp = 0;
        do {
            temp = q % 10;
            q /= 10;
            if (temp == 0) ans += q * x;
            else if (temp == 1) ans += q * x + n % x + 1;
            else
                ans += (q + 1) * x;
            x *= 10;
        } while (q > 0);
        return ans;

    }
}
