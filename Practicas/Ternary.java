package Practicas;

import java.util.Scanner;

class Ternary {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String name;
        String welcomeMessage;

        System.out.println("Introduce tu nombre ");
        name = scanner.nextLine();

        welcomeMessage = name.equals("") ? "Bienvenido Invitado" : "Bienvenido " + name;

        System.out.println(welcomeMessage);

        scanner.close();
    }
}
