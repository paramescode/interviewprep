package Matrix;

/*You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1.
The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
*
* */

//https://leetcode.com/problems/island-perimeter/
public class Island_Perimeter {

    public static int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        for(int i=0; i < m;i++){
            for(int j=0;j < n;j++){
                if(grid[i][j] == 1 ){
                    if(i - 1 < 0 || grid[i -1][j] ==0)
                        ans++;
                    if(i + 1 >= m || grid[i + 1][j] == 0)
                        ans++;
                    if(j - 1 < 0 || grid[i][j -1] ==0)
                        ans++;
                    if(j + 1 >= n || grid[i][j +1] ==0)
                        ans++;

                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        }));
    }
}
