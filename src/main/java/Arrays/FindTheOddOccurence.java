package Arrays;

/**
 * Created by m655222 on 5/31/2017.
 */
public class FindTheOddOccurence {

    public int findTheOddOccurences(int input[]){
        if(input == null ){
            return -1;
        }
        if(input.length < 2) {
            return input[0];
        }
        int result = 0;
        for(int index = 0;index < input.length ;index++){
            result = result ^ input[index];
        }

        return  result;
    }

    public static void main(String args[]){
        FindTheOddOccurence findTheOddOccurence = new FindTheOddOccurence();
        System.out.println("Test 1 ::" + findTheOddOccurence.findTheOddOccurences(new int[] {1,2,1,2,3,3,3}));
        System.out.println("Test 2 ::" +findTheOddOccurence.findTheOddOccurences(new int[] {1,2,1,2,3,3}));
        System.out.println("Test 3 ::" +findTheOddOccurence.findTheOddOccurences(new int[] {3,3,3,3,3}));
        System.out.println("Test 4 ::" +findTheOddOccurence.findTheOddOccurences(new int[] {4,4,4,4,4,4}));
        System.out.println("Test 4 ::" +findTheOddOccurence.findTheOddOccurences(new int[] {4,4,4,4,4,4,4}));

    }

}
