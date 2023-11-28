package Practicas;

import java.util.Scanner;

class Grades {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        char grades;

        System.out.println("Introduce la nota");
        grades = scanner.next().toUpperCase().charAt(0);

        switch (grades) {
            case 'A':
                System.out.println("Excelente");
                break;
            case 'B':
                System.out.println("Bueno");
                break;
            case 'C':
                System.out.println("Satisfactorio");
                break;
            case 'D':
                System.out.println("Deficiente");
                break;
            case 'F':
                System.out.println("Reprobado");
                break;
            default:
                System.out.println("Esa nota no existe");
                break;
        }
        scanner.close();
    }
}
