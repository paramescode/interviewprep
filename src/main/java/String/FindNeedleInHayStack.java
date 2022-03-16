package String;
import java.io.*;
import java.util.*;

public class FindNeedleInHayStack {

/*
function int[]/list grep(string haystack, string needle)
haystack = "aaabcdddbbddddabcdefghi"
needle = "abc"
[2,14]


haystack = null or "" needle = null or ""  --- > []
haystack != null needle  =null or ""  --- > []


haystack != null or "" needle  != null or ""  --- > []

i = 0, j = needle.length() -1;  j = 2

 */


public static void main(String[] args) {

    List<Integer> res = findNeedle("aaabcdddbbddddabcdefghi" , "abc");
    for(Integer i : res){
        System.out.println(i);
    }

     res = find("aaabcdddbbddddabcdefghi" , "abc");
    for(Integer i : res){
        System.out.println(i);
    }

}
//O(n) using KMP algo

    private static List<Integer> find(String hayStack, String needle){

        List<Integer> result = new ArrayList<>();

        if(hayStack == null || hayStack.length() == 0 || needle == null || needle.length() ==0)
            return result;

        int[] patternIndex = createPattenArray(needle);
        int i=0, j =0;

        while(i < hayStack.length() && j < needle.length()){
            if(hayStack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                if(j != 0){
                    j = patternIndex[j - 1];
                }
                i++;
            }

            if(j == needle.length()){
                result.add(i - j);
                j=0;
            }
        }
        return result;

    }

    private static int[] createPattenArray(String pattern){
        int[] patternIndex = new int[pattern.length()];
        int j=0, i = 1;
        while(i < pattern.length()){
            if(pattern.charAt(j) == pattern.charAt(i)){
                patternIndex[i] = j + 1;
                i++;
                j++;
            }else{
                if(j != 0){
                    j = patternIndex[j - 1];
                }
                patternIndex[i] = 0;
                i++;
            }
        }

        return patternIndex;
    }

//O(n * m)
private static List<Integer> findNeedle(String hayStack, String needle){

    List<Integer> result = new ArrayList<>();

    if(hayStack == null || hayStack.length() == 0 || needle == null || needle.length() ==0)
        return result;

    int i =0, j = needle.length() -1;

    while(i <= hayStack.length() - needle.length()){
        int index = indexOf(hayStack, needle, i, j);
        if( index >=0){
            result.add(index);
        }
        i++;
        j++;

    }

    return result;
}

private static int indexOf(String hayStack, String needle, int i, int j){

    int k = 0 , l = i;
    while(l <= j){

        if(hayStack.charAt(l) == needle.charAt(k)){
            l++;
            k++;
        }else{
            return -1;
        }


    }
    return i;


}


}
