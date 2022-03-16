package StackProblems;

import java.util.Stack;


//https://leetcode.com/problems/basic-calculator/submissions/

/*
*Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2

Example 2:

Input: " 2-1 + 2 "
Output: 3

Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
*
* */
public class BasicCalculator {

    public static int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> signstack = new Stack<>();

        int csum =0, cnum = 0, sign =1;

        for(int i=0;i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == ' ')
                continue;
            else if(c >= '0' && c<= '9'){
                cnum = cnum * 10 + c- '0';
            }else if(c == '+'){
                csum += cnum * sign;
                cnum =0;
                sign =1;
            }else if(c == '-'){
                csum += cnum * sign;
                cnum = 0;
                sign = -1;
            }else if(c == '('){
                stack.push(csum);
                signstack.push(sign);
                cnum = 0;
                csum = 0;
                sign =1;
            }else{
                csum += cnum * sign;
                int prevSum = stack.pop();
                int prevSign = signstack.pop();
                prevSum += prevSign * csum;
                csum = prevSum;
                cnum = 0;
            }
        }

        return csum + (sign* cnum) ;
    }

    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

}
