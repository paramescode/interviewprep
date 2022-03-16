package Matrix;

public class MxNUniquePathWithObsatacles {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;


        int path [][] = new int [row][col];

        if(obstacleGrid[0][0] ==0)
            path[0][0] = 1;

        for(int i=1;i < col;i++)
            if(obstacleGrid[0][i] == 0) // if not an obstacle
                path[0][i] = path[0][i - 1];

        if(row == 1){
            return path[0][col -1];
        }

        for(int i=1; i < row; i++)
            if(obstacleGrid[i][0] == 0)
                path[i][0]= path[i - 1][0];

        for(int i =1; i < row; i++){
            for(int j =1; j < col; j++){
                if(obstacleGrid[i][j] == 0) // if not an obstacle
                    path[i][j] = path[i -1][j] + path[i][j-1];
            }
        }

        return path[row-1][col-1];
    }

    public static void main(String[] args) {
        int [][] a = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }; // 1 is obstacle

        int noOfPath= uniquePathsWithObstacles(a);
        System.out.println(noOfPath);
    }


}
