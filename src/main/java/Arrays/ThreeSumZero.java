package Arrays;


import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:

 The solution set must not contain duplicate triplets.

 Example:

 Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]


 *
 *
 *
 * */
public class ThreeSumZero {


    //woth extra space, https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/

    // use Arrays.sort() for without extra space




    static List<List<Integer>>  findTriplets(int arr[], int n)
    {
        List<List<Integer>> result = new ArrayList<>();

        // sort array elements
        java.util.Arrays.sort(arr);

        for (int i=0; i<n-1; i++)
        {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r)
            {
                if (x + arr[l] + arr[r] == 0)
                {
                    // print elements if it's sum is zero
                    l++;
                    r--;
                    List<Integer> res = new ArrayList<>();
                    res.add(x);
                    res.add(arr[l]);
                    res.add(arr[r]);
                    result.add(res);

                }

                // If sum of three elements is less
                // than zero then increment in left
                else if (x + arr[l] + arr[r] < 0)
                    l++;

                    // if sum is greater than zero than
                    // decrement in right side
                else
                    r--;
            }
        }

        return result;
    }

    // Driven source
    public static void main (String[] args) {

        int arr[] = {0, -1, 2, -3, 1};
        int n =arr.length;
        List<List<Integer>>  result = findTriplets(arr, n);
        result.stream().forEach(y -> System.out.print(y + " "));
    }
}
