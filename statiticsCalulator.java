//max,min,promedio y el numero medio  
//escribe los numeros
//while loop para entrar constante 
//array de 100 numeros , o no 

import java.util.Scanner;

public class statiticsCalulator {
    public static void main(String[] args) {

        int sum = 0;
        int max = 0;
        int min = 0;
        int average = 0;

        Scanner scanner = new Scanner(System.in);

        int[] listOfNumbers = new int[0];
        
        while (listOfNumbers.length < 100) {
            System.out.println("Ingrese un número: ");
            int number = scanner.nextInt();
            
            for (int i = 0; i < listOfNumbers.length; i++) {
                listOfNumbers[i] = number;
            }

            System.out.println("Deseas continuar? 0(Si), 1(No): ");
            int checkIfUserContinue = scanner.nextInt();

            if (checkIfUserContinue == 0) {
                System.out.println("Ingrese un número: ");
                int addNewNumber = scanner.nextInt();

            } else if (checkIfUserContinue == 1) {
                System.out.println(listOfNumbers);
            }

        }
    }
}
