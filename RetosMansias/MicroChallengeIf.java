package RetosMansias;

import java.util.Scanner;

class MicroChallengeIf {

    // Escriba un programa que simule el lanzamiento de una moneda y nos diga al
    // ejecutarse si ha salido cara o cruz.
    public static void main(String[] args) {

        if (Math.random() < 0.5) {
            System.out.println(0);
            System.out.println("es cara");
        } else {
            System.out.println(1);
            System.out.println("es cruz");
        }

        // Escriba un programa que pregunte dos números al usuario
        // y realice la división de dos números, siempre y cuando el usuario no pida
        // dividir por cero.

        Scanner scanner = new Scanner(System.in);

        int firstNumber;
        int secondNumber;
        int division;

        System.out.println("Introduce el primer número");
        firstNumber = scanner.nextInt();

        System.out.println("Introduce el segundo número");
        secondNumber = scanner.nextInt();

        if (firstNumber == 0 || secondNumber == 0) {
            System.out.println("no se puede dividir");
        } else {
            System.out.println(division = firstNumber / secondNumber);
        }

        // Escriba un programa que pregunte al usuario los coeficientes y
        // calcule las raíces de una ecuación de segundo grado ax^2 + bx + c = 0.

        double coefficientOfA;
        double coefficientOfB;
        double coefficientOfC;

        System.out.println("Introduce el coeficiente de a:");
        coefficientOfA = scanner.nextDouble();

        System.out.println("Introduce el coeficiente de b:");
        coefficientOfB = scanner.nextDouble();

        System.out.println("Introduce el coeficiente de c:");
        coefficientOfC = scanner.nextDouble();

        double discriminante = Math.pow(coefficientOfB, 2) - (4 * coefficientOfA * coefficientOfC);

        if (discriminante >= 0) {
            double raiz1 = (-coefficientOfB + Math.sqrt(discriminante)) / (2 * coefficientOfA);
            double raiz2 = (-coefficientOfB - Math.sqrt(discriminante)) / (2 * coefficientOfA);

            System.out.println("Las raíces de la ecuación cuadrática son:");
            System.out.println("Raíz 1: " + raiz1);
            System.out.println("Raíz 2: " + raiz2);
        } else {
            System.out.println("La ecuación cuadrática no tiene soluciones reales.");
        }

    }
}
