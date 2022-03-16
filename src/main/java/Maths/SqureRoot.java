package Maths;

public class SqureRoot {
//https://www.programcreek.com/2012/02/java-calculate-square-root-without-using-library-method/

    public static double squreRoot(int number){

        double sqrRootOfN = number /2;
        double temp = 0.0;

        do{
             temp = sqrRootOfN;
            sqrRootOfN = (sqrRootOfN + (number / sqrRootOfN )) / 2.0;
            System.out.println(sqrRootOfN);

        }while((temp - sqrRootOfN) !=0 );

        return sqrRootOfN;
    }

    public static double squreRootDifferetMethod(int number){

        double z = 1.0;
        double temp = 0.0;

        do{
            temp = z;
            z -= (z * z - number) / (2 *z );
            System.out.println(z);

        }while((temp - z) != 0 );

        return z;
    }

    public static void main(String[] args) {
        System.out.println("Squre Root of " + 2 + "is : " +  squreRoot(2));
        System.out.println("Squre Root of " + 4 + "is : " +  squreRoot(4));
        System.out.println("Squre Root of " + 10 + "is : " +  squreRoot(10));
        System.out.println("Squre Root of " + 100 + "is : " +  squreRoot(100));

        //System.out.println("Squre Root of " + 2 + "is : " +  squreRootDifferetMethod(2));
        //System.out.println("Squre Root of " + 4 + "is : " +  squreRootDifferetMethod(4));
        //System.out.println("Squre Root of " + 10 + "is : " +  squreRootDifferetMethod(10));
        //System.out.println("Squre Root of " + 100 + "is : " +  squreRootDifferetMethod(100));

    }
}
