package Practicas;

import java.util.Scanner;

class WhileLogin {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String user;
        String passwordOne;
        String passwordTwo;

        System.out.println("Introduce un usuario");
        user = scanner.nextLine();

        System.out.println("Introduce una contraseña");
        passwordOne = scanner.nextLine();

        System.out.println("Introduce nuevamente una contraseña");
        passwordTwo = scanner.nextLine();

        while (!passwordOne.equals(passwordTwo)) {
            System.out.println("Contraseña incorrecta repite la contraseña");
            passwordTwo = scanner.nextLine();
        }
        scanner.close();
    }
}
