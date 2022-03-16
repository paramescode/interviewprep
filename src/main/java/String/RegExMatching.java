package String;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like . or *.

 Example 1:

 Input:
 s = "aa"
 p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".

 Example 2:

 Input:
 s = "aa"
 p = "a*"
 Output: true
 Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

 Example 3:

 Input:
 s = "ab"
 p = ".*"
 Output: true
 Explanation: ".*" means "zero or more (*) of any character (.)".

 Example 4:

 Input:
 s = "aab"
 p = "c*a*b"
 Output: true
 Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

 Example 5:

 Input:
 s = "mississippi"
 p = "mis*is*p*."
 Output: false
 * */

//https://leetcode.com/problems/regular-expression-matching/
public class RegExMatching {

    public boolean isMatch(String s, String p) {
        if(s == null && p == null){
            return true;
        }

        if(s.length() ==0 && p.length() ==0)
            return true;

        int m  = s.length();
        int n = p.length();

        boolean [][] T = new boolean[m+ 1][n+1];

        T[0][0] = true;

        for(int i=1; i < T[0].length; i++){
            if(p.charAt(i - 1) == '*')
                T[0][i] = T[0][i -2];
        }

        for(int i=1; i < T.length; i++){
            for(int j = 1; j < T[0].length; j++){
                if(s.charAt( i -1) == p.charAt(j - 1) || p.charAt( j - 1) == '.'){
                    T[i][j] = T[i -1][j - 1];
                }else if(p.charAt(j - 1) == '*'){
                    T[i][j] = T[i][j - 2];
                    if(p.charAt( j - 2) == '.' || p.charAt(j - 2) == s.charAt(i -1)){
                        T[i][j] = T[i][j - 2] | T[i - 1][j];
                    }
                }else{
                    T[i][j] = false;
                }
            }
        }

        return T[m][n];
    }

    public static void main(String[] args) {

    }
}
