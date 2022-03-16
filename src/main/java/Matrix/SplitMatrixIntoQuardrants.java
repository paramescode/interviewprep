package Matrix;

public class SplitMatrixIntoQuardrants {

    public static void main(String[] args) {

        int[][] m = new int[][]{
                            {1,2,3,4,5,6,7,8},
                            {5,6,7,8,1,2,3,4},
                            {9,10,11,12,13,14,15,16},
                            {13,14,15,16,9,10,11,12},
                            {1,2,3,4,5,6,7,8},
                            {9,10,11,12,13,14,15,16},
                            {5,6,7,8,1,2,3,4},
                            {1,2,3,4,5,6,7,8},

                         };

        printQuadrants(m);

    }


    private static void printQuadrants(int[][] m){

        if(m.length == 2 && m[0].length == 2){
            System.out.println(m[0][0] + " " + m[0][1]);
            System.out.println(m[1][0] + " " + m[1][1]);
            System.out.println("*****");
            return;

        }

        int n = m.length;

        int[][] top_left = new int[m.length / 2][m.length / 2];
        int[][] top_right = new int[m.length / 2][m.length / 2];
        int[][] bottom_left = new int[m.length / 2][m.length / 2];
        int[][] bottom_right = new int[m.length / 2][m.length / 2];

        for(int i=0; i < n; i++){
            for(int j=0; j < n;j++){

                if(i < n/ 2 && j < n / 2 ){
                    top_left[i][j] = m[i][j];
                }else if(i < n / 2 && j >= n / 2 ){
                    top_right[i][j - n/2] = m[i][j];
                }else if(i >= n / 2 && j < n / 2 ){
                    bottom_left[i - n /2][j] = m[i][j];
                }else if(i >= n /2 && j >= n /2){
                    bottom_right[i - n/2][j - n /2] = m[i][j];
                }
            }
        }

        printQuadrants(top_left);
        printQuadrants(top_right);
        printQuadrants(bottom_left);
        printQuadrants(bottom_right);

    }
}
