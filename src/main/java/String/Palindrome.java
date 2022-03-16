package String;

import java.util.Calendar;

public class Palindrome

{

    public boolean isPalindrome(String a) {

        if(a == null ){
            throw new NullPointerException("input is null");
        }


        String b = "";

        for (int i=a.length() -1 ;i >=0 ; i--){
            b = b + a.charAt(i);
        }

        return  a.equalsIgnoreCase(b);
    }

    public boolean isPalindrome_Considoring_only_Alphanumeric(String str) throws NullPointerException{
        if(str == null)
            throw new NullPointerException("Input is null");

        int head = 0, tail = str.length() -1;
        char chead , ctail;

        while(head <= tail){
            chead = str.charAt(head);
            ctail = str.charAt(tail);

            if(!Character.isLetterOrDigit(chead)){
                chead ++;

            }else if(!Character.isLetterOrDigit(ctail)){
                tail ++;

            }else{

                if(Character.toLowerCase(chead) != Character.toLowerCase(ctail)){
                    return false;
                }
                chead ++;
                ctail ++;

            }

        }

        return true;



    }

}
