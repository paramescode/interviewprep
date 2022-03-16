package Arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Amzon {

    // IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM


    // SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED

        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public static List<Integer> cellCompete(int[] states, int days)
        {
            // WRITE YOUR CODE HERE

            while(days > 0){
                for(int i=0;i < states.length ;i++){
                    int left = 0;
                    int right = 0;

                    if(i ==0 ){
                        left =0;
                    }else
                        left = Math.abs(states[i -1]);

                    if(i ==7)
                        right = 0;
                    else
                        right = Math.abs(states[i + 1]);

                    if(left == 2 )
                        left = 0;
                    if(right == 2)
                        right =0;

                    if(left == right){
                        if(states[i] == 1)
                            states[i] = -1;

                        if(states[i] == 0)
                            states[i] = 0;

                    }else{
                        if(states[i] == 1)
                            states[i] = 1;

                        if(states[i] ==0)
                            states[i] = -2;
                    }
                    System.out.println(states[i]);


                }

                for(int i =0; i < states.length ; i++){
                    if(states[i] == -1)
                        states[i] = 0;

                    if(states[i] == -2)
                        states[i] = 1;
                }
                days --;

            }



            List<Integer> list = new ArrayList();
            for(int i : states)
                list.add(i);

            return list;
        }
        // METHOD SIGNATURE ENDS

    public static void main(String[] args) {
        System.out.println(cellCompete(new int[]{1,0,0,0,0,1,0,0}, 2));
    }

}
