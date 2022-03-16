package Design;

import java.util.Scanner;

public class StdIn {

    public static String getInout(){
        Scanner scanner = new Scanner(System.in);
        //String s = scanner.next();

        String nl = scanner.nextLine();

       // Integer i = scanner.nextInt();

        return nl;



    }
    public static void main(String[] args) {

        System.out.println(getInout());

        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next());
    }
}
