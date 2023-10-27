package mp02;

import java.math.*;

/**
 * An extended version of the Fraction class we worked on in the lab
 * 
 * @author Joyce Gill
 */

public class BigFraction {
  // The numerator of the fraction. Can be positive, zero or negative.
  BigInteger num;

  // The denominator of the fraction. Must be non-negative.
  BigInteger denom;

  // Build a new fraction with numerator num and denominator denom
  public BigFraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;
  }

  // Build a new fraction with numerator num and denominator denom
  public BigFraction(int num, int denom) {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  }

  // Build a new fraction with only numerator num
  public BigFraction(BigInteger num) {
    this.num = num;
    this.denom = BigInteger.valueOf(1);
  }

  // Build a new fraction by parsing a string
  public BigFraction(String str) throws IllegalStateException {
    String[] tempVar = str.split("/");
    if(tempVar.length == 1){
      this.num = BigInteger.valueOf(Integer.parseInt(tempVar[0]));
      this.denom = BigInteger.valueOf(1);
      return;
    }
    try {
      this.num = BigInteger.valueOf(Integer.parseInt(tempVar[0]));
    } catch (Exception e) {
      throw new IllegalStateException("Wrong fraction format!"); 
    }
    Integer numer;
    Integer denomin;
    try {
      numer = Integer.parseInt(tempVar[0]);
      denomin = Integer.parseInt(tempVar[1]);
    } catch (Exception e) {
      throw new IllegalStateException("There is a term that is not an integer");
    }

    if (denomin == 0) {
      throw new IllegalStateException("0 divisor! Please try again.");
    }

    this.num = BigInteger.valueOf(numer);
    this.denom = BigInteger.valueOf(denomin);
  }

  // Express fraction as double
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  }

  public BigInteger gcd(BigInteger num, BigInteger denom) {
    int i;
    int numI = num.intValue();
    int denomI = denom.intValue();
    if (numI < 0) {
      numI *= -1;
    }
    if (numI < denomI) {
      i = numI;
    } else {
      i = denomI;
    }

    for (; i > 1; i--) {
      if (numI % i == 0 && denomI % i == 0) {
        return BigInteger.valueOf(i);
      }
    }

    // if there are no common factors for a and b other
    // than 1, then GCD of a and b is 1
    return BigInteger.valueOf(1);
  }

  // Simplify fractions
  public BigFraction simplify(BigFraction simpMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    BigInteger gcd = gcd(simpMe.num, simpMe.denom);

    resultNumerator = simpMe.num.divide(gcd);
    resultDenominator = simpMe.denom.divide(gcd);
    
    // Return simplified fraction
    return new BigFraction(resultNumerator, resultDenominator);
  }

  // Add the fraction 'addMe' to this fraction
  public BigFraction add(BigFraction addMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // Calculate numerator & denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return simplified result
    BigFraction result = new BigFraction(resultNumerator, resultDenominator);
    return (simplify(result));
  }

  // Subtract the fraction 'subMe' to this fraction
  public BigFraction subtract(BigFraction subMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // Calculate numerator & denominator
    resultDenominator = this.denom.multiply(subMe.denom);
    resultNumerator = (this.num.multiply(subMe.denom)).subtract(subMe.num.multiply(this.denom));

    // Return simplified result
    BigFraction result = new BigFraction(resultNumerator, resultDenominator);
    return (simplify(result));
  }

  // Multiply the fraction 'multiplyMe' to this fraction
  public BigFraction multiply(BigFraction multiplyMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // Calculate numerator & denominator
    resultDenominator = this.denom.multiply(multiplyMe.denom);
    resultNumerator = this.num.multiply(multiplyMe.num);

    // Return simplified result
    BigFraction result = new BigFraction(resultNumerator, resultDenominator);
    return (simplify(result));
  }

  // Divide the fraction 'divMe' to this fraction
  public BigFraction divide(BigFraction divMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // Calculate numerator & denominator
    resultDenominator = this.denom.multiply(divMe.num);
    resultNumerator = this.num.multiply(divMe.denom);

    // Return simplified result
    BigFraction result = new BigFraction(resultNumerator, resultDenominator);
    return (simplify(result));
  }

  /**
   * Multiply the fraction `multiplyMe` to this fraction.
   */
  public BigFraction fractional() {
    BigInteger resultNumerator;

    resultNumerator = this.num.mod(this.denom);

    // Return the computed value
    return new BigFraction(resultNumerator, this.denom);
  }

  // Return denominator
  public BigInteger denominator() {
    return this.denom;
  }

  // Return numerator
  public BigInteger numerator() {
    return this.num;
  }

  // Convert this fraction to a string for ease of printing
  public String toString() {
    // When result is zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    }

    // When result is a whole number
    if (this.denom.equals(BigInteger.ONE)) {
      return this.num.toString();
    }
    // When result is nonzero
    return this.num + "/" + this.denom;
  }
}
