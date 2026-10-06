import java.util.Scanner;
import java.util.InputMismatchException;

class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message);
    }
}

public class main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean successful = false;

        while (!successful) {
            try {
                System.out.print("Enter first number: ");
                double num1 = sc.nextDouble();
                System.out.print("Enter operator: ");
                char op = sc.next().charAt(0);
                System.out.print("Enter second number: ");
                double num2 = sc.nextDouble();
                if (op == '/' && num2 == 0) {
                    throw new DivideByZeroException("Division by zero is mathematically undefined.");
                }
                double result = 0;
                boolean valid = true;
                if (op == '+') result = num1 + num2;
                else if (op == '-') result = num1 - num2;
                else if (op == '*') result = num1 * num2;
                else if (op == '/') result = num1 / num2;
                else {
                    System.out.println("Error: Invalid operator chosen.");
                    valid = false;
                }
                if (valid) {
                    System.out.printf("Result: %.2f %c %.2f = %.2f\n", num1, op, num2, result);
                    successful = true;
                }
            } catch (DivideByZeroException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid number input.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
