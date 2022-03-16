package foobar.challenge;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Fraction {

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

    public static void main(String[] args) {
        Fraction fraction = new Fraction(4, 9,1);
        System.out.println(fraction.numerator + " " + fraction.denominator);

        //System.out.println(greatestCommonFactor(21, 63));
    }

}
