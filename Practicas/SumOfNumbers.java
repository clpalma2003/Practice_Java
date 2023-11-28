package Practicas;

import java.util.Scanner;

class SumOfNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int askNumber;

        System.out.println("Introduce un número");
        askNumber = scanner.nextInt();

        if (askNumber <= 0) {
            System.out.println("No se puede con este tipo de dato");
        } else {
            System.out.println("Ahora a contar");
        }

        scanner.close();

        int i;
        int result = 0;

        for (i = 0; i < askNumber; i++) {
            result += (i + 1);
        }

        System.out.println(result);

    }
}
