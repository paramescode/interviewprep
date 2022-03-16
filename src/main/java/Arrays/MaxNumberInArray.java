package Arrays;

public class MaxNumberInArray {

    public int maxValue(int[] input){


        int max = input[0];

        for (int index = 1 ;index < input.length ; index ++){

            if(max < input[index]){
                max = input[index];
            }
        }

        return max;

    }

    public static void main(String[] args) {
        MaxNumberInArray maxArray = new MaxNumberInArray();
        System.out.println("Max value :: " + maxArray.maxValue(new int[] {1,2,6,7,8,4,8}));
        System.out.println("Max value  :: " + maxArray.maxValue(new int[] {1,2,3,4,5,10}));
        System.out.println("Max value :: " + maxArray.maxValue(new int[] {1,3,5,7,9}));
        System.out.println("Max value  :: " + maxArray.maxValue(new int[] {-1,-2,-6,-7,-8,-4,-8}));
        System.out.println("Max value  :: " + maxArray.maxValue(new int[] {1,1,1,1,1}));
        //System.out.println("Max value  :: " + maxArray.maxValue(new int[] {}));
    }
}
