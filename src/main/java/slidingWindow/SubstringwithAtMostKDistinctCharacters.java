package slidingWindow;

import java.util.HashMap;
import java.util.Map;


/***
 *
 * Description
 中文
 English

 Given a string S, find the length of the longest substring T that contains at most k distinct characters.
 Have you met this question in a real interview?
 Example

 Example 1:

 Input: S = "eceba" and k = 3
 Output: 4
 Explanation: T = "eceb"

 Example 2:

 Input: S = "WORLD" and k = 4
 Output: 4
 Explanation: T = "WORL" or "ORLD"

 Challenge

 O(n) time

 *
 *
 *
 * **/
public class SubstringwithAtMostKDistinctCharacters {

    public static String longestSubString(String s, int k){

        if(s == null ||  s.length() < k){
            return s;
        }

        int start =0, end =0, count =0, len = 0;
        String ans = "";

        Map<Character, Integer> table = new HashMap<>();


        while(end < s.length()){
            Character a  = s.charAt(end);

            if(table.get(a) == null){
                table.put(a, 1);
            }else{
                table.put(a, table.get(a) + 1);
            }

            if(table.get(a) == 1){
               count ++;
            }

            end ++;

            while(count > k){
                Character b = s.charAt(start);
                if(table.get(b) != null){
                    table.put(b, table.get(b) - 1);
                    if(table.get(b) == 0)
                        count --;
                }

                start++;
            }

            if(len < end -start){
                len = end - start;
                ans= s.substring(start, end);
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(longestSubString("eceba" , 2));
    }
}
