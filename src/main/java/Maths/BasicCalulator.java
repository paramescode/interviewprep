package Maths;

import java.util.Stack;

public class BasicCalulator {

    public int calculate(String exp){
        int result =0, number =0, sign =1;

        Stack<Integer> stack = new Stack<Integer>();

        for(int index =0 ; index < exp.length() ; index++){

            if(Character.isDigit(exp.charAt(index))){
                number += 10 * number + (int) (exp.charAt(index) - '0');
            }else if(exp.charAt(index) == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(exp.charAt(index) == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(exp.charAt(index) == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign  = 1;
            }else if(exp.charAt(index) == ')'){
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }

        }
        if(number !=0 )
            result += sign * number;
        return result;
    }

    public static void main(String[] args) {
        BasicCalulator calulator = new BasicCalulator();
        System.out.println(calulator.calculate("1+2+((6-3)+(9+3))"));
    }
}
