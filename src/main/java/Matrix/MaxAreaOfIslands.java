package Matrix;

public class MaxAreaOfIslands {

    int maxArea = 0;
    int area =0;
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean [][] visited = new boolean[row][col];
        for(int i=0; i < row; i++){
            for(int j=0; j < col;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    dfs(grid, i , j , visited);
                    maxArea = Math.max(area, maxArea);
                    area = 0;
                }
            }
        }

        return maxArea;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited){

        if(visited[i][j])
            return;

        visited[i][j] = true;
        area++;

        int[][] dirs = new int[][]{{0,1},{1,0}, {-1, 0}, {0,-1}};
        for(int m=0; m < dirs.length; m++){
            int[] dir = dirs[m];
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if(nextI >=0 && nextI < grid.length && nextJ >= 0 &&
                    nextJ < grid[0].length && grid[nextI][nextJ] == 1 && !visited[nextI][nextJ]){
                dfs(grid, nextI, nextJ, visited);
            }
        }
    }
}
