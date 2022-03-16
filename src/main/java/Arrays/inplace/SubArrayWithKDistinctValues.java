package Arrays.inplace;

import java.util.HashMap;
import java.util.Map;


//https://leetcode.com/problems/subarrays-with-k-different-integers/

/*
* Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the number of different integers in that subarray is exactly K.

(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)

Return the number of good subarrays of A.



Example 1:

Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].

Example 2:

Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].



Note:

    1 <= A.length <= 20000
    1 <= A[i] <= A.length
    1 <= K <= A.length
*/
public class SubArrayWithKDistinctValues {

    public static int subarraysWithKDistinct(int[] A, int K) {

        int total = 0;
        if(K == 0)
            return 0;

        int i = 0, j=0, n =A.length;

        Map<Integer, Integer> map = new HashMap<>();

        while(j < n){
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);

            if(map.size() == K){
                int dup =j;

                while((dup + 1) < n && map.containsKey(A[dup +1]))
                    dup++;

                while(map.size() == K){
                    total += (dup - j) +1;
                    int toBeRemoved = A[i];
                    map.put(toBeRemoved, map.get(toBeRemoved) - 1);
                    if(map.get(toBeRemoved) ==0)
                        map.remove(toBeRemoved);
                    i++;
                }
            }

            j++;
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
    }

}
