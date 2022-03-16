package Arrays;

/**
 * Created by m655222 on 5/25/2017.
 */
public class IndexOfMaxValueInArray {

    public int findIndexOfMaxNumberInArray(int [] input){

        if(input == null || input.length < 2){
            return 0;
        }
        int max= input[0];
        int[] position = new int[input.length];
        int pIndex = 0;
        for(int index =1 ; index <input.length ; index++){
            if(max <= input[index]){
                if(max == input[index]){
                    position[++pIndex] = index; // to find first occurence of max when there is duplicate
                }else{
                    position[pIndex] = index;
                    max = input[index];
                }

            }
        }
        return position[0];
        //return 0;
    }

    public static void main(String args[]){
        IndexOfMaxValueInArray maxArray = new IndexOfMaxValueInArray();
        System.out.println("Max value Index:: " + maxArray.findIndexOfMaxNumberInArray(new int[] {1,2,6,7,8,4,8}));
        System.out.println("Max value Index :: " + maxArray.findIndexOfMaxNumberInArray(new int[] {1,2,3,4,5,10}));
        System.out.println("Max value Index:: " + maxArray.findIndexOfMaxNumberInArray(new int[] {1,3,5,7,9}));
        System.out.println("Max value Index :: " + maxArray.findIndexOfMaxNumberInArray(new int[] {-1,-2,-6,-7,-8,-4,-8}));
        System.out.println("Max value Index :: " + maxArray.findIndexOfMaxNumberInArray(new int[] {1,1,1,1,1}));
        System.out.println("Max value Index :: " + maxArray.findIndexOfMaxNumberInArray(new int[] {}));
    }
}
