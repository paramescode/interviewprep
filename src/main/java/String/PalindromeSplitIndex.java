package String;

public class PalindromeSplitIndex {

    //given two string s1, s2 equal length return the split index
    // where first part of s1 and second part of s2 makes a palindrome
    //return -1 when there is no such index to create palindrome

    // abcdefgh ertsdcba , returns 4
    //qwwq asdq , returns 3

    public static void main(String[] args) {
        System.out.println(findPalindromeIndex("abcdefgh", "ertsdcba"));
        System.out.println(findPalindromeIndex("qwwq", "asdq"));

        System.out.println(findPalindromeIndex("qwwq", "asde"));

//==================== O(n) ================
        System.out.println(palindromeIndex("abcdefgh", "ertsdcba"));
        System.out.println(palindromeIndex("qwwq", "asdq"));

        System.out.println(palindromeIndex("qsdq", "qwwq"));

        System.out.println(palindromeIndex("qwwq", "asde"));
    }

    //time complexity is o(n)
    private static int palindromeIndex(String s1, String s2){
        if(s1 == null || s1.length() ==0)
            return -1;

        int i=0, j= s1.length() -1;

        while(i<=j){
            if(s1.charAt(i) == s2.charAt(j))
            {
                if(isPalindrome(s1.substring(i+1, j)))
                    return j;
                else if(isPalindrome(s2.substring(i +1, j)))
                    return i;
            }
            i++;
            j--;


        }

        return -1;

    }

    private static boolean isPalindrome(String s) {
        System.out.println(s);
        int l =0, h= s.length() -1;
        while( l<=h){
            if(s.charAt(l) != s.charAt(h))
                return false;
            l++;
            h--;
        }

        return true;
    }


    // time complexity is o(n^2)
    private static int findPalindromeIndex(String s1, String s2) {

        if(s1 == null || s1.length() ==0)
            return -1;

        int mid = s1.length() /2;

        while(mid < s1.length()){
            if(isPalindrome(s1.substring(0,mid), s2.substring(mid, s1.length()))){
                return mid;
            }
            mid++;
        }

        return -1;


    }

    private static boolean isPalindrome(String s1, String s2) {
        //System.out.println(s1);
        //System.out.println(s2);
        String s = s1 + s2;

        int l =0, h= s.length() -1;
        while( l<=h){
            if(s.charAt(l) != s.charAt(h))
                return false;
            l++;
            h--;
        }

        return true;
    }

}
