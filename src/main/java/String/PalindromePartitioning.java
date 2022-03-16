package String;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 Example:

 Input: "aab"
 Output:
 [
 ["aa","b"],
 ["a","a","b"]
 ]
 * **/

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        if(s == null || s.length() ==0)
            return res;

        List<String> last = new ArrayList<>();
        if(s.length() == 1){
            last.add(s);
            res.add(last);
            return res;
        }

        dfs(s, 0, res, last);
        return res;

    }

    private void dfs(String s, int start, List<List<String>> res, List<String> temp){
        if(start == s.length()){
            List<String> t = new ArrayList<>(temp);
            res.add(t);
            return;
        }

        for(int i=start; i < s.length(); i++){
            if(isPal(s.substring(start, i+1))){
                temp.add(s.substring(start, i+1));
                dfs(s, i+1, res, temp);
                temp.remove(temp.size() -1);
            }

        }
    }

    private boolean isPal(String s){

        int l=0, r = s.length() -1;
        while(l<=r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }
}
