package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DifferentWaysToAddParenthesis
 * @Description TODO
 * @Date 2020/4/12 15:52
 * @Created by 14241
 */
public class DifferentWaysToAddParenthesis {
    public static void main(String[] args) {
        String input="2-1-1";
        System.out.println(diffWaysToCompute(input));
//        diffWaysToCompute(input).stream().forEach(s-> System.out.print(s+" "));

    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch=='*'||ch=='-'||ch=='+') {
                String leftSub = input.substring(0, i);
                String rightSub = input.substring(i + 1);

                List<Integer> left = diffWaysToCompute(leftSub);
                List<Integer> right = diffWaysToCompute(rightSub);

                for (int j : left) {
                    for (int k : right) {
                        switch (ch) {
                            case '+':
                                res.add(j + k);
                                break;
                            case '-':
                                res.add(j - k);
                                break;
                            case '*':
                                res.add(j * k);
                                break;
                        }
                    }
                }
            }

        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}
