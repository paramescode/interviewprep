package foobar.challenge;


/****
 *
 * Making fuel for the LAMBCHOP's reactor core is a tricky process because of the exotic matter involved.
 * It starts as raw ore, then during processing, begins randomly changing between forms, eventually reaching a stable form.
 * There may be multiple stable forms that a sample could ultimately reach, not all of which are useful as fuel.

 Commander Lambda has tasked you to help the scientists increase fuel creation efficiency by predicting the end state of a given ore sample.

 You have carefully studied the different structures that the ore can take and which transitions it undergoes.
 It appears that, while random, the probability of each structure transforming is fixed.
 That is, each time the ore is in 1 state, it has the same probabilities of entering the next state (which might be the same state).
 You have recorded the observed transitions in a matrix. The others in the lab have hypothesized more exotic forms that the ore can become, but you haven't seen all of them.

 Write a function solution(m) that takes an array of array of nonnegative ints representing how many times that state has gone to the next state
 and return an array of ints for each terminal state giving the exact probabilities of each terminal state, represented as the numerator for each state,
 then the denominator for all of them at the end and in simplest form. The matrix is at most 10 by 10. It is guaranteed that no matter which state the ore is in,
 there is a path from that state to a terminal state. That is, the processing will always eventually end in a stable state.
 The ore starts in state 0. The denominator will fit within a signed 32-bit integer during the calculation, as long as the fraction is simplified regularly.

 For example, consider the matrix m:
 [
 [0,1,0,0,0,1],  # s0, the initial state, goes to s1 and s5 with equal probability
 [4,0,0,3,2,0],  # s1 can become s0, s3, or s4, but with different probabilities
 [0,0,0,0,0,0],  # s2 is terminal, and unreachable (never observed in practice)
 [0,0,0,0,0,0],  # s3 is terminal
 [0,0,0,0,0,0],  # s4 is terminal
 [0,0,0,0,0,0],  # s5 is terminal
 ]
 So, we can consider different paths to terminal states, such as:
 s0 -> s1 -> s3
 s0 -> s1 -> s0 -> s1 -> s0 -> s1 -> s4
 s0 -> s1 -> s0 -> s5
 Tracing the probabilities of each, we find that
 s2 has probability 0
 s3 has probability 3/14
 s4 has probability 1/7
 s5 has probability 9/14
 So, putting that together, and making a common denominator, gives an answer in the form of
 [s2.numerator, s3.numerator, s4.numerator, s5.numerator, denominator] which is
 [0, 3, 2, 9, 14].

 Languages
 =========

 To provide a Java solution, edit Solution.java
 To provide a Python solution, edit solution.py

 Test cases
 ==========
 Your code should pass the following test cases.
 Note that it may also be run against hidden test cases not shown here.

 -- Java cases --
 Input:
 Solution.solution({{0, 2, 1, 0, 0}, {0, 0, 0, 3, 4}, {0, 0, 0, 0, 0}, {0, 0, 0, 0,0}, {0, 0, 0, 0, 0}})
 Output:
 [7, 6, 8, 21]

 Input:
 Solution.solution({{0, 1, 0, 0, 0, 1}, {4, 0, 0, 3, 2, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}})
 Output:
 [0, 3, 2, 9, 14]
 *
 *
 */

//https://www.geeksforgeeks.org/finding-the-probability-of-a-state-at-a-given-time-in-a-markov-chain-set-2/
public class StateTransforms {

    public static int [] solution(double[][] m){

        if(m == null || m.length == 0)
            return null;

        /*List<String> terminalStates = new ArrayList<>();
        Map<String, List<String>> paths = new HashMap<>();

        for(int row =0; row < m.length; row ++){
            paths.put("s"+ row, new ArrayList<>());
            for(int column = 0; column < m.length; column ++ ){
                if(m[row][column] > 0){
                    for(int index =0; index < m[row][column] ; index ++)
                        paths.get("s"+row).add("s"+ column);
                }

            }
            if(paths.get("s" + row).size() == 0)
                terminalStates.add("s"+ row);

            for (String state: paths.get("s"+ row)) {
                System.out.print(state + " ");
            }
            System.out.println();
        }

        for (String state: terminalStates) {
            System.out.print(state + " ");
        }

        printPaths(paths);*/
        double [][] result = matrix_power(m, m.length, m.length);

        //float [][]  result = multiply(m, m, m.length);

        //result = multiply(result, result, m.length);

        //result = multiply(result, m, m.length);

        float [][] finalProb = new float[1][6];
        finalProb[0][0] = 1.0f;



    /*    finalProb = multiply(finalProb, m, m.length); //s1

        finalProb = multiply(finalProb,m, m.length); //s2

        finalProb = multiply(finalProb,m, m.length); //s3

        finalProb = multiply(finalProb,m, m.length); //s4

        finalProb = multiply(finalProb,m, m.length);*/ //s5




        System.out.println(finalProb);


    return new int[]{};
    }

