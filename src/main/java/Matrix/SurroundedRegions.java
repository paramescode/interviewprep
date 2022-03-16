package Matrix;

/*
* Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

* */

//https://leetcode.com/problems/surrounded-regions/

public class SurroundedRegions {

    public void solve(char[][] board) {
        if(board.length ==0)
            return ;

        int row = board.length;
        int col = board[0].length;

        boolean [][] visited = new boolean[row][col];
        for(int i=0; i < row; i++){
            if(board[i][0] == 'O')
                dfs(board, i, 0, visited);

            if(board[i][col - 1] == 'O')
                dfs(board, i, col - 1, visited);
        }

        for(int i=0; i < col; i++){
            if(board[0][i] == 'O')
                dfs(board, 0, i, visited);

            if(board[row -1][i] == 'O')
                dfs(board, row -1, i, visited);
        }

        for(int i=0;i < row;i++){
            for(int j=0; j < col;j++){
                if(!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited){

        if(visited[i][j])
            return;
        visited[i][j] = true;
        int[][] dirs = new int[][]{{0,1},{1,0}, {-1, 0}, {0,-1}};
        for(int m=0; m < dirs.length; m++){
            int[] dir = dirs[m];
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if(nextI >=0 && nextI < grid.length && nextJ >= 0 &&
                    nextJ < grid[0].length && grid[nextI][nextJ] == 'O' && !visited[nextI][nextJ]){

                dfs(grid, nextI, nextJ, visited);
            }
        }
    }
}
