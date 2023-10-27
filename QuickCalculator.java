package mp02;

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
            if (exp.contains("STORE")) {
                calc.store(exp.charAt(6)); // store
            }
            else {
                pen.println(exp + " = " + calc.evaluate(exp)); // evaluate
            }
        }
    }
}
