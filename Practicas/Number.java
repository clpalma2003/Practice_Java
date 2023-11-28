package Practicas;

import java.util.Scanner;

class Number {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int number;
        String numberType;

        System.out.println("Introduce un número");
        number = scanner.nextInt();

        numberType = (number % 2 == 0) ? "Par" : "Impar";

        System.out.println("Tu numero es " + numberType);

        scanner.close();
    }
}
