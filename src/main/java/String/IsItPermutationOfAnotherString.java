package String;


import java.util.HashMap;
import java.util.Map;


public class IsItPermutationOfAnotherString {

    public boolean isItPermutationOf(String one, String two){

        if(one != null && two != null && !one.isEmpty() && !two.isEmpty() && one.length() == two.length()){

            Map<Character,Integer> charCountMap = new HashMap<Character, Integer>();
            for (Character c: one.toCharArray()) {
                if(charCountMap.get(c) != null){
                    charCountMap.put(c, charCountMap.get(c) + 1);
                }else
                    charCountMap.put(c, 1);
            }

            for (Character c: two.toCharArray()) {
                if(charCountMap.get(c) != null){
                    if( charCountMap.get(c) == 1){
                        charCountMap.remove(c);
                    }else{
                        charCountMap.put(c, charCountMap.get(c) - 1);
                    }
                }else{
                    return false;
                }
            }

            return charCountMap.isEmpty();


        }

        return false;

    }

    public static void main(String args[]){

        IsItPermutationOfAnotherString  permutationOfAnotherString = new IsItPermutationOfAnotherString();
        System.out.println(permutationOfAnotherString.isItPermutationOf(null,null));
        System.out.println(permutationOfAnotherString.isItPermutationOf("",null));
        System.out.println(permutationOfAnotherString.isItPermutationOf(null,""));
        System.out.println(permutationOfAnotherString.isItPermutationOf("",""));
        System.out.println(permutationOfAnotherString.isItPermutationOf("abc","ca"));
        System.out.println(permutationOfAnotherString.isItPermutationOf("dog","go"));
        System.out.println(permutationOfAnotherString.isItPermutationOf("dog","god"));
        System.out.println(permutationOfAnotherString.isItPermutationOf("matt","tamt"));
    }
}
