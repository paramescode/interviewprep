package Parenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/



public class MinRemoveToMakeValidString {

    public static String minRemoveToMakeValid(String s) {


        Stack<Integer> stack = new Stack<>();
        List<Integer> skipIndexes = new ArrayList<>();

        for(int i=0;i < s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(i);
            else if(s.charAt(i) == ')'){
                if(!stack.isEmpty())
                    stack.pop();
                else
                    skipIndexes.add(i);

            }
        }

        //for remaining ( brackets... if any
        while(!stack.isEmpty()){
            skipIndexes.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < s.length() ; i++){
            if(!skipIndexes.contains(i))
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}
