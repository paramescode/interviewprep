package bitManipulations;

/**
 * Created by m655222 on 12/21/2017.
 */
public class MultiplyTwoNumbers {

    //http://www.geeksforgeeks.org/russian-peasant-multiply-two-numbers-using-bitwise-operators/

    public static int multiply(int a , int b){

         int result = 0;

         while(b > 0){

             result += ((b & 1) > 0 )? a : 0;

             a = a << 1; // shifting one bit lest means  a * 2
             b = b >> 1; // shifting one bit right means b / 2

         }

         return result;
    }

    public static void main(String args[]){

        System.out.println("18 * 2 :: "+   multiply(18,2));

        System.out.println("18 * 2 :: "+   multiply(18,2));

        System.out.println("18 * 2 :: "+   multiply(8,5));

    }
}
