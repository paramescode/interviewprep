package Matrix;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/

public class ShortestPathInBinaryMatrix {

    class Pair{
        int row;
        int col;
        int length ;

        Pair(int r, int c, int len){
            this.row  =r;
            this.col = c;
            this.length = len;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid == null || grid.length ==0)
            return -1;

        if(grid[0][0] != 0)
            return -1;

        int[] xDir = new int[]{0,1,1,1,0,-1,-1,-1};
        int[] yDir = new int[]{1,1,0,-1,-1,-1,0,1};

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(0,0,1);
        q.add(p);
        visited[0][0] = true;

        int minLength = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            p = q.poll();
            if(p.row == row -1  && p.col == col -1 && p.length < minLength)
                minLength = p.length;

            for(int i=0;i < xDir.length; i++){
                int newRow = p.row + xDir[i];
                int newCol = p.col + yDir[i];

                if(newRow >=0 && newRow < row && newCol >=0 && newCol < col
                        && grid[newRow][newCol] == 0 && !visited[newRow][newCol]){
                    Pair np = new Pair(newRow, newCol, p.length + 1);
                    q.add(np);
                    visited[newRow][newCol] = true;
                }
            }

        }

        if(minLength == Integer.MAX_VALUE)
            return -1;

        return minLength;

    }
}
