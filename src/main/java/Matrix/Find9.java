
package Matrix;



/**
 *  ----------------------------
 int[][] dest ={
 {1,0,0,0},
 {1,1,0,0},
 {0,1,0,0},
 {0,9,0,0}
 };

 int[][] dest1 ={
 {1,0,0,0},
 {1,1,1,0},
 {0,1,1,0},
 {0,9,0,0}
 };

 int[][] dest2 ={
 {1,1,0,0},
 {1,1,0,0},
 {0,0,0,0},
 {0,9,0,0}
 };


 Telephone dial pad

 123
 456
 789
 0


 3589632
 12567

 ---------------------------------

 havai hort a 232324 [prime]
 havai hort 232324 [prime]
 welcom vorder 09890880 [prime]
 1244 hello world order2323223
 3423 west welcome mays ord798789


 1. all prime order should be pushed to top
 2. each prime order should shorted by asc order
 3. non prime order should be pushed to bottom
 4. each non prime should sort from the second word

 -----------------------------------


 A - > B, C
 C - > B
 B - > C *
 C - > D

 1 -> 2, 3
 2 -> 3

 *
 * */
public class Find9 {

    public static boolean isThereaPathTo9(int [][]m){

        boolean[][] visited = new boolean[m.length][m.length];

        for(int i =0; i < m.length ; i ++){
            for(int j=0; j < m.length; j ++){
                if(m[i][j] == 1 && !visited[i][j])
                   return DFS(m,  i,  j, visited);
            }
        }

        return false;


    }

    private static boolean DFS(int[][] m,int row, int col, boolean[][] visited) {

        if(m[row][col] ==9 )
            return true;

        visited[row][col] = true;
        int[] rowDir = new int[]{-1,0,1,1,1,0,-1,-1};
        int[] colDir = new int[]{1,1,1,0,-1,-1,-1,0};

        for(int k = 0; k < 8; k ++ ){
            if(isSafe(m, row + rowDir[k] , col + colDir[k] , visited))
                return DFS(m,row + rowDir[k] , col + colDir[k] , visited);
        }

        return false;
    }

    private static boolean isSafe(int m[][], int row, int col, boolean [][] visited){

        return (row >=0 )&& (row < m.length) && (col >=0) && (col < m.length) && (m[row][col] !=0 && !visited[row][col]);
    }

    public static void main(String[] args) {

        int[][] dest ={
                {1,0,0,0},
                {1,1,0,0},
                {0,1,0,0},
                {0,9,0,0}
        };

        int[][] dest1 ={
                {1,0,0,0},
                {1,1,1,0},
                {0,1,1,0},
                {0,9,0,0}
        };

        int[][] dest2 ={
                {1,1,0,0},
                {1,1,0,0},
                {0,0,0,0},
                {0,9,0,0}
        };

        System.out.println(isThereaPathTo9(dest));
        System.out.println(isThereaPathTo9(dest1));
        System.out.println(isThereaPathTo9(dest2));
    }



}



