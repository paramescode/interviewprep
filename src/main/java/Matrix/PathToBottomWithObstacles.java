package Matrix;

public class PathToBottomWithObstacles {


    // https://www.geeksforgeeks.org/unique-paths-in-a-grid-with-obstacles/
    public static int isPath(int [][]m){

        if(m == null || m.length ==0)
            return 0;

        if(m.length == 1)
            return 1;

        int path [][] = new int [m.length][m.length];

        if(m[0][0] == 0) // # If current cell is not obstacle
            path[0][0] = 1;
        //first row
        for(int i = 1; i < m.length ; i++){
            if(m[0][i] == 0 ) //# If current cell is not obstacle
                path[0][i] = path[0][i - 1];

        }

        //first col
        for(int i = 1 ; i < m.length ; i++){
            if(m[i][0] == 0 ) //# If current cell is not obstacle
                path[i][0] = path[i-1][0];

        }

        for(int i =1 ; i < m.length ;i ++){
            for(int j =1 ; j < m.length ; j ++){
                if(m[i][j] == 0) // # If current cell is not obstacle
                    path[i][j] = path[i - 1][j] + path[j - 1][i];
            }
        }

        return path[m.length - 1][m.length - 1];


    }

    public static void main(String[] args) {
        int [][] a = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
            }; // 1 is obstacle

        int noOfPath= isPath(a);
        System.out.println(noOfPath);
    }
}
