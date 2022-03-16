package Matrix;

public class NumberOfPathsFromLeftToBottomCorner {
    //https://algorithms.tutorialhorizon.com/dynamic-programming-count-all-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
    //you can only move to RIGHT OR BOTTOM
    public static int numberOfPaths(int[][]m){

        if(m == null || m.length ==0)
            return 0;

        if(m.length ==1)
            return 1;

        int[][] dp = new int[m.length][m.length];

        //number of steps to reach any cells in first row =1 , moving to right
        for(int i = 0 ; i < m.length ;i++){
            dp[0][i] = 1;
        }

        //number of steps to reach any cells in first col =1 , moving bottom
        for(int i = 0 ; i < m.length ;i++){
            dp[i][0] = 1;
        }

        for(int i=1; i < m.length ; i ++){
            for(int j = 1; j < m.length ; j++){
                dp[i][j] = dp[i-1][j]+ dp[j-1][i];
            }
        }

        return dp[m.length -1][m.length -1]; //bottom right corner
    }

    public static void main(String[] args) {
        int arrA [][] = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println("No Of Path (DP):- " +numberOfPaths(arrA));

    }
}
