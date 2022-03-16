package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FlatternArray {

    public List<Integer> flattern(int [][] input){

        if(input == null)
            return null;

        List<Integer> result = new ArrayList<Integer>();
        for(int index = 0 ; index < input.length; index ++){
            for(int j = 0; j < input[index].length; j ++){
                result.add(input[index][j]);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        FlatternArray flatternArray = new FlatternArray();
        int[][] input = new int [][]{{1,2},{3,4,5},{6,7,8,9}};
        List<Integer> result = flatternArray.flattern(input);
        System.out.println(result.size());
        for (Integer value:result) {
            System.out.println(value);
        }
    }
}
