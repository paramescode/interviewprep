package foobar.challenge;

public class Arithmetic {

    public static void main(String[] args) {


        Fraction resilt = add(new Fraction(1,2,-1),
                new Fraction(1,2,-1));
        System.out.println(resilt);

         resilt = add(new Fraction(1,2,1),
                new Fraction(1,2,1));
        System.out.println(resilt);

        resilt = add(new Fraction(1,2,1),
                new Fraction(1,4,-1));
        System.out.println(resilt);

        resilt = add(new Fraction(1,2,-1),
                new Fraction(1,4,1));
        System.out.println(resilt);

        resilt = add(new Fraction(1,2,1),
                new Fraction(1,2,1));
        System.out.println(resilt);

        System.out.println(" minus *********");
        //minus

        resilt = subract(new Fraction(1,2,1),
                new Fraction(1,4,1));
        System.out.println(resilt);

        resilt = subract(new Fraction(1,4,1),
                new Fraction(3,4,1));
        System.out.println(resilt);


        resilt = subract(new Fraction(1,2,-1),
                new Fraction(1,4,-1));
        System.out.println(resilt);

        resilt = subract(new Fraction(1,4,-1),
                new Fraction(1,2,-1));
        System.out.println(resilt);


        resilt = subract(new Fraction(1,2,1),
                new Fraction(1,2,-1));
        System.out.println(resilt);

        resilt = subract(new Fraction(7,2,1),
                new Fraction(1,2,-1));
        System.out.println(resilt);

        resilt = subract(new Fraction(1,2,-1),
                new Fraction(1,2,1));
        System.out.println(resilt);


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
                //numerator = numerator ;
            }
        }else if(b.getSign() > 0 ){
            numerator = (a.getNumerator() * b.getDenominator())  -
                    (a.getDenominator() * b.getNumerator()) ;
            double aValue = (1.0 * a.getNumerator() / a.getDenominator() );
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
}
