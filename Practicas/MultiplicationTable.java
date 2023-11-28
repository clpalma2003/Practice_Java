package Practicas;

import java.util.Scanner;

class MultiplicationTable {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int askNumber;
        int multiplication;
        int number;
        String table;

        System.out.println("Introduce un número");
        askNumber = scanner.nextInt();

        if (askNumber >= 0) {
            System.out.println("La tabla de multiplicación es " + askNumber);
        } else {
            System.out.println("Tipo de dato no permitido");
        }

        scanner.close();

        for (number = 0; number < 11; number++) {
            multiplication = (number * askNumber);
            table = (askNumber + " x " + number);
            System.out.println(table + " = " + multiplication);
        }

    }
}
