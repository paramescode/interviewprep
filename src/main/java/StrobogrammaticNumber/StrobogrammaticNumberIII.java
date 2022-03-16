package StrobogrammaticNumber;

import java.util.HashMap;
import java.util.Map;


//https://leetcode.com/problems/strobogrammatic-number-iii/

/*A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

Example:

Input: low = "50", high = "100"
Output: 3
Explanation: 69, 88, and 96 are three strobogrammatic numbers.

Note:
Because the range might be a large number, the low and high numbers are represented as string.

* */
public class StrobogrammaticNumberIII {


        Map<Character, Character> map = new HashMap<>();
        {
            map.put('0', '0');
            map.put('1', '1');
            map.put('6', '9');
            map.put('8', '8');
            map.put('9', '6');
        }


        public int strobogrammaticInRange(String low, String high) {
            int total =0;
            for(int i= low.length() ; i <= high.length(); i++){
                char[] ca = new char[i];
                total+= dfs(ca, 0, i-1, low, high);
            }

            return total;
        }

        private int dfs(char ca[], int s, int e, String low , String high){
            if(s > e){
                String res = new String(ca);
                if( (res.length() == low.length() && res.compareTo(low) < 0 ) ||
                        (res.length() == high.length() && res.compareTo(high) > 0) ) {

                    //if its out of the range, less than low or gt than high return 0;

                    return 0;

                }else
                    return 1;

            }

            int count = 0;

            for(char key : map.keySet()){
                ca[s] = key;
                ca[e] = map.get(key);

                if(ca.length !=1 && ca[0] == '0')
                    continue;

                if(s ==e && key != map.get(key))
                    continue;

                count+= dfs(ca, s+1, e -1, low, high);
            }

            return count;


        }

}
