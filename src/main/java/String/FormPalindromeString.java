package String;



public class FormPalindromeString {

    public static String formPalindrome(String s){

        if(s.length() == 1)
            return s;

        StringBuilder sb = new StringBuilder();

        int l =0, r = s.length() -1 , insertIndex = 0;

        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                sb.append(s.substring(0,insertIndex));
                sb.append(s.charAt(r));
                sb.append(s.substring(insertIndex ));
                s = sb.toString();
                l++;
                sb.setLength(0);
                insertIndex++;
            }else
            {
                l++;
                r--;
            }
        }

        return s;


    }



    public static void main(String[] args) {


        String res = formPalindrome("a");

        System.out.println(res);

        res = formPalindrome("aa");

        System.out.println(res);

        res= formPalindrome("ab");

        System.out.println(res);

        res = formPalindrome("abb");

        System.out.println(res);

        res = formPalindrome("aacecaaa");

        System.out.println(res);

        res = formPalindrome("abcd");

        System.out.println(res);


    }
}
