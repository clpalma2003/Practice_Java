

import java.util.Scanner;

public class multiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.print("Enter a positive integer to display its multiplication table: ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
                System.out.print("Enter a positive integer to display its multiplication table: ");
            }
            number = scanner.nextInt();
        } while (number <= 0);

        System.out.println("Multiplication Table for " + number);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", number, i, number * i);
        }
        
        scanner.close(); 
    }
}
