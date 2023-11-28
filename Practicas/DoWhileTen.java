package Practicas;

import java.util.Scanner;

class DoWhileTen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOneOfTen;

        System.out.println("Dime un número entre 1 al 10");

        do {
            numberOneOfTen = scanner.nextInt();
        } while (numberOneOfTen <= 0 || numberOneOfTen > 11);

        scanner.close();
    }
}
