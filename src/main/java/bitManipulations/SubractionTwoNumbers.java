package bitManipulations;

/**
 * Created by m655222 on 12/21/2017.
 */

public class SubractionTwoNumbers {

    private static int add(int a, int b){
        while( b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static int subract(int a, int b){

        //The ~x is to get the 1's complement of x and then by adding 1, we get the 2's complement number.
        // This number will be the negative number of x.
        return add(a,add(~b,1));

    }

    public static void main(String args[]){

        System.out.println("5 - 2 ::" + subract(5,2));

        System.out.println("5 - 5 ::" + subract(5,5));

        System.out.println("0 - 2 ::" + subract(0,2));

    }
}
