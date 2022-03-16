package StackProblems;

import java.util.Stack;

//https://leetcode.com/problems/basic-calculator-ii/


public class BasicCalculaterII {

    public static int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int sum =0, res = 0 ;
        char sign = '+';
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                sum = sum * 10 + c - '0';
            }

            if(! Character.isDigit(c) &&  c != ' ' || i == s.length() - 1){
                if(sign == '+'){
                    stack.push(sum);
                }else if(sign == '-'){
                    stack.push(-sum);
                }else if(sign == '*'){
                    int pvalue = stack.pop();
                    stack.push(pvalue * sum);
                }else if(sign == '/'){
                    int pvalue = stack.pop();
                    stack.push(pvalue / sum);
                }
                sum =0;
                sign = c;
            }


        }

        for(int i=0; i < stack.size() ; i++){
            res += stack.elementAt(i);
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3+5 / 2 "));
    }
}
