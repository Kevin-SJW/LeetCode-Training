package leetcode;

import java.util.Stack;

/**
 * @Classname EvaluateReversePolishNotation
 * @Description TODO
 * @Date 2020/3/12 15:27
 * @Created by 14241
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));

    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                if (token.equals("+")) {
                    stack.push(op2 + op1);
                }
                if (token.equals("-")) {
                    stack.push(op2 - op1);
                }
                if (token.equals("*")) {
                    stack.push(op2 * op1);
                }
                if (token.equals("/")) {
                    stack.push(op2 / op1);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        int res = stack.peek();
        return res;

    }
}
