package String;

public class HowManyPalindromicSubStrings {

    public static int countSubstrings(String s) {
        if(s == null || s.length() ==0)
            return 0;

        int total = 0;
        for(int i=0;i < s.length() ; i++){

            total += expand(s, i, i);

            //System.out.println(total);

            total += expand(s, i, i+1);

            //System.out.println(total);

        }

        return total;
    }

    private static int expand(String s, int l, int r){
        int c =0;
        while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            c++;
        }
        return c;
        //return s.substring(l+1, r);
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));

        System.out.println(countSubstrings("aaaa"));
    }
}
