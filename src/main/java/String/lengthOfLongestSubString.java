package String;

import java.util.HashMap;

public class lengthOfLongestSubString {


    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), top = 0, ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [top, bottom]
        for (int bottom = 0; bottom < n; bottom ++) {
            top = Math.max(index[s.charAt(bottom)], top);
            ans = Math.max(ans, bottom - top + 1);
            index[s.charAt(bottom)] =  bottom + 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        lengthOfLongestSubString lengthOfLongestSubString = new lengthOfLongestSubString();

        System.out.println(lengthOfLongestSubString.lengthOfLongestSubstring("abcabca"));
        System.out.println(lengthOfLongestSubString.lengthOfLongestSubstring("pwwke"));
        System.out.println(lengthOfLongestSubString.lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubString.lengthOfLongestSubstring(" "));
    }


}


