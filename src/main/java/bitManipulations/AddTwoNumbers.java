package bitManipulations;

/**
 * Created by m655222 on 12/21/2017.
 */
public class AddTwoNumbers {

    // https://www.quora.com/How-do-you-do-multiplication-and-division-using-bitwise-operator-in-python

    public static int add(int a, int b){

        while (b !=0){
              int carry = a & b; // 1 + 1 = 10 in bit addition so we need a carrybit
              a = a ^ b;
              b = carry << 1;

         }

        return a;

    }


    public static void main(String args[]){
        System.out.println(" 4 + 5 :: "+ add(4,5)) ;
        System.out.println(" 0 + 5 :: "+ add(0,5)) ;
        System.out.println(" 5 + 0 :: "+ add(5,0)) ;

    }
}
