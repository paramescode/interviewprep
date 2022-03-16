package foobar.challenge;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //class used to hold the values with fraction
    static class Fraction {

        public int getNumerator() {
            return numerator;
        }

        public void setNumerator(int numerator) {
            this.numerator = numerator;
        }

        public int getDenominator() {
            return denominator;
        }

        public void setDenominator(int denominator) {
            this.denominator = denominator;
        }

        //main method
        private int numerator, denominator;

        public int getSign() {
            return sign;
        }

        public void setSign(int sign) {
            this.sign = sign;
        }

        private int sign = 1;

        public Fraction(){

        }

        public Fraction(int numerator, int denominator, int sign ) {

            if(numerator != 0 && denominator != 0){
                this.numerator = numerator;
                this.denominator = denominator;
                this.update();
                this.sign = sign;
            }


        }

        public String toString() {
            return ((sign < 0) ? "-" : "") + String.valueOf(numerator) + "/" + String.valueOf(denominator);
        }

        private int greatestCommonFactor(int num, int denom) {
            if (denom == 0) {
                return num;
            }
            return greatestCommonFactor(denom, num % denom);
        }

        private void update(){
            int greatestCommonFactor = greatestCommonFactor(this.numerator, this.denominator);
            if(numerator == 0 || denominator == 0)
                return;
            this.numerator = numerator / greatestCommonFactor;
            this.denominator = denominator / greatestCommonFactor;
        }
    }


    public static int[] solution(int[][] m) {
        // Your code here

        if(m == null || m.length == 0)
            return null;

        Fraction[][] stepsInFractions = new Fraction[m.length][m.length];

        int [] totalStepsFromEachState = new int[m.length];
        int numberOfTerminalStates = 0;

        for(int i = 0 ; i < m.length ; i ++){
            for(int j =0 ; j < m.length ; j ++){
                totalStepsFromEachState[i] += m[i][j];
            }
            if(totalStepsFromEachState[i] == 0){
                numberOfTerminalStates ++;
            }

        }

        for(int i = 0 ; i < m.length ; i ++){
            for(int j =0 ; j < m.length ; j ++){
                stepsInFractions[i][j] = new Fraction(m[i][j], totalStepsFromEachState[i], 1);
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
        int lcm = 1;
        Fraction[] probabilisticStatesFromS0 = stepsToTerminalStates[0];
        List<Integer> denominators = new ArrayList<>();
        int resultIndex = 0;
        for(int i =0; i < probabilisticStatesFromS0.length; i ++){
            if(totalStepsFromEachState[i] ==0 && probabilisticStatesFromS0[i].getDenominator() > 0){
                denominators.add(probabilisticStatesFromS0[i].getDenominator());
            }
        }

        //lcm = lcm_of_array_elements(denominators);
        lcm = lcm(denominators);
        resultIndex = 0;

        for(int i =0; i < probabilisticStatesFromS0.length; i ++){
            if(totalStepsFromEachState[i] == 0 ){
                if(probabilisticStatesFromS0[i].getNumerator() > 0){
                    result[resultIndex] = (probabilisticStatesFromS0[i].getNumerator() * lcm) / probabilisticStatesFromS0[i].getDenominator();

                }
                resultIndex++;
            }
        }
        result[resultIndex] = lcm;
        return result;
    }
    private static int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }


    public static int lcm(List<Integer> numbers) {
        return numbers.stream().reduce(1, (x, y) -> x * (y / gcd(x, y)));
    }

    private static int lcm_of_array_elements(List<Integer> denominators)
    {
        int lcm_of_array_elements = 1;
        int divisor = 2;

        int [] element_array = new int[denominators.size()];
        for(int i =0 ; i < denominators.size() ; i ++){
            element_array[i] = denominators.get(i);
        }

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < element_array.length ; i++) {

                // lcm_of_array_elements (n1, n2, ... 0) = 0.
                // For negative number we convert into
                // positive and calculate lcm_of_array_elements.

                if (element_array[i] == 0) {
                    continue;
                }
                else if (element_array[i] < 0) {
                    element_array[i] = element_array[i] * (-1);
                }
                if (element_array[i] == 1) {
                    counter++;
                }

                // Divide element_array by devisor if complete
                // division i.e. without remainder then replace
                // number with quotient; used for find next factor
                if (element_array[i] % divisor == 0) {
                    divisible = true;
                    element_array[i] = element_array[i] / divisor;
                }
            }

            // If divisor able to completely divide any number
            // from array multiply with lcm_of_array_elements
            // and store into lcm_of_array_elements and continue
            // to same divisor for next factor finding.
            // else increment divisor
            if (divisible) {
                lcm_of_array_elements = lcm_of_array_elements * divisor;
            }
            else {
                divisor++;
            }

            // Check if all element_array is 1 indicate
            // we found all factors and terminate while loop.
            if (counter == element_array.length) {
                return lcm_of_array_elements;
            }
        }
    }

    private static Fraction[][] invert(Fraction a[][])

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

    private static void gaussian(Fraction a[][], int index[])

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

    public static void main(String[] args) {
       int [][] m = new int[][] {{0, 1, 0, 0, 0, 1}, {4, 0, 0, 3, 2, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
       solution(m);
    }

}