package Practicas;

import java.util.Scanner;

class CreateTable {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberToBeMultiplied;
        int tableNumber;
        String verifyLines;
        String verifyColumns;

        System.out.println("Introduce el número de tablas que deseas crear");
        tableNumber = scanner.nextInt();

        if (tableNumber >= 0) {
            System.out.println("Ahora por cuantos numeros deseas multiplicar");
        } else {
            System.out.println("Datos no validos");
            System.exit(0);
        }

        System.out.println("Introduce el número");
        numberToBeMultiplied = scanner.nextInt();

        if (numberToBeMultiplied >= 0) {
            System.out.println("Ahora vamos a construir las tabla");
        } else {
            System.out.println("Datos no validos");
            System.exit(0);
        }
        scanner.close();

        // 1x1 1x2 1x3 1x4 ... 1xn
        // 2x1 2x2 2x3 2x4 ... 2xn
        // .
        // ,
        // .
        // mx1 mx2 mx3 mx4 ... mxn

        for (int i = 1; i <= tableNumber; i++) {
            for (int j = 1; j <= numberToBeMultiplied; j++) {
                System.out.print(i * j + " ");
            }

            System.out.println();
        }

    }
}
