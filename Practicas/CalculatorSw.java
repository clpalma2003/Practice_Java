package Practicas;

import java.util.Scanner;

class CalculatorSw {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        double numberOne;
        double numberTwo;
        double result;
        char operation;

        System.out.println("Introduce el primer número ");
        numberOne = scanner.nextDouble();

        System.out.println("Introduce el segundo número");
        numberTwo = scanner.nextDouble();

        System.out.println("Selecciona el tipo de operación que deseas realizar: (S)uma, (R)esta, (M)ultiplicación, (D)ivisión");
        operation = scanner.next().toUpperCase().charAt(0);


        switch (operation) {
            case 'S':
                result = numberOne + numberTwo;
                System.out.println(result);
                break;
            case 'R':
                result = numberOne - numberTwo;
                System.out.println(result);
                break;
            case 'M':
                result = numberOne - numberTwo;
                System.out.println(result);
                break;
            case 'D':
                result = numberOne / numberTwo;
                System.out.println(result);
                break;
            default:
                System.out.println("Esta opción no existe");
                break;
        }
        scanner.close();
    }
}
