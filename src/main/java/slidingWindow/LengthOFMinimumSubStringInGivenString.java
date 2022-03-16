package slidingWindow;


//https://medium.com/leetcode-patterns/leetcode-pattern-2-sliding-windows-for-strings-e19af105316b

import java.util.HashMap;
import java.util.Map;

/*** Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

        Example:

        Input: S = "ADOBECODEBANC", T = "ABC"
        Output: "BANC"

        Note:

        If there is no such window in S that covers all characters in T, return the empty string "".
        If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
**/

public class LengthOFMinimumSubStringInGivenString {

    public static String minWindow(String s, String t) {

        if(s == null || t == null || s.length() ==0 || t.length() == 0){
            return "";
        }

        int begin = 0, end =0 , count = 0 , len = Integer.MAX_VALUE;
        String ans ="";

        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for(int i=0; i < t.length(); i ++){
            if(table.get(t.charAt(i)) == null){
                table.put(t.charAt(i), 1);
            }else{
                table.put(t.charAt(i), table.get(t.charAt(i) ) + 1);
            }


        }

        count = table.size();

        while(end < s.length()){

            Character c = s.charAt(end);
            if(table.get(c) != null){
                table.put(c, table.get(c)- 1);
                if(table.get(c) == 0)
                    count--;
            }
            end ++;

            while(count == 0){
                if(end - begin <  len){
                    len = end - begin;
                    ans = s.substring(begin, end);
                    System.out.println("-->" + ans);
                }

                Character a = s.charAt(begin);
                if(table.get(a) != null){ // only if the char is at string t else move to next
                    table.put(a, table.get(a)+ 1);
                    System.out.println(a);
                    if(table.get(a) > 0){
                        System.out.println("------>" + a);
                        count ++;
                    }

                }
                begin ++;

            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
