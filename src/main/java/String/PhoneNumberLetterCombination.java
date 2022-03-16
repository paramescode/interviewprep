package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberLetterCombination {

    private static Map<Integer, String> digitLetterMap = new HashMap<>();

    static {
        digitLetterMap.put(2, "abc");
        digitLetterMap.put(3, "def");
        digitLetterMap.put(4, "ghi");
        digitLetterMap.put(5, "jkl");
        digitLetterMap.put(6, "mno");
        digitLetterMap.put(7, "pqrs");
        digitLetterMap.put(8, "tuv");
        digitLetterMap.put(9, "wxyz");
    }

    public static List<String> phoneNumbers(String digits){

        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() ==0)
            return res;

        StringBuilder sb = new StringBuilder();

         backTracking(res, sb, digits, 0);

         return res;

    }

    private static void backTracking(List<String> res,StringBuilder sb, String digits, int index ) {

        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }

        String letters = digitLetterMap.get(digits.charAt(index) - '0');

        for(int i=0; i < letters.length();i++){
            sb.append(letters.charAt(i));
            backTracking(res, sb, digits, index + 1);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> res = phoneNumbers("234");
        for(String s : res){
            System.out.println(s);
        }
    }




}
