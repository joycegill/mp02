package mp02;

import java.util.*;
import java.math.*;
import java.io.*;

/**
 * The primary workhorse
 * Includes the two (non-static) methods evaluate and store
 * 
 * @author Joyce Gill
 */

public class BFCalculator {
  // Final result
  BigFraction result = null;

  // Dictionary of the registers
  Dictionary<Character, BigFraction> regDict = new Hashtable<Character, BigFraction>();

  /* Evaluates an expression, ignoring priority */
  public BigFraction evaluate (String exp)
  {
    // String array of all inputs
    String input[] = exp.split(" ");
    
    // If expression contains an incorrect number of arguments 
    if (input.length % 2 == 0) {
      System.err.println("Error: expression contains two numbers/registers in a row.");
    } 

    // The current result
    BigFraction current = getVal(input[0]);

    // Traverse through input
    for (int i = 1; i < input.length - 1; i += 2) {
      // Next Fraction
      BigFraction next = getVal(input[i + 1]);

      // Compute operation
      switch (input[i]) {
        case "+":
          current = current.add(next);
          break;
        case "-":
          current = current.subtract(next);
          break;
        case "*":
          current = current.multiply(next);
          break;
        case "/":
          current = current.divide(next);
          break;
        default:
          System.err.println("Error: invalid operation.");
      } // switch (input[i])
    }

    // Return simplified result
    result = current.simplify(current); 
    return result;
  } // evaluate(String)

    
  public BigFraction getVal(String exp) {
    // If it is a register
    if ((Character.isLowerCase(exp.charAt(0)))) {
      return regDict.get(exp.charAt(0));
    } 
    else {
      return new BigFraction(exp);
    }
  } // getFraction(String)

  public void store(char register) {
    // If the register is not a valid char
    if (result == null || !(Character.isLowerCase(register))) {
      System.err.println("Error: invalid register.");
    }
    // Otherwise store 
    else {
      regDict.put(register, result);
    }
  } // store(char)
} // class BFCalculator
