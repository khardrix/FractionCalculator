/*******************************************************************************************
 *******************************************************************************************
 *****                           *| Fraction Calculator |*                             *****
 *****---------------------------------------------------------------------------------*****
 *****  Fraction Class for use in the Course 2: Module Project 2: FractionCalculator.  *****
 *******************************************************************************************
 ******************************************************************************************/

public class Fraction {

    private int numerator = 0;
    private int denominator = 1;


    public Fraction(int num, int den){

        if(den == 0) throw new IllegalArgumentException();
        if(den < 0){
            num *= -1;
            den *= -1;
        }
        this.numerator = num;
        this.denominator = den;
    }


    public Fraction(int num){

        this(num, 1);
    }


    public Fraction(){

        this(0, 1);
    }


    public int getNumerator(){

        return numerator;
    }


    public int getDenominator(){

        return denominator;
    }


    public String toString(){

        if(this.denominator == 1){
            return "" + this.numerator;
        }else if(this.numerator == 0){
            return "0";
        } else {
            return this.numerator + "/" + this.denominator;
        }
    }


    public double toDouble(){

        double n = 1.0 * this.numerator;
        double d = 1.0 * this.denominator;
        return (n / d);
    }


    public String add(Fraction other){

        if(this.numerator == 0){
            toLowestTerms();
            return " = " + other.numerator + "/" + other.denominator;
        }else if(other.denominator == 0){
            toLowestTerms();
            return " = " + this.numerator + "/" + this.denominator;
        }else {
            int multipleFromThis = this.denominator;
            int multipleFromOther = other.denominator;
            int num1Adjusted = this.numerator * multipleFromOther;
            int num2Adjusted = other.numerator * multipleFromThis;
            this.denominator *= multipleFromOther;
            this.numerator = num1Adjusted + num2Adjusted;
            toLowestTerms();
            return " = " + toString();
        }

    }


    public String subtract(Fraction other){

        if(this.numerator == 0){
            toLowestTerms();
            return " = " + other.numerator + "/" + other.denominator;
        }else if(other.denominator == 0){
            toLowestTerms();
            return " = " + this.numerator + "/" + this.denominator;
        }else {
            int multipleFromThis = this.denominator;
            int multipleFromOther = other.denominator;
            int num1Adjusted = this.numerator * multipleFromOther;
            int num2Adjusted = other.numerator * multipleFromThis;
            this.denominator *= multipleFromOther;
            this.numerator = num1Adjusted - num2Adjusted;
            toLowestTerms();
            return " = " + toString();
        }
    }


    public String multiply(Fraction other){

        if(this.numerator == 0 || other.numerator == 0){
            return " = 0";
        }else {
            this.numerator *= other.numerator;
            this.denominator *= other.denominator;
            toLowestTerms();
            return " = " + toString();
        }
    }


    public String divide(Fraction other){

        if(this.numerator == 0 || other.numerator == 0){
            return " is Undefined.";
        }
        else {
            int divisionNumerator = other.denominator;
            int divisionDenominator = other.numerator;
            this.numerator *= divisionNumerator;
            this.denominator *= divisionDenominator;
            toLowestTerms();
            return " = " + toString();
        }
    }


    public boolean equals(Object other){

        if (!(other instanceof Fraction)) {
            return false;
        }
        Fraction fract1 = (Fraction) other;
        fract1.toLowestTerms();
        int gcd = gcd(this.numerator, this.denominator);
        int fGCD = gcd(fract1.numerator, fract1.denominator);
        if(this.numerator == 0 && fract1.numerator != 0){
            return false;
        }else if(fract1.numerator == 0 && this.numerator != 0){
            return false;
        }else if(this.numerator == 0 && fract1.numerator == 0){
            return true;
        }else {
            this.numerator /= gcd;
            this.denominator /= gcd;
            fract1.numerator /= fGCD;
            fract1.denominator /= fGCD;
            if (this.numerator == fract1.numerator && this.denominator == fract1.denominator)
                return true;
            return false;
        }
    }


    public static int gcd(int a, int b){

        if(a == 0){
            return 0;
        }
        while(a != 0 && b != 0){
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }


    public void toLowestTerms(){

        if(this.numerator == 0){
            this.numerator = 0;
        }
        else {
            int gcd = gcd(this.numerator, this.denominator);
            this.numerator /= gcd;
            this.denominator /= gcd;
        }
    }
}
