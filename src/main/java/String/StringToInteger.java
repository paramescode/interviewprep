package String;

public class StringToInteger {
    public int myAtoi(String str) {

        str = str.trim();
        if(str.length() == 0) return 0;
        int start = 0, neg = 1;
        if(str.charAt(0) == '-' || str.charAt(0) == '+'){
            start = 1;
            neg = str.charAt(0) == '-'? -1:1;
        }

        if(start >= str.length()||!isNumber(str.charAt(start))) return 0;
        int res = 0, i = start;
        while(i < str.length() && isNumber(str.charAt(i))){
            int digit = str.charAt(i++)-'0';
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && digit > 7))
                return neg == 1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            res = res*10 + digit;
        }
        return res*neg;
    }
    private boolean isNumber(char c){
        return c <= '9' && c >= '0';
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("42"));
        System.out.println(stringToInteger.myAtoi("2147483646")); //max -1
        System.out.println(stringToInteger.myAtoi("2147483648"));// max + 1
        System.out.println(stringToInteger.myAtoi("-91283472332")); //overflow value
        System.out.println(stringToInteger.myAtoi("314748364"));
        System.out.println(stringToInteger.myAtoi("1147483647"));
        System.out.println(stringToInteger.myAtoi("2147483647")); // max value
        System.out.println(stringToInteger.myAtoi("3147483647")); //overflow value
    }
}
