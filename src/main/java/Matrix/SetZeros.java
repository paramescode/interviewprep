package Matrix;


//https://leetcode.com/problems/set-matrix-zeroes/submissions/


public class SetZeros {

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length ==0)
            return;

        int max = matrix[0][0] + 1;

        for(int i = 0; i < matrix.length; i++){
            int l = 0, r = matrix[0].length;
            while(l < r){
                if(matrix[i][l] + 1 > max){
                    max = matrix[i][l] + 1;
                }
                l++;
            }
        }


        for(int i = 0; i < matrix.length; i++){
            int l = 0, r = matrix[0].length;
            while(l < r){
                if(matrix[i][l] == 0){
                    setZeros(matrix, i, l , max);
                }
                l++;
            }
        }

        for(int i = 0; i < matrix.length; i++){
            int l = 0, r = matrix[0].length;
            while(l < r){
                if(matrix[i][l] == max){
                    matrix[i][l] = 0;
                }
                l++;
            }
        }


    }

    private void setZeros(int [][] m , int row, int col, int max){

        for(int j =0; j < m[0].length; j++){
            if(m[row][j] == 0){

            }else
                m[row][j] = max;
        }

        for(int j =0; j < m.length; j++){
            if(m[j][col] == 0){

            }else
                m[j][col] = max;
        }

    }
}
