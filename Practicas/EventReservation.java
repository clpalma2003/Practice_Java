package Practicas;

import java.util.Scanner;

class EventReservation {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int age;
        int peopleWhoDidTheReservationByEvent;
        int confirmationOfTheReservation;
        String verifyAvailableSpaceForEvent;
        int numberOfNewReservation;

        System.out.println("Hagamos tu reservación, introduce tu edad: ");
        age = scanner.nextInt();

        if(age >= 18){
            System.out.println("Continuemos");
        } else{
            System.out.println("No cumples con los requisitos");
            System.exit(0);
        }
        
        System.out.println("Actualmente han reservado una cantidad de personas");
        peopleWhoDidTheReservationByEvent = scanner.nextInt();

        if(peopleWhoDidTheReservationByEvent >= 100){
            System.out.println("Ya no hay cupo");
            System.exit(0);
        } else{
            System.out.println("Hay cupo");
        }

        System.out.println("Deseas reservar: Introduce un número 1 = si  y 2 = no ");
        confirmationOfTheReservation = scanner.nextInt();

        if(confirmationOfTheReservation == 1){
            System.out.println("Perfecto");
        } else if(confirmationOfTheReservation == 2){
            System.exit(0);
        }

        numberOfNewReservation =  (peopleWhoDidTheReservationByEvent + 1) ;

        verifyAvailableSpaceForEvent = (numberOfNewReservation >= 100)? "Lo siento ya no hay cupo " : "Te esperamos para el evento ";
        System.out.println(verifyAvailableSpaceForEvent);

        scanner.close();
    }
}
