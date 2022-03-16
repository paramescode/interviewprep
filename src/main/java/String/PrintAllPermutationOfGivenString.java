package String;

public class PrintAllPermutationOfGivenString {

    public void printPermutation(String input){

        permutation(input, 0, input.length() - 1);

    }

    private void permutation(String input, int start, int end){

        if (start == end){
            System.out.println(input);
            return;
        }

        for (int i= start; i <= end; i ++){
            input = swap(input, start , i);
            permutation(input, start + 1, end);
            input = swap(input, start , i);
        }

    }

    private String swap(String input, int i, int j){

        char [] chars = input.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);

    }

    public static void main(String[] args) {
        PrintAllPermutationOfGivenString printAllPermutationOfGivenString = new PrintAllPermutationOfGivenString();
        printAllPermutationOfGivenString.printPermutation("ABCDE");
    }
}
