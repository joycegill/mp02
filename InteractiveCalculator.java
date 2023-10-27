import java.io.PrintWriter;
import java.util.*;
import BigFraction.*;

/**
 * Repeatedly reads in a line the user types, uses a BFCalculator to compute the result, 
 * and prints the result for the user.
 * 
 * @author Joyce Gill
 */

public class InteractiveCalculator {
  public static void main(String[] args) throws Exception {
    BFCalculator calc = new BFCalculator();
    PrintWriter pen = new PrintWriter(System.out, true);

    // Take in input
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    try {
      // Quit once user enters "QUIT"
      while (!input.equalsIgnoreCase("QUIT")) {
        // Store
        if (input.contains("STORE")) {
          calc.store(input.charAt(6));
        } // if
        // Evaluate
        else {
          pen.println(input + " = " + calc.evaluate(input));
        } // else
          input = scanner.nextLine();
        } // while 
      } catch (Exception e) {
        System.err.println("Error: incorrect format");
      } // try..catch

    // Close stream
    scanner.close();
    pen.close();

  } // main(String[])
} // class InteractiveCalculator
