package String;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConvertion {

    public static String zipZagConvertion(String input, int rows){

        if(input  == null || input.length() <=1 )
            return input;

        List<StringBuilder> results = new ArrayList<>();

        for (int i =0; i < Math.min(rows, input.length()); i ++)
            results.add(new StringBuilder());

        int currentRow = 0;
        boolean isGoingDown = false;

        for(int i =0; i < input.length() ; i++){

            results.get(currentRow).append(input.charAt(i));
            if(currentRow == 0 || currentRow == rows - 1 )
                isGoingDown = ! isGoingDown;
            currentRow += isGoingDown ? 1 : -1;

        }
        String res = "";
        for ( StringBuilder sb: results) {
            res += sb.toString();

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(zipZagConvertion("PAYPALISHIRING", 3));
        System.out.println(zipZagConvertion("PAYPALISHIRING", 4));
    }
}
