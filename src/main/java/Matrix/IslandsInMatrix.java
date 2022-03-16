package Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class IslandsInMatrix {
    // https://www.geeksforgeeks.org/find-number-of-islands/

    public static int numberOfIslands(int[][] m){
        int count = 0;

        if(m == null || m.length == 0 )
            return count;
        int row = m.length;
        int col = m[0].length;
        boolean[][] visited = new boolean[row][col];

        for(int i=0 ; i < row ; i ++){
            for(int j=0 ; j < col ; j ++){
                if(m[i][j] == 1 && !visited[i][j]){
                    DFS(m, i, j , visited);
                    count ++;
                }
            }
        }

        int countBFS = 0;
        visited = new boolean[row][col];
        for(int i=0 ; i < row ; i ++){
            for(int j=0 ; j < col ; j ++){
                if(m[i][j] == 1 && !visited[i][j]){
                    BFS(m, i, j , visited);
                    countBFS ++;
                }
            }
        }
        System.out.println("BFS >>>>" + countBFS);

        return count;

    }


    //time complexity is O(ROW X COL), using BFS it would be O(ROW + COL )
    private static void DFS(int[][] m, int row, int col, boolean[][] visited) {

        visited[row][col] = true;

        int[] rowDir = new int[]{-1,0,1,1,1,0,-1,-1};
        int[] colDir = new int[]{1,1,1,0,-1,-1,-1,0};

        for(int k = 0; k < 8; k ++ ){
            if(isSafe(m, row + rowDir[k] , col + colDir[k] , visited))
                DFS(m,row + rowDir[k] , col + colDir[k] , visited);
        }

    }
    //time complexity is O(ROW + COL)
    private static void BFS(int[][] m, int row, int col, boolean[][] visited){

        int[] rowDir = new int[]{-1,0,1,1,1,0,-1,-1};
        int[] colDir = new int[]{1,1,1,0,-1,-1,-1,0};

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row,col));
        visited[row][col] = true;

        while(!queue.isEmpty()){
            Pair p = queue.remove();
                for(int k = 0; k < 8; k ++){
                    if(isSafe(m, p.row + rowDir[k], p.col + colDir[k], visited)){
                        visited[p.row + rowDir[k]][p.col + colDir[k]] = true;
                        queue.add(new Pair(p.row + rowDir[k],p.col + colDir[k]));
                    }
                }
        }


    }

    private static boolean isSafe(int [][] M, int row, int col, boolean [][] visited ){
         return (row >=0 )&& (row < M.length) && (col >=0) && (col < M[0].length) && (M[row][col] == 1 && !visited[row][col]);
    }

    static class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };

        int count = numberOfIslands(M);
        System.out.println(count);
    }
}
