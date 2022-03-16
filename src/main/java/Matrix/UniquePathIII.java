package Matrix;


//https://leetcode.com/problems/unique-paths-iii/
/*
On a 2-dimensional grid, there are 4 types of squares:

    1 represents the starting square.  There is exactly one starting square.
    2 represents the ending square.  There is exactly one ending square.
    0 represents empty squares we can walk over.
    -1 represents obstacles that we cannot walk over.

Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.



Example 1:

Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Example 2:

Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

Example 3:

Input: [[0,1],[2,0]]
Output: 0
Explanation:
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
*/


public class UniquePathIII {

    private static int ans = 0;

    public static int uniquePathsIII(int[][] grid) {

        if(grid.length ==0 || grid[0].length ==0)
            return 0;

        int n =0, startI = -1, startJ =-1;

        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        for(int i=0; i < row; i++){
            for(int j =0; j < col;j ++){
                if(grid[i][j] == 1){
                    startI = i;
                    startJ = j;
                }else if(grid[i][j] == 0){
                    n++;
                }
            }
        }

        if(startI < 0)
            return 0;

        visited[startI][startJ] = true;
        dfs(grid, visited, startI, startJ, n);
        return ans;
    }

    private static void dfs(int[][] grid, boolean [][] visited, int i, int j, int n){

        if(grid[i][j]  == -1  )
            return;

        if(grid[i][j] == 2){
            if(n ==0)
                ans++;
            return;
        }

        visited[i][j] = true;

        if(grid[i][j] == 0)
            n--;

        int temp = grid[i][j];

        int xDir[] = new int[]{1,-1,0,0};
        int yDir[] = new int[]{0,0,1,-1};

        for(int k=0; k < 4; k++){
            if(isSafe(grid, visited, i + xDir[k], j+ yDir[k])){
                dfs(grid, visited, i + xDir[k], j+ yDir[k], n);
            }
        }

        if(temp ==0)
            n++;

        grid[i][j] = temp;
        visited[i][j] = false;

    }

    private static boolean isSafe(int[][] grid, boolean [][] visited, int r, int c){

        if(r >=0 && r < grid.length && c >= 0 && c < grid[0].length && !visited[r][c]){
            return true;
        }

        return false;
    }



    public static void main(String[] args) {
        System.out.println(uniquePathsIII(new int[][] {{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
    }



}
