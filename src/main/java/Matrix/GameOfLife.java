package Matrix;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        if(board == null || board.length ==0)
            return;


        for(int i =0; i < board.length; i++){
            for(int j =0; j < board[0].length; j++){
                int noOfLiveNbrs = getNoOfLiveNeigbhors(board, i , j);
                if(board[i][j] == 1){
                    if(noOfLiveNbrs < 2 || noOfLiveNbrs > 3)
                        board[i][j] = 2; // was alive , dead now
                    //else if(noOfLiveNbrs == 2 || noOfLiveNbrs == 3)
                    //  res[i][j] = 1;
                }else{
                    if(noOfLiveNbrs == 3)
                        board[i][j] = -1; // was dead , live now
                }

            }
        }

        for(int i =0; i < board.length; i++){
            for(int j =0; j < board[0].length; j++){
                //System.out.print(board[i][j]);
                if(board[i][j] == -1 || board[i][j] == 1)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;

            }
            System.out.println();
        }
    }


    private int getNoOfLiveNeigbhors(int[][] A, int row, int col){
        int res = 0;

        int[] rowDir = new int[]{-1,0,1,1,1,0,-1,-1};
        int[] colDir = new int[]{1,1,1,0,-1,-1,-1,0};

        for(int i = 0 ; i < 8; i++){
            int r = row + rowDir[i];
            int c = col + colDir[i];
            if( r >=0 && r < A.length && c >=0 && c < A[0].length ){
                res += decode(A[r][c]);
            }
        }


        return res;
    }

    int decode(int val) {
        return val <= 0 ? 0 : 1; // -1 = was dead , live now,  so consider as a dead...
    }

}
