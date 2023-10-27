package mp02;

import java.io.PrintWriter;
import java.util.*;

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

        // Quit once user enters "QUIT"
        while (!input.equalsIgnoreCase("QUIT")) {
            // Store
            if (input.contains("STORE")) {
                String arr[] = input.split(" ");
                if (arr.length == 2) {
                    char register[] = arr[1].toCharArray();

                    // Correct variable name and type
                    if (register.length == 1) {
                        calc.store(register[0]);
                    }

                    // Incorrect variable type
                    else {
                        scanner.close();
                        throw new Exception("Error: incorrect variable type");
                    }
                }

                // Incorrect number of inputs
                else {
                    scanner.close();
                    throw new Exception("Error: incorrect number of inputs");
                }
            }

            // Evaluate
            else {
                BigFraction num = calc.evaluate(input);
                pen.println(num);
            }
            input = scanner.nextLine();
        }

        // Close stream
        scanner.close();
        pen.close();
    }
}
