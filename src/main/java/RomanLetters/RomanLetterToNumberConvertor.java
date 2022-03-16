package RomanLetters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanLetterToNumberConvertor {

    private Map<String, Integer> romanIntMap = new HashMap<String,Integer>();

    public RomanLetterToNumberConvertor() {
        romanIntMap.put("I", 1);
        romanIntMap.put("IV", 4);
        romanIntMap.put("V", 5);
        romanIntMap.put("IX", 9);
        romanIntMap.put("X", 10);
        romanIntMap.put("XL", 40);
        romanIntMap.put("L", 50);
        romanIntMap.put("XC" ,90);
        romanIntMap.put("C", 100);
        romanIntMap.put("D", 500);
        romanIntMap.put("CM", 900);
        romanIntMap.put("M", 1000);

    }

    public Integer convertToNumber(String romanNumber){

        Integer result = 0 ;

        if(romanNumber == null || romanNumber.isEmpty()){
            return result;
        }

        String [] romanStrArray = romanNumber.split("");

        List<Integer> lessIndecies = new ArrayList<Integer>();

        for(int index = 0; index < romanStrArray.length ; index ++){
            if(index + 1 < romanStrArray.length){
                    if(romanIntMap.get(romanStrArray[index]) < romanIntMap.get(romanStrArray[index+1]))
                    lessIndecies.add(index);
            }

        }

        for(int index = 0; index < romanStrArray.length ; ){
            if(!lessIndecies.contains(index)){
                result = result + romanIntMap.get(romanStrArray[index]);
                index ++;
            }else{
                result = result + romanIntMap.get(romanStrArray[index+1]) - romanIntMap.get(romanStrArray[index]);
                index = index + 2;
            }
        }

        return result;
    }


    public static void main(String args[]){

        RomanLetterToNumberConvertor romanLetterToNumberConvertor =  new RomanLetterToNumberConvertor();

        System.out.println("Int value : " + romanLetterToNumberConvertor.convertToNumber("IV"));
        System.out.println("Int value : " + romanLetterToNumberConvertor.convertToNumber("XV"));
        System.out.println("Int value : " + romanLetterToNumberConvertor.convertToNumber("CDV"));
        System.out.println("Int value : " + romanLetterToNumberConvertor.convertToNumber("XLIX"));
        System.out.println("Int value : " + romanLetterToNumberConvertor.convertToNumber("XXXVIII"));



    }
}
