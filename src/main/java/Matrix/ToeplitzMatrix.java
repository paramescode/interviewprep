package Matrix;

import java.util.HashSet;
import java.util.Set;

/*/

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is Toeplitz.


Example 1:

Input:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
Output: True
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.

Example 2:

Input:
matrix = [
  [1,2],
  [2,2]
]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.


https://leetcode.com/problems/toeplitz-matrix/

 */

public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return false;
        if(matrix.length == 1 )
            return true;


        for(int i=matrix[0].length - 2; i >=0;i--){
            int col= i, row = 0;
            Set<Integer> set = new HashSet<>();
            set.add(matrix[row][col]);
            while( col < matrix[0].length && row < matrix.length){
                //System.out.print(matrix[row][col] + " ");
                if(!set.contains(matrix[row][col]))
                    return false;
                col++;
                row++;
            }
            //System.out.println();
        }

        for(int i=1; i < matrix.length;i++){
            int row= i, col = 0;
            Set<Integer> set = new HashSet<>();
            set.add(matrix[row][col]);
            while( col < matrix[0].length && row < matrix.length){
                //System.out.print(matrix[row][col] + " ");
                if(!set.contains(matrix[row][col]))
                    return false;
                col++;
                row++;
            }
            //System.out.println();
        }

        return true;
    }
}
