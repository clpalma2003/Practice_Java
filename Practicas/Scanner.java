package Practicas;

import java.util.Scanner;

class ScannerPractica {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String name;
        int age;
        char letter;

        System.out.println("Introduce tu nombre");
        name = scanner.nextLine();
    
        System.out.println("Introduce tu edad");
        age  = scanner.nextInt();
        
        System.out.println("Introduce tu letra favorita");
        String letteString = scanner.next();
        letter  = letteString.charAt(0);

        System.out.println("Tu nombre es " + name + ", tienes " + age + " años, tu letra favorita es " 
        + letter);

        scanner.close();
    }




}
