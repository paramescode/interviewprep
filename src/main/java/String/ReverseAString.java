package String;

/**
 * Created by m655222 on 5/30/2017.
 */
public class ReverseAString {

    public String reverse(String input){

        if(input == null || input.length() < 2){

            return  input;

        }

        return input.charAt(input.length()-1) + reverse(input.substring(0,input.length()-1));

    }

    public static void main(String arg[]){
        ReverseAString reverseAString = new ReverseAString();
        String reversed = reverseAString.reverse("hello");
        System.out.println(reversed);


    }
}
