package Practicas;

import java.util.Scanner;

class Calculator {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        double numberOne;
        double numberTwo;
        int operation;
        double result;

        System.out.println("Introduce el primer número");
        numberOne = scanner.nextDouble();

        System.out.println("Introduce el segundo número");
        numberTwo = scanner.nextDouble();

        System.out.println("Introduce el tipo de operación");
        System.out.println("Opciones : 1. SUMA 2. RESTA 3. MULTIPLICACION 4. DIVISION ");
        operation = scanner.nextInt();

        if(operation == 1){
            result = numberOne + numberTwo;
            System.out.println("Tu resultado de la operacion es " + result);
        }else if(operation == 2){
            result = numberOne - numberTwo;
            System.out.println("Tu resultado de la operacion es " + result);
        }else if(operation == 3){
            result = numberOne * numberTwo;
            System.out.println("Tu resultado de la operacion es " + result);
        }else if(operation ==4){
            result = numberOne / numberTwo;
            System.out.println("Tu resultado de la operacion es " + result);
        }else{
            System.out.println("Operacion no permitida");
        }
        scanner.close();
    }
}
