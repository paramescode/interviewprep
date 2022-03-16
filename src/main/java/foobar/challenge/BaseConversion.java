package foobar.challenge;



import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

/***
 *
 * Commander Lambda uses an automated algorithm to assign minions randomly to tasks, in order to keep her minions on their toes. But you've noticed a flaw in the algorithm - it eventually loops back on itself, so that instead of assigning new minions as it iterates, it gets stuck in a cycle of values so that the same minions end up doing the same tasks over and over again. You think proving this to Commander Lambda will help you make a case for your next promotion.

 You have worked out that the algorithm has the following process:

 1) Start with a random minion ID n, which is a nonnegative integer of length k in base b
 2) Define x and y as integers of length k.  x has the digits of n in descending order, and y has the digits of n in ascending order
 3) Define z = x - y.  Add leading zeros to z to maintain length k if necessary
 4) Assign n = z to get the next minion ID, and go back to step 2

 For example, given minion ID n = 1211, k = 4, b = 10, then x = 2111, y = 1112 and z = 2111 - 1112 = 0999. Then the next minion ID will be n = 0999 and the algorithm iterates again: x = 9990, y = 0999 and z = 9990 - 0999 = 8991, and so on.

 Depending on the values of n, k (derived from n), and b, at some point the algorithm reaches a cycle, such as by reaching a constant value. For example, starting with n = 210022, k = 6, b = 3, the algorithm will reach the cycle of values [210111, 122221, 102212] and it will stay in this cycle no matter how many times it continues iterating. Starting with n = 1211, the routine will reach the integer 6174, and since 7641 - 1467 is 6174, it will stay as that value no matter how many times it iterates.

 Given a minion ID as a string n representing a nonnegative integer of length k in base b, where 2 <= k <= 9 and 2 <= b <= 10, write a function solution(n, b) which returns the length of the ending cycle of the algorithm above starting with n. For instance, in the example above, solution(210022, 3) would return 3, since iterating on 102212 would return to 210111 when done in base 3. If the algorithm reaches a constant, such as 0, then the length is 1.

 Languages
 =========

 To provide a Java solution, edit Solution.java
 To provide a Python solution, edit solution.py

 Test cases
 ==========
 Your code should pass the following test cases.
 Note that it may also be run against hidden test cases not shown here.

 -- Java cases --
 Input:
 Solution.solution('210022', 3)
 Output:
 3

 Input:
 Solution.solution('1211', 10)
 Output:
 1
 *
 *
 * ***/
public class BaseConversion {


    static List<String> seen = new ArrayList<>();
    public static int solution(String n, int b) {
        //Your code here
        if(n == null || n.length() ==0)
            return 0;

        int k = n.length();
        if( k< 2 || k > 9 || b < 2 || b > 10)
            return 0;

        int value = Integer.parseInt(n, b);

        if(value ==0)
            return 0;

        List<Integer> digits = new ArrayList<>();
        for (char c : n.toCharArray()){
            digits.add(Integer.parseInt(String.valueOf(c),b));
        }
        Collections.sort(digits, Collections.reverseOrder());
        int x = createNumberFrom(digits, b);

        Collections.sort(digits);
        int y = createNumberFrom(digits, b);
        int z = x - y;

        if(z ==0)
            return 1;

        String newN = Integer.toString(z, b);

        int numOfZerosTobeAdded = n.length() - newN.length();
        for(int i=0 ; i < numOfZerosTobeAdded ; i ++){
            newN = "0" + newN;
        }
        if(!seen.contains(newN))
            seen.add(newN);
        else
            return seen.size() - seen.indexOf(newN);

        return solution(newN, b);
    }

    private static int createNumberFrom(List<Integer> digits, int b){
        String strValue= "";
        for (Integer val : digits) {
            strValue += val.toString();
        }
        return Integer.parseInt(strValue, b);
    }



    public static void main(String[] args)
    {
        String number = "210022"; // Number
        int sBase = 3; // Source Base Octal
        int dBase = 10; // Destination Base Decimal
        System.out.println("Source to target: "
                + baseConversion(number, sBase, dBase));
        //dBase = 16; // Destination Base Hexadecimal
        //System.out.println("Octal to Hex: "
        //        + baseConversion(number, sBase, dBase));

        System.out.println( solution("210022", 3));
    }



    public static String baseConversion(String number,
                                        int sBase, int dBase)
    {
        // Parse the number with source radix
        // and return in specified radix(base)
        int n1 = Integer.parseInt(number, sBase);
        System.out.println(n1);
        return Integer.toString(n1, dBase);
    }
}
