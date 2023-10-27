import BigFraction.*;
import java.io.PrintWriter;

/**
 *  Takes in the expressions from the command line and prints out the results.
 * 
 * @author Joyce Gill
 */

public class QuickCalculator {
  public static void main(String[] args) throws Exception {
    BFCalculator calc = new BFCalculator();
    PrintWriter pen = new PrintWriter(System.out, true);

    // Traverse through command line arguments
    for (String exp : args) {
      // Store
      if (exp.contains("STORE")) {
        calc.store(exp.charAt(6)); 
      } // if
      // Evaluate
      else {
        pen.println(exp + " = " + calc.evaluate(exp)); // evaluate
      } // else
    } // for
  } // main(String[])
} // class QuickCalculator
