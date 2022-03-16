package Matrix;

public class FillMatrixInSpiralOrder {

    ///https://leetcode.com/problems/spiral-matrix-ii/

    public int[][] generateMatrix(int n) {
        if(n < 1)
            return new int[][]{};

        int[][] res = new int[n][n];

        int row = n  , col = n  ;
        int rstart = 0, rend = row - 1, colstart = 0, colend = col -1 , nstart = 1, nend = n * n;

        while(row > 0 && col > 0 ){

            for(int i= rstart ; i <=colend ; i++ ){
                res[rstart][i] = nstart++;
            }

            rstart++;

            if(rstart > rend)
                break;

            for(int i= rstart ; i <= rend ; i++ ){
                res[i][colend] = nstart++;
            }

            colend --;

            if(colend < colstart)
                break;

            for(int i= colend ; i >= colstart ; i-- ){
                res[rend][i] = nstart++;
            }

            rend --;

            if(rend < rstart)
                break;

            for(int i= rend ; i >= rstart ; i-- ){
                //System.out.println(nstart);
                res[i][colstart] = nstart++;
            }

            colstart ++;

            if(colstart > colend)
                break;

            row = row - 2;
            col = col - 2;
        }

        return res;
    }



}
