package Matrix;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/

/**
 *
 *Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

 Each row must contain the digits 1-9 without repetition.
 Each column must contain the digits 1-9 without repetition.
 Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.


 A partially filled sudoku which is valid.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

 Example 1:

 Input:
 [
 ["5","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 Output: true

 Example 2:

 Input:
 [
 ["8","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 Output: false
 Explanation: Same as Example 1, except with the 5 in the top left corner being
 modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

 Note:

 A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 Only the filled cells need to be validated according to the mentioned rules.
 The given board contain only digits 1-9 and the character '.'.
 The given board size is always 9x9.


 *
 *
 *
 *
 */


public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        return solve(board, 0,0);
    }

    private boolean solve(char[][] board, int x, int y){
        int n= board.length;

        if(x > n-1 || y  > n-1)
            return true;

        int nextx = (y == n-1) ? x+1 :x;
        int nexty = (y == n-1) ? 0 : y +1;

        if(isValid(board, x, y)){
            return solve(board, nextx, nexty);
        }else
            return false;


    }

    private boolean isValid(char[][] board, int x, int y){

        Set<Character> seen = new HashSet<>();

        for(int i=0;i < board.length;i++){
            //if(board[x][i] != '.')
            //   System.out.print((board[x][i]) + " ");
            if(board[x][i] != '.' && !seen.add(board[x][i]))
                return false;

        }
        //System.out.println("-----");
        seen.clear();

        for(int i=0;i < board.length;i++){
            //if(board[i][y] != '.')
            // System.out.print((board[i][y])+ " ");
            if(board[i][y] != '.' && !seen.add(board[i][y]))
                return false;

        }
        //System.out.println("*****");
        seen.clear();

        x = x /3 *3;
        y = y /3* 3;

        for(int i=0; i< 3 ; i++){
            for(int j=0; j< 3 ; j++){
                //if(board[i][j] != '.')
                // System.out.print((board[x+i][y+j])+ " ");
                if(board[x+i][y+j] != '.' && !seen.add(board[x+i][y+j]))
                    return false;
            }

        }
        //System.out.println("+++++");
        return true;

    }



}
