package String;

public class LongestPalindromicSubString {

    public static String longestPalindromicSubString(String s){


        if(s == null || s.length() ==0)
            return null;

        if(s.length() == 1)
            return s;

        String longest = "";

        for(int i =0 ; i < s.length() ; i ++){
            String temp = "";

            temp = expand(s, i, i);

            if(temp.length() > longest.length()){
                longest = temp;
            }
            temp = expand(s, i , i + 1);
            if(temp.length() > longest.length()){
                longest = temp;
            }
        }

        return longest;


    }

    private static String expand(String s, int left, int right) {

        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }

        return s.substring(left + 1, right);

    }

    public static void main(String[] args) {
        String s="abba";
        System.out.println(longestPalindromicSubString(s));

        s="aaaa";
        System.out.println(longestPalindromicSubString(s));

        s="babad";
        System.out.println(longestPalindromicSubString(s));
    }

    //23280666573413

}
