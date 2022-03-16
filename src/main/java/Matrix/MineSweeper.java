package Matrix;



import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/*

Minesweeper is a game modeled with n rows, m columns, and p mines.
Each cell is represented by a number which is the number of mines adjacent to it.
Given the rows, columns, and mines, print the numerical representation of the grid.

=========
Example 1
=========

Input: 3 rows, 3 columns, no mines

Output:

000
000
000

=========
Example 2
=========

Input: 3 rows, 3 columns, One mine at (0,0)

Output:

x10
110
000

=========
Example 3
=========

Input: 3 rows, 4 columns, Two mines at (0,0) and (2,2)

Output:

x100
1211
01x1

    |
- --\---
    \

 */
public class MineSweeper{

    public static int[][] minesweeper(int n, int m, int[][] coordinates){

        if(coordinates == null || coordinates.length ==0)
            return new int[n][m];

        int [][] mines = new int[n][m];

        int [][] adjacentsCells = new int[][]{{0,1},{1,1}, {1,0}, {-1,1}, {0,-1}, {-1,-1}, {-1,0}, {1, -1} };

        for(int[] point : coordinates){
            int row = point[0];
            int col = point[1];
            mines[row][col] = 1;

            for(int [] adjCell : adjacentsCells){
                updateAdjaucentCells(row + adjCell[0], col + adjCell[1], mines);
            }
        }


        return mines;


    }

    private static void updateAdjaucentCells(int row, int col, int [][] mines) {

        if(row >=0 && row < mines.length && col >= 0 && col < mines[0].length){
            mines[row][col] += 1;
        }

    }

    public static void main(String[] args) {

        int [][] res = minesweeper(3,3, null);

        print(res);

        System.out.println("*******");

        int[][] coordinates = new int[1][2];
        coordinates[0] = new int[] {0,0} ;
        res = minesweeper(3,3, coordinates);

        print(res);

        System.out.println("*******");

        coordinates = new int[2][2];
        coordinates[0] = new int[] {0,0} ;
        coordinates[1] = new int[] {2,2} ;

        res = minesweeper(3,4, coordinates);

        print(res);
    }

    private static void print(int[][] mines){
        for(int i=0; i < mines.length ;i++){
            for(int j =0; j < mines[0].length ;j++){
                System.out.print(mines[i][j]);
            }
            System.out.println();
        }
    }


}

