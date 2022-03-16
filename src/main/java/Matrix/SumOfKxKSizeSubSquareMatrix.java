package Matrix;

// https://www.geeksforgeeks.org/given-n-x-n-square-matrix-find-sum-sub-squares-size-k-x-k/

public class SumOfKxKSizeSubSquareMatrix {

    // A O(n^2) function to find sum of all
// sub-squares of size k x k in a given
// square matrix of size n x n
    static void printSumTricky(int mat[][], int k) {

        // k must be smaller than or equal to n
        int n = mat.length;
        if (k > n)
            return;

        // 1: PREPROCESSING
        // To store sums of all strips of size k x 1
        int stripSum[][] = new int[n][n];

        // Go column by column
        for (int j = 0; j < n; j++) {

            // Calculate sum of first k x 1
            // rectangle in this column
            int sum = 0;
            for (int i = 0; i < k; i++)
                sum += mat[i][j];
            stripSum[0][j] = sum;

            // Calculate sum of remaining rectangles
            for (int i = 1; i < n - k + 1; i++) {
                sum += (mat[i + k - 1][j] - mat[i - 1][j]);
                stripSum[i][j] = sum;
            }
        }

        // 2: CALCULATE SUM of Sub-Squares
        // using stripSum[][]
        for (int i = 0; i < n - k + 1; i++) {

            // Calculate and print sum of first
            // subsquare in this row
            int sum = 0;
            for (int j = 0; j < k; j++)
                sum += stripSum[i][j];
            System.out.print(sum + " ");

            // Calculate sum of remaining squares
            // in current row by removing the
            // leftmost strip of previous sub-square
            // and adding a new strip
            for (int j = 1; j < n - k + 1; j++) {
                sum += (stripSum[i][j + k - 1] - stripSum[i][j - 1]);
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5},
        };
        int k = 3;
        printSumTricky(mat, k);
    }

}