    private static double [][] multiply(double[][] a , double[][] b, int size ){
        double[][] result = new double[a.length][size];
            for(int i=0; i < a.length; i ++){
                for(int j = 0 ; j < size; j++){
                    for(int k = 0; k <  size; k ++){
                        result[i][j] += a[i][k] * b[k][j];

                    }
                }
            }
            return result;
    }

    private static double[][] matrix_power(double [][]a, int t, int size){
        double [][] b = new double[size][size];

        for(int i = 0; i < size; i++)
            b[i][i] = 1.0;

        while(t > 0){
            if( t % 2 != 0)
                b = multiply(b,a, size);
            a = multiply(a,a,size);
            t = t/2;
        }

        //b = multiply(b,a, size);

        return b;
    }

    public static Fraction[][] invert(Fraction a[][])

    {
        int n = a.length;

        Fraction x[][] = new Fraction[n][n];

        Fraction b[][] = new Fraction[n][n];

        int index[] = new int[n];

        for(int i = 0; i < n; i++){
            for(int j =0; j < n ; j ++){
                if(i == j)
                    b[i][j] = new Fraction(1,1,1);
                else
                    b[i][j] = new Fraction();
            }

        }

        // Transform the matrix into an upper triangle

        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored

        for (int i=0; i<n-1; ++i)

            for (int j=i+1; j<n; ++j)

                for (int k=0; k<n; ++k)

                    b[index[j]][k]

                            = subract( b[index[j]][k],mul(a[index[j]][i], b[index[i]][k]));

        // Perform backward substitutions

        for (int i=0; i<n; ++i)

        {
            x[n-1][i] = divide(b[index[n-1]][i],a[index[n-1]][n-1]);
            for (int j=n-2; j>=0; --j)
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k)
                {
                    x[j][i] = subract( x[j][i], mul(a[index[j]][k], x[k][i]));

                }
                x[j][i] = divide(x[j][i], a[index[j]][j]);
            }
        }
        return x;
    }



