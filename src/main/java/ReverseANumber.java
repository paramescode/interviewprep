/**
 * Created by M655222 on 11/8/2017.
 */
public class ReverseANumber {

    public int reverse(int n){
        int result=0;
        while( n > 0){
            result = result * 10 + n%10;
            n = n/10;
        }
        return result;
    }

    public static void main(String arg[]){

        ReverseANumber reverseANumber = new ReverseANumber();
        System.out.println(reverseANumber.reverse(1234));

    }
}
