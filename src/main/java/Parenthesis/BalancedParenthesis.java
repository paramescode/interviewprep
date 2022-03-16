package Parenthesis;

/**
 * Created by m655222 on 5/25/2017.
 */
public class BalancedParenthesis {

    public boolean isBalancedParenthesis(String input){

        if(input == null || input.length() < 2){
            return false;
        }
        char[] parenArray = new char[] {};
        int arrayIndex = 0;
        for(int index =0 ; index < input.length() ; index++){
            if(input.charAt(index) == '('){
                //parenArray[arrayIndex] = input.charAt(index);
                arrayIndex ++;
            }else if(input.charAt(index) == ')'){
                if (arrayIndex == 0)
                    return false;
                else{
                    //parenArray[--arrayIndex] =
                    --arrayIndex;
                }

            }
        }
        if(arrayIndex == 0){
            return  true;
        }

        return false;
    }

    public static void main(String args[]){
        BalancedParenthesis bp = new BalancedParenthesis();
        System.out.println("Is balanced :: " + bp.isBalancedParenthesis("1+2"));
        System.out.println("Is balanced :: " + bp.isBalancedParenthesis("(1+2"));
        System.out.println("Is balanced :: " + bp.isBalancedParenthesis("(1+2)"));
        System.out.println("Is balanced :: " + bp.isBalancedParenthesis("(1+2)*3+(4/2)"));
        System.out.println("Is balanced :: " + bp.isBalancedParenthesis("1+2)))"));
        System.out.println("Is balanced :: " + bp.isBalancedParenthesis("(((((1+2"));
        System.out.println("Is balanced :: " + bp.isBalancedParenthesis(""));
    }
}
