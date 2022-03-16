package Matrix;

public class ExpoOrPower {


    private static void one(double a[][])
    {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
                a[i][j] = 1;
    }

    //Multiply matrix a to matrix b and print result into a
    private static void mul(double a[][], double b[][])
    {
        int size = a.length;
        double res[][] = new double[size][size];

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                for (int k = 0; k < size; k++)
                {
                    res[i][j] += a[i][k] * b[k][j];
                }

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                a[i][j] = res[i][j];
    }

    //Caluclate a^n and print result into matrix res
    public static double[][] pow(double a[][], int n)
    {
        double [][] res = new double[a.length][a.length];
        one(res);

        while (n > 0) {
            if (n % 2 == 0)
            {
                mul(a, a);
                n /= 2;
            }
            else {
                mul(res, a);
                n--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
         double [][] input = new double[][] {{0, 1/2d, 0, 0, 0, 1/2d}, {4/9d, 0, 0, 3/9d, 2/9d, 0}, {0, 0, 1.0d, 0, 0, 0},
                 {0, 0, 0, 1.0d, 0, 0}, {0, 0, 0, 0, 1.0d, 0}, {0, 0, 0, 0, 0, 1.0d}};
    }

}
