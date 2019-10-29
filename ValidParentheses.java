package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Classname ValidParentheses
 * @Description TODO
 * @Date 2019/10/29 15:06
 * @Created by 14241
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                    return false;
                }

            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
