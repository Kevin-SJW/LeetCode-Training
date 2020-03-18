package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Classname FractionToRecurringDecimal
 * @Description TODO
 * @Date 2020/3/18 15:11
 * @Created by 14241
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 */
public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        int numerator = 1, denominator = 2;
        System.out.println(fractionToDecimal(numerator,denominator));

    }
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 && denominator > 0)
            sb.append("-");
        else if (numerator > 0 && denominator < 0)
            sb.append("-");
        Long Lnumerator = (long) numerator;
        if (Lnumerator < 0)
            Lnumerator = -Lnumerator;
        Long Ldenominator = (long) denominator;
        if (Ldenominator < 0)
            Ldenominator = -Ldenominator;
        if (Lnumerator % Ldenominator == 0){
            sb.append(Lnumerator / Ldenominator);
            return sb.toString();
        }
        sb.append(Lnumerator / Ldenominator + ".");
        System.out.println(Lnumerator);
        Lnumerator %= Ldenominator;
        System.out.println(Lnumerator);
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        map.put(Lnumerator, 0);
        while (true) {
            Lnumerator *= 10;
            while (Lnumerator < Ldenominator) {
                list.add(0);
                map.put(Lnumerator, list.size());
                Lnumerator *= 10;
            }
            list.add((int) (Lnumerator / Ldenominator));
            Lnumerator %= Ldenominator;
            if (Lnumerator == 0) {
                for (int i = 0; i < list.size(); i++)
                    sb.append(list.get(i));
                return sb.toString();
            } else if (map.containsKey(Lnumerator)) {
                for (int i = 0; i < map.get(Lnumerator); i++)
                    sb.append(list.get(i));
                sb.append("(");
                for (int i = map.get(Lnumerator); i < list.size(); i++)
                    sb.append(list.get(i));
                sb.append(")");
                return sb.toString();
            }
            map.put(Lnumerator, list.size());
        }
    }
}
