package Matrix;

//https://leetcode.com/problems/unique-paths/


/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:

Input: m = 7, n = 3
Output: 28

/
 */

public class NumberOFUniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] res = new int[n][m];

        for(int i=0;i < m;i++)
            res[0][i] = 1;
        for(int i=0; i < n; i++)
            res[i][0]= 1;

        for(int i =1; i < n; i++){
            for(int j =1; j < m; j++){
                res[i][j] = res[i -1][j] + res[i][j- 1];
            }
        }

        return res[n-1][m-1];
    }

    public static void main(String[] args) {

    }


}
