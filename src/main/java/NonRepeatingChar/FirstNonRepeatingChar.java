package NonRepeatingChar;

import java.util.*;

/**
 * Created by m655222 on 5/25/2017.
 */
public class FirstNonRepeatingChar {

    public char firstNonRepeatingChar(String input){

        if(input == null || input.length() ==0){
            return 0;
        }

        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) != 32) {
                arr[input.charAt(i) - 'a'] = arr[input.charAt(i) - 'a'] + 1;
            }
        }

        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) != 32 && arr[input.charAt(i) - 'a'] == 1)
                return input.charAt(i);
        }
        return 0;

    }

    public static void main(String args[]){
        FirstNonRepeatingChar frc = new FirstNonRepeatingChar();
        System.out.println("First Non Repeating Char is :: " +
                frc.firstNonRepeatingChar("it is a beautiful world"));

        System.out.println("First Non Repeating Char is :: " +
                frc.firstNonRepeatingChar("abcdefghijklmna"));

        System.out.println("First Non Repeating Char is :: " +
                frc.firstNonRepeatingChar("abcdefghijklmn"));
    }
}
