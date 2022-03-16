package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Find the kth largest element in an unsorted array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

https://leetcode.com/problems/kth-largest-element-in-an-array/

 */
public class FindKthMaxElement {

    public static int kthLargestElement(int[] nums, int k){

        return 0;
    }

    //using PQ

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n: nums){
            pq.add(n);
        }

        while(pq.size() > k){
            pq.poll();
        }

        return pq.poll();

    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},  2));

        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},  4));
    }

}
