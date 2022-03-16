package Matrix;

//https://leetcode.com/problems/sudoku-solver/

/*






/
 */

public class SudokuSolver {

    public static void solveSudoku(char[][] board) {

        solve(board, 0,0);
    }

    private static boolean solve(char[][] board, int x, int y){
        int n = board.length;

        if(x > n - 1 || y > n - 1 )
            return true;

        int nextx = (y == n-1) ? x+1 : x;
        int nexty = (y == n-1) ? 0 : y + 1;

        if(board[x][y] != '.'){
            if(solve(board, nextx, nexty))
                return true;
        }else{
            for(int i=1; i <=9; i++){
                if(valid(board, x, y, i)){
                    board[x][y] = (char)(i+'0');
                    if(solve(board, nextx, nexty))
                        return true;
                    board[x][y] = '.';
                }
            }
        }

        return false;

    }

    private static boolean valid(char[][] board, int x, int y, int val){

        //rows
        for(int i=0; i < board.length; i++){
            //System.out.println(val + " " + board[x][i] +  " " + (val+ '0' == board[x][i]));
            if(val+ '0' == board[x][i] )
                return false;
        }

        //colms
        for(int i=0; i < board.length; i++){
            if(val+ '0' == board[i][y]  )
                return false;
        }

        //boxes
        x = x /3 * 3;
        y = y /3 *3;

        for(int i = 0; i < 3 ;i++){
            for(int j =0; j < 3;j++){
                if(val + '0' == board[x+i][y + j])
                    return false;
            }
        }

        return true;
    }




}
