package RetosMansias;

import java.util.Scanner;

class GuessingTheNumber {

    // El número debe estar entre 1 y 100.
    // El usuario tiene cinco oportunidades para adivinar el número.
    // El ordenador va dando pistas al usuario en caso de no adivinar el número.
    // La pista puede ser "es mayor" o "es menor"
    // Si el usuario adivina, el ordenador nos dice en qué intento se ha adivinado.

    // Caliente, cuando la diferencia entre el número pensado y propuesto es menor o
    // igual a 5
    // Tibio, cuando la diferencia entre números es menor o igual a 10.
    // Frio, si la diferencia es mayor de 10.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int NumberAtGuessing = 10;
        int theNumberGuessingByUser = 0;
        int NUMBEROFOPORTUNITIESTHEYHAVE = 5;

        System.out.println("Adivina el numero ");
        theNumberGuessingByUser = scanner.nextInt();

        while (theNumberGuessingByUser >= 1 && theNumberGuessingByUser <= 100) {

            for (int attemptNumber = 1; attemptNumber <= NUMBEROFOPORTUNITIESTHEYHAVE; attemptNumber++) {

                int howFarAwayIsTheNumber = Math.abs(NumberAtGuessing - theNumberGuessingByUser);
                System.out.println("la diferencia del numero es " + howFarAwayIsTheNumber);

                if (attemptNumber >= NUMBEROFOPORTUNITIESTHEYHAVE) {
                    System.out.println("ya no tienes mas intentos");
                    System.exit(0);
                } else {
                    System.out.println("el numero de intento es " + attemptNumber);
                }

                if (NumberAtGuessing == theNumberGuessingByUser) {
                    System.out.println("Adivinaste");

                } else if (howFarAwayIsTheNumber <= 5) {
                    System.out.println("caliente");
                    theNumberGuessingByUser = scanner.nextInt();

                } else if (howFarAwayIsTheNumber <= 10) {
                    System.out.println("Tibio");
                    theNumberGuessingByUser = scanner.nextInt();
                } else {
                    System.out.println("Frio");
                    theNumberGuessingByUser = scanner.nextInt();
                }
            }
        }
    }
}
