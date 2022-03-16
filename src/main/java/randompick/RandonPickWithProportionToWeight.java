package randompick;

import java.util.Random;

//https://leetcode.com/problems/random-pick-with-weight/

//https://medium.com/@peterkellyonline/weighted-random-selection-3ff222917eb6

public class RandonPickWithProportionToWeight {

    int[] asum = null;
    int total =0;
    public RandonPickWithProportionToWeight(int[] w) {
        asum = new int[w.length];

        for(int i=0; i < w.length;i++){
            total += w[i];
            asum[i] = total;
        }
    }

    public int pickIndex() {
        Random ran = new Random();
        int target = ran.nextInt(total) + 1; // lets assume , total is 14, get a random weight from 0 to 15 so 14 is inclusive

        // find the index of target in asum

        int l=0, r =asum.length -1;
        while(l <=r){
            int mid = l + (r -l) /2;
            if(asum[mid] == target)
                return mid;
            else if(asum[mid] > target)
                r =mid -1;
            else
                l = mid+1;

        }
        return l;

    }


}
