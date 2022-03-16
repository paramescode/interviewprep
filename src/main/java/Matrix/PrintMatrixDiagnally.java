package Matrix;

public class PrintMatrixDiagnally {

    public static void printDiagnally(int[][] A){

        int rows = A.length - 1, cols = A[0].length -1;

        if(A.length == 1){
            for(Integer v : A[0])
                System.out.print( v + " ");

            return;
        }

        // rows
        for(int i=0; i <= rows; i ++){
            int k = i , j = 0;
            while(k >=0 && j <= cols){
                System.out.print(A[k][j]);
                System.out.print(" ");
                k--;
                j++;
            }
            System.out.println();
        }


        //columns
        for(int i=1; i <= cols; i ++){
            int k = i , r = rows;
            while(k <= cols && r >= 0){
                System.out.print(A[r][k]);
                System.out.print(" ");
                r--;
                k++;
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] in = new int[][]{{1,2,3,10},{4,5,6,11}, {7,8,9,12}, {13,14,15,16}};
        printDiagnally(in);

        in = new int[][]{{3}, {2}};
        printDiagnally(in);

        in = new int[][]{{3, 6,7}};
        printDiagnally(in);

        in = new int[][]{{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
        printDiagnally(in);
    }

}
