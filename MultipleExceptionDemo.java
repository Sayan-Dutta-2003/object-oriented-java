// 50.	Write a Java Program for multiple exception in a single code.

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;

public class MultipleExceptionDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Example 1: ArithmeticException (division by zero)
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            int result = divideNumbers(numerator, denominator);
            System.out.println("Division result: " + result);

            // Example 2: ArrayIndexOutOfBoundsException
            System.out.print("Enter array index to access (0-4): ");
            int index = scanner.nextInt();
            int[] numbers = {10, 20, 30, 40, 50};
            System.out.println("Value at index " + index + ": " + numbers[index]);

            // Example 3: FileNotFoundException
            System.out.print("Enter file name to read: ");
            String fileName = scanner.next();
            readFile(fileName);

            // Example 4: NumberFormatException
            System.out.print("Enter a number as string to parse: ");
            String numberStr = scanner.next();
            int parsedNumber = Integer.parseInt(numberStr);
            System.out.println("Parsed number: " + parsedNumber);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input type!");
        } finally {
            System.out.println("\nThis block always executes (cleanup code)");
            scanner.close();
        }

        System.out.println("\nProgram continues after exception handling...");
    }

    public static int divideNumbers(int a, int b) throws ArithmeticException {
        return a / b;
    }

    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        System.out.println("File exists and can be read");
        fileScanner.close();
    }
}