package slidingWindow;

import java.util.*;

public class FindMaxOfEveryWindow {

    //O(n * K)
    public static List<Integer> maxOfEveryWindow(int[] nums , int k){

        if(nums == null || nums.length ==0 || nums.length < k){
            return null;
        }

        List<Integer> result = new ArrayList<>();

        int slow = 0, fast = k;

        while(fast <= nums.length){
            int max = nums[slow];
            for(int i = slow + 1; i < fast; i ++){
                if(max < nums[i])
                    max = nums[i];

            }
            result.add(max);
            slow++;
            fast++;

        }

        return result;
    }

    // O(n * logK)
    public static List<Integer> usingPriorityQ(int[] nums, int k){

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });


        return null;
    }

    //O(N)
    //https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
    public static List<Integer> usingDQ(int[] arr, int k){


        if(arr == null || arr.length ==0 || arr.length < k){
            return null;
        }

        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order

        Deque<Integer> Qi = new LinkedList<Integer>();
        List<Integer> result = new ArrayList<>();

        /* Process first k (or first window) elements of array */
        int i;
        for (i = 0; i < k; ++i) {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast(); // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < arr.length; ++i) {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            result.add(arr[Qi.peek()]);

            // Remove the elements which are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window
        result.add(arr[Qi.peek()]);

        return result;

    }


    public static void main(String[] args) {
        List<Integer> res = maxOfEveryWindow(new int[]{1,2,3,4,5,6,7}, 3);
        res.stream().forEach(x-> System.out.print(x + " "));

        System.out.println();
        res = usingDQ(new int[]{1,2,3,4,5,6,7}, 3);
        res.stream().forEach(x-> System.out.print(x + " "));
    }
}
