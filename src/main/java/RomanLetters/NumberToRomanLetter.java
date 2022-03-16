package RomanLetters;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class NumberToRomanLetter {

    LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();

    LinkedHashMap<Integer, String> numberRomanNumeralsMap = new LinkedHashMap<Integer, String>();


    public NumberToRomanLetter(){
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);



    }

    public String printRomanLetter(int number){

        String result = "";
        if(number <= 0){
            return result;
        }

        int index = 0;
        Iterator<Map.Entry<String, Integer>> entryIterator = roman_numerals.entrySet().iterator();
        while (number > 0 && entryIterator.hasNext() ) {
            Map.Entry<String,Integer> entry = entryIterator.next();
                if(number >= entry.getValue() ) {
                    result = result + entry.getKey();
                    number = number - entry.getValue();
                    entryIterator = roman_numerals.entrySet().iterator(); // need to rest to begin to look up for the new number
                }

        }

        return result;

    }

    public static void main(String args[]){
        NumberToRomanLetter numberToRomanLetter = new NumberToRomanLetter();
        System.out.println(numberToRomanLetter.printRomanLetter(2008));
        System.out.println(numberToRomanLetter.printRomanLetter(1500));
        System.out.println(numberToRomanLetter.printRomanLetter(950));
        System.out.println(numberToRomanLetter.printRomanLetter(30));
        System.out.println(numberToRomanLetter.printRomanLetter(7));
    }


}
