package slidingWindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LengthOfLongestSubStringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() ==0)
            return 0;

        int top = 0, bottom =0, ans =0 ;

        int[] chars = new int[128];
        for(int index =0; index < chars.length  ; index ++)
         chars[index] = -1;

        while(bottom < s.length()){

            if(chars[s.charAt(bottom)] != -1 && chars[s.charAt(bottom)] >= top ){
                //top = bottom;
               top ++;//chars[s.charAt(bottom)] + 1;

            }else{
                chars[s.charAt(bottom)] = bottom;
                bottom ++;
            }

            if(bottom - top > ans){
                ans = bottom -top;
                //ans = len;
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        LengthOfLongestSubStringWithoutRepeatingChar lengthOfLongestSubString = new LengthOfLongestSubStringWithoutRepeatingChar();
        System.out.println("abcaabcdef : " + lengthOfLongestSubString.lengthOfLongestSubstring("abcaabcdef"));
        System.out.println("dvdf : " + lengthOfLongestSubString.lengthOfLongestSubstring("dvdf"));
    }
}
