//Primero va solicitar un numero
//luego va a preguntar si desea continuar(con un while loop)
//Si desea continuar se va almacenar en un array hasta que pare 
//Si no desea continuar se va a imprimir el array
//luego va a imprimir el maximo, minimo, promedio y el numero medio
//La condicion es que el usuario puede ingresar 100 numeros o menos si no para

import java.util.Arrays;
import java.util.Scanner;

public class statiticsCalulator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] listOfNumbers = new int[100];// capacidad de almacenamiento de los numeros
        int countNumberHaveInArray = 0;

        while (countNumberHaveInArray < 100) {

            System.out.println("Ingrese un número: ");
            int number = scanner.nextInt();

            listOfNumbers[countNumberHaveInArray] = number;
            countNumberHaveInArray++;

            System.out.println("Deseas continuar? -1(Si), -2(No): ");
            int checkIfUserWantToContinue = scanner.nextInt();

            if (checkIfUserWantToContinue == -2) {
                System.out.println("Lista de números ingresados: ");

                for (int i = 0; i < countNumberHaveInArray; i++) {
                    System.out.print(listOfNumbers[i] + "\n");

                }

                int maxNumber = listOfNumbers[0];
                int minNumber = listOfNumbers[0];
                int sum = 0;

                for (int i = 0; i < countNumberHaveInArray; i++) {
                    if (listOfNumbers[i] > maxNumber) {
                        maxNumber = listOfNumbers[i];
                    }
                    if (listOfNumbers[i] < minNumber) {
                        minNumber = listOfNumbers[i];
                    }
                    sum += listOfNumbers[i];
                }

                System.out.println("el numero maximo es: " + maxNumber);
                System.out.println("el numero minimo es: " + minNumber);

            }
        }

    }

    private static void cleanScreen() {
        System.out.print("\033[H\033[2J");
    }

}