package Practicas;

import java.util.Scanner;

class Conditions{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String name;

        System.out.println("Introduce tu nombre");
        name = scanner.nextLine();

        if(name.equals("Bob")|| name.equals("Alicia")){
            System.out.println("Hola " + name);
        } else{
            System.out.println("Hola");
        };

        scanner.close();
    }
}
