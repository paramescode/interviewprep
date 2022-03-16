package StackProblems;

import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/

/*
*Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

    Division between two integers should truncate toward zero.
    The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.

Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation:
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22


*
* **/

public class PolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String t : tokens){
            if( !isOperator(t) ){
                stack.push(Integer.parseInt(t));
            }else{
                Integer a = stack.pop();
                Integer b = stack.pop();
                if(t.equals("+")){
                    stack.push(a + b);
                }else if(t.equals("-")){
                    stack.push(b - a);
                }else if(t.equals("*")){
                    stack.push(a *  b);
                }else{
                    stack.push(b / a);
                }
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String t){
        if(t.equals("+") || t.equals("-") || t.equals("*") ||t.equals("/") )
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(
                evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})
        );
    }
}