// Method to carry out the partial-pivoting Gaussian
// elimination.  Here index[] stores pivoting order.

    public static void gaussian(Fraction a[][], int index[])

    {
        int n = index.length;
        Fraction c[] = new Fraction[n];

        // Initialize the index

        for (int i=0; i<n; ++i)
            index[i] = i;
        // Find the rescaling factors, one from each row

        for (int i=0; i<n; ++i)
        {
            double c1 = 0;
            Fraction fractionC1 = new Fraction();
            for (int j=0; j<n; ++j)
            {
                double c0 = 0;
                Fraction fij = a[i][j];
                if(fij.getNumerator() > 0){
                    c0 = (1.0 * fij.getNumerator() / fij.getDenominator());
                }
                if (c0 > c1){
                    c1 = c0;
                    fractionC1 = new Fraction(fij.getNumerator(),
                            fij.getDenominator(), 1);
                }
            }
            c[i] = fractionC1;

        }
        // Search the pivoting element from each column

        int k = 0;
        for (int j=0; j<n-1; ++j)
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i)
            {
                double pi0 = 0;
                Fraction fpi0 = a[index[i]][j];
                if(fpi0.getNumerator() > 0){
                    pi0 =  (1.0 * fpi0.getNumerator() / fpi0.getDenominator());
                }
                if(c[index[i]].getNumerator() > 0){
                    pi0 /= (1.0 * c[index[i]].getNumerator() / c[index[i]].getDenominator());
                }else{
                    pi0 /=0;
                }

                if (pi0 > pi1)
                {
                    pi1 = pi0;
                    k = i;
                }
            }
            // Interchange rows according to the pivoting order

            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i)
            {
                Fraction pj = divide(a[index[i]][j], a[index[j]][j]);

                // Record pivoting ratios below the diagonal

                a[index[i]][j] = new Fraction(pj.getNumerator(), pj.getDenominator(), pj.getSign());

                // Modify other elements accordingly

                for (int l=j+1; l<n; ++l)

                    a[index[i]][l] = subract(a[index[i]][l], mul(pj, a[index[j]][l]));

            }

        }

    }


    private static Fraction [][] multiply(Fraction[][] a , Fraction[][] b, int size ){
        Fraction[][] result = new Fraction[a.length][size];
        for(int i=0; i < a.length; i ++){
            for(int j = 0 ; j < size; j++){
                for(int k = 0; k <  size; k ++){

                    result[i][j] = add(result[i][j],mul(a[i][k], b[k][j]));

                }
            }
        }
        return result;
    }

    private static Fraction mul(Fraction a, Fraction b){
        int numerator = a.getNumerator() * b.getNumerator() ;
        int denominator =  a.getDenominator() * b.getDenominator();
        Fraction res = new Fraction(numerator, denominator, a.getSign() * b.getSign());
        return res  ;
    }

    private static Fraction divide(Fraction a, Fraction b){
        int numerator = a.getNumerator() * b.getDenominator() ;
        int denominator =  a.getDenominator() * b.getNumerator();
        Fraction res = new Fraction(numerator, denominator,a.getSign() * b.getSign());
        return res  ;
    }

    private static Fraction add(Fraction a, Fraction b){
        if(a == null || a.getNumerator() ==0 || a.getDenominator() == 0){
            Fraction res = new Fraction(b.getNumerator(), b.getDenominator(), b.getSign());
            return res ;
        }
        if(b == null || b.getNumerator() ==0 || b.getDenominator() == 0){
            Fraction res = new Fraction(a.getNumerator(), a.getDenominator(), a.getSign());
            return res ;
        }

        int numerator = 0;
        if((a.getSign() < 0 && b.getSign() < 0) || (a.getSign() > 0 && b.getSign() > 0)){
            numerator = (a.getNumerator() * b.getDenominator())  +
                    (a.getDenominator() * b.getNumerator()) ;
            numerator = numerator * a.getSign();
        }else {
            numerator = (a.getNumerator() * b.getDenominator())  -
                    (a.getDenominator() * b.getNumerator()) ;
            double aValue = (1.0 * a.getNumerator() )/ a.getDenominator() ;
            double bValue = (1.0 * b.getNumerator() / b.getDenominator());
            if( aValue  >= bValue){
                numerator = numerator * a.getSign();
            }else{
                numerator = numerator * b.getSign();
            }

        }
        int sign  = numerator < 0? -1: 1;
        if(sign == -1) {
            numerator *= sign;
        }
        int denominator =  a.getDenominator() * b.getDenominator();
        Fraction res = new Fraction(numerator, denominator, sign);
        return res ;
    }

    private static Fraction subract(Fraction a, Fraction b){
        if(a == null || a.getNumerator() ==0 || a.getDenominator() == 0){
            Fraction res = new Fraction(b.getNumerator(), b.getDenominator(), -1 * b.getSign());
            return res ;
        }
        if(b == null || b.getNumerator() ==0 || b.getDenominator() == 0){
            Fraction res = new Fraction(a.getNumerator(), a.getDenominator(), a.getSign());
            return res ;
        }
        int numerator = 0;

        if(a.getSign() > 0 && b.getSign() > 0){
            numerator = (a.getNumerator() * b.getDenominator())  -
                    (a.getDenominator() * b.getNumerator()) ;
        }else if(a.getSign() < 0 && b.getSign() < 0){
            numerator = (a.getNumerator() * b.getDenominator())  +
                    (a.getDenominator() * b.getNumerator()) ;
            numerator *= -1;
        }else if(b.getSign() < 0){
            numerator = (a.getNumerator() * b.getDenominator())  +
                    (a.getDenominator() * b.getNumerator()) ;
            double aValue = (1.0 * a.getNumerator() / a.getDenominator()) ;
            double bValue = (1.0 * b.getNumerator() / b.getDenominator());
            if( aValue  >= bValue){
                numerator = numerator * a.getSign();
            }else{
                //numerator = numerator * b.getSign();
            }
        }else if(b.getSign() > 0 ){
            numerator = (a.getNumerator() * b.getDenominator())  -
                    (a.getDenominator() * b.getNumerator()) ;
            double aValue = (1.0 * a.getNumerator() / a.getDenominator()) ;
            double bValue = (1.0 * b.getNumerator() / b.getDenominator());
            if( aValue  >= bValue){
                numerator = numerator * a.getSign();
            }else{
                numerator = numerator * b.getSign();
            }
        }
        int sign  = numerator < 0? -1: 1;
        if(sign == -1) {
            numerator *= sign;
        }

        int denominator =  a.getDenominator() * b.getDenominator();
        Fraction res = new Fraction(numerator, denominator, sign);
        return res ;
    }

    private static Fraction[][] matrix_power(Fraction [][]a, int t, int size){
        Fraction [][] b = new Fraction[size][size];

        for(int i = 0; i < size; i++){
            for(int j =0; j < size ; j ++){
                if(i == j)
                    b[i][j] = new Fraction(1,1,1);
                else
                    b[i][j] = new Fraction();
            }

        }

        while(t > 0){
            if( t % 2 != 0)
                b = multiply(b,a, size);
            a = multiply(a,a,size);
            t = t/2;
        }
        return b;
    }



    public static void main(String[] args) {

        int[][] input = new int[][] {{0, 2, 1, 0, 0}, {0, 0, 0, 3, 4}, {0, 0, 0, 0, 0}, {0, 0, 0, 0,0}, {0, 0, 0, 0, 0}};

        //solution( input);


        Fraction[][] stepsInFractions = new Fraction[input.length][input.length];

        int [] totalStepsFromEachState = new int[input.length];
        int numberOfTerminalStates = 0;

        for(int i = 0 ; i < input.length ; i ++){
            for(int j =0 ; j < input.length ; j ++){
                totalStepsFromEachState[i] += input[i][j];
            }
            if(totalStepsFromEachState[i] == 0){
                numberOfTerminalStates ++;
            }

        }

        for(int i = 0 ; i < input.length ; i ++){
            for(int j =0 ; j < input.length ; j ++){
                stepsInFractions[i][j] = new Fraction(input[i][j], totalStepsFromEachState[i], 1);
            }
        }

        //The expected number of steps starting from each of the transient states is N = (I - Q)^-1

        Fraction[][] identityMatrixOfStepsInFractions = new Fraction[stepsInFractions.length][stepsInFractions.length];

        for(int i = 0; i < identityMatrixOfStepsInFractions.length; i++){
            for(int j =0; j < identityMatrixOfStepsInFractions.length ; j ++){
                if(i == j)
                    identityMatrixOfStepsInFractions[i][j] = new Fraction(1,1,1);
                else
                    identityMatrixOfStepsInFractions[i][j] = new Fraction();
            }

        }

        //(I - Q)
        for(int i =0 ; i < identityMatrixOfStepsInFractions.length ; i ++){
            for(int j=0; j < identityMatrixOfStepsInFractions.length; j++){
                identityMatrixOfStepsInFractions[i][j] = subract(identityMatrixOfStepsInFractions[i][j], stepsInFractions[i][j]);
            }
        }
        //invert the I -Q matrix: (I - Q)^-1
        Fraction [][] stepsToTerminalStates  = invert(identityMatrixOfStepsInFractions);

        //Fraction[][] result = matrix_power(stepsToTerminalStates, 1, stepsToTerminalStates.length);

        int[] result = new int[numberOfTerminalStates + 1];
        int gcd = 0;
        Fraction[] probabilisticStatesFromS0 = stepsToTerminalStates[0];

        int resultIndex = 0;
        for(int i =0; i < probabilisticStatesFromS0.length; i ++){
            if(totalStepsFromEachState[i] ==0){
                if(probabilisticStatesFromS0[i].getDenominator() > gcd)
                    gcd = probabilisticStatesFromS0[i].getDenominator();
            }
        }


        for(int i =0; i < probabilisticStatesFromS0.length; i ++){
            if(totalStepsFromEachState[i] == 0 ){
                if(probabilisticStatesFromS0[i].getNumerator() > 0){
                    result[resultIndex] = (probabilisticStatesFromS0[i].getNumerator() * gcd) / probabilisticStatesFromS0[i].getDenominator();

                }
                resultIndex++;
            }
        }
        result[resultIndex] = gcd;


        //input = new double[][]{
        //        {0, 2/3d, 1/3d, 0, 0}, {0, 0, 0, 3/7d, 4/7d}, {0, 0, 1.0d, 0, 0}, {0, 0, 0, 1.0d,0}, {0, 0, 0, 0, 1.0d}
        //};
        //solution( input);
    }
}
