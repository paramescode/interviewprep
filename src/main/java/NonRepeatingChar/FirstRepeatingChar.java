package NonRepeatingChar;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by m655222 on 5/25/2017.
 */
public class FirstRepeatingChar {

    //String input = "it is a beautiful world";

    public char findFirstRepeatingChar(String input){

        if(input == null || input.length() ==0){
            return 0;
        }

        Set<Character> set = new HashSet<Character>();
        for(int index =0; index < input.length() ; index ++){
            if(!set.add(Character.valueOf(input.charAt(index)))){
                return input.charAt(index);
            }
        }
        return 0;
    }

    public static void main(String args[]){
        FirstRepeatingChar frc = new FirstRepeatingChar();
        System.out.println("First Repeating Char is :: " +
                frc.findFirstRepeatingChar("it is a beautiful world"));

        System.out.println("First Repeating Char is :: " +
                frc.findFirstRepeatingChar("abcdefghijklmna"));

        System.out.println("First Repeating Char is :: " +
                frc.findFirstRepeatingChar("abcdefghijklmn"));
    }
}
