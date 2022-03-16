package slidingWindow;

import java.util.HashMap;
import java.util.Map;



//MaxSubStringWithoutRepeatingChar
public class MaxSubStringWithoutRepeatingChar {

    public String maxSubString(String input){
        String ans = null;

        int top =0, bottom = 0, len=0;
        int length = input.length();

        Map<Character , Integer> seen = new HashMap<>();

        while(bottom < length){

            if(seen.get(input.charAt(bottom)) != null && seen.get(input.charAt(bottom)) >= top){

                //top = bottom; dvdf fails
                //top = seen.get(input.charAt(bottom)) + 1;
                //top = top + 1; //top = top ++ , wont update the top value so top + 1
                top++;

            }else{
                seen.put(input.charAt(bottom), bottom);
                bottom ++;
            }

            if(bottom - top > len){
                len = bottom - top;
                ans= input.substring(top, bottom );

            }
        }

        return ans;

    }

    public static void main(String[] args) {
        MaxSubStringWithoutRepeatingChar maxSubString = new MaxSubStringWithoutRepeatingChar();

        System.out.println(maxSubString.maxSubString("abccc"));
        System.out.println(maxSubString.maxSubString("abcaabcdef"));
        System.out.println(maxSubString.maxSubString("abcaaaa"));
        System.out.println(maxSubString.maxSubString("abca"));
        System.out.println(maxSubString.maxSubString("abcccaabbbcdef"));
        System.out.println(maxSubString.maxSubString("dvdf"));

    }

}
