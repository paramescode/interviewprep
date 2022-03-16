package StackProblems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//https://leetcode.com/problems/basic-calculator-iii/

public class BasicCalculatorIII {

    public static int calculate(String s) {
        Deque<Character> q = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            q.add(c);
        }

        return calc(q);

    }


    private static int calc(Deque<Character> q){
        Stack<Integer> stack = new Stack<>();
        int num = 0, res =0;
        char sign = '+';

        while( !q.isEmpty()){

            char c = q.poll();
            if(c >='0' && c<= '9'){
                num = num * 10  + c - '0';
            }else if(c == '('){
                num = calc( q);
            }

            if(isOp(c) || c == ')' || q.isEmpty() ){
                if(sign == '+'){
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(-num);
                }else if(sign == '*'){
                    int pvalue = stack.pop();
                    stack.push(pvalue * num);
                }else if(sign == '/'){
                    int pvalue = stack.pop();
                    stack.push(pvalue / num);
                }

                num = 0;
                sign = c;
                if(c == ')')
                    break;
            }
        }

        for(int i : stack){
            res += i;
        }

        return res;

    }

    private static boolean isOp(char c){
        if(c == '+' || c == '-' || c == '*' || c == '/'){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
    }



}
