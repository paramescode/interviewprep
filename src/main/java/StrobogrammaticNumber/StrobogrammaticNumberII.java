package StrobogrammaticNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/strobogrammatic-number-ii/

/*A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

Example:

Input:  n = 2
Output: ["11","69","88","96"]


* */

public class StrobogrammaticNumberII {

    Map<Character, Character> map = new HashMap<>();
    {
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
    }


    public List<String> findStrobogrammatic(int n) {

        List<String> res = new ArrayList<>();
        if(n ==1){
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }

        char[] ca = new char[n];
        dfs(ca, 0, n-1, res);

        return res;


    }

    private void dfs(char ca[], int s, int e, List<String> res){
        if(s > e){
            if(ca[0] != '0')
                res.add(new String(ca));
            return;

        }
        for(char key : map.keySet()){
            if(s ==e && key != map.get(key))
                continue;

            ca[s] = key;
            ca[e] = map.get(key);

            dfs(ca, s+1, e -1, res);
        }
    }
}
