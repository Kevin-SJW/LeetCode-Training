package leetcode;

import AutumnRecruitment.chap3_5.In;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname RestoreIpAddress
 * @Description TODO
 * @Date 2020/2/3 14:22
 * @Created by 14241
 * Given a string containing only digits,
 * restore it by returning all possible valid IP address combinations.
 * 这里IP的特性是最大数字不能超过255。
 * 比上个方法好的地方在于a+b+c+d= s.length()才会判断数字是否合法，
 * 避免了很多1+1+1+N这种不需要检查的情况。
 */
public class RestoreIpAddress {
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));

    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        StringBuffer ip = new StringBuffer();
        for (int a = 1; a < 4; ++a) {
            for (int b = 1; b < 4; ++b) {
                for (int c = 1; c < 4; ++c) {
                    for (int d = 1; d < 4; ++d) {
                        if (a + b + c + d == s.length()) {
                            int n1 = Integer.parseInt(s.substring(0, a));
                            int n2 = Integer.parseInt(s.substring(a, a + b));
                            int n3 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int n4 = Integer.parseInt(s.substring(a + b + c));
                            if (n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
                                ip.append(n1).append('.').append(n2).append('.')
                                        .append(n3).append('.').append(n4);
                                if (ip.length() == s.length() + 3) {
                                    res.add(ip.toString());
                                }
                                ip.delete(0, ip.length());
                            }
                        }
                    }
                }
            }
        }
        return res;


    }
}
