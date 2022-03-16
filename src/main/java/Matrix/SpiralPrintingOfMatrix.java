package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralPrintingOfMatrix {

        public List<Integer> spiralOrder(int[][] matrix) {
            if(matrix == null || matrix.length ==0)
                return new ArrayList();

            int ROW = matrix.length  ,  COL = matrix[0].length ;
            int rstart = 0,  colstart =0,  rend = ROW - 1, colend = COL - 1;

            List<Integer> res = new ArrayList<>();

            while(ROW > 0 && COL > 0){

                for(int i= colstart; i <= colend; i ++){
                    res.add(matrix[rstart][i]);
                }

                rstart++;

                if(rstart > rend)
                    break;

                for(int i=rstart; i <= rend; i ++){
                    res.add(matrix[i][colend]);

                }

                colend--;

                if(colend < colstart){
                    break;
                }

                for(int i= colend; i > colstart; i--){
                    res.add(matrix[rend][i]);

                }

                for(int i= rend; i >= rstart; i--){
                    res.add(matrix[i][colstart]);

                }

                rend --;
                colstart ++;

                ROW = ROW -2 ;
                COL = COL - 2;
            }

            return res;
        }

}
