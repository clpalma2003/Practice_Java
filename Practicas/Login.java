package Practicas;

import java.util.Scanner;

class Login {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String userNameNew;
        String passwordOne;
        String passwordTwoConfirmation;
        String userNameAlreadyRegistered;
        String passwordAlreadyRegistered;

        System.out.println("Para registrarse introduce un usuario ");
        userNameNew = scanner.nextLine();

        System.out.println("Introduce una contraseña");
        passwordOne = scanner.nextLine();

        System.out.println("Introduce nuevamente tu contraseña");
        passwordTwoConfirmation = scanner.nextLine(); 

        if(passwordTwoConfirmation.equals(passwordOne)){
            System.out.println("Felicidades ya te registraste");
        } else{
            System.out.println("Tu contraseña no es igual");
            System.exit(0);
        };

        System.out.println("-----Login-----");

        System.out.println("Introduce tu usuario");
        userNameAlreadyRegistered = scanner.nextLine();
        
        if(userNameAlreadyRegistered.equals(userNameNew)){
            System.out.println("Vamos al paso siguiente");

        } else{
            System.out.println("No te encuentras registrado");
            System.exit(0);
        }

        System.out.println("Introduce tu contraseña");
        passwordAlreadyRegistered = scanner.nextLine();

        if(passwordAlreadyRegistered.equals(passwordOne)){
            System.out.println("Bienvenido");
        } else{
            System.out.println("Tu contraseña es incorrecta");
        }

        scanner.close();
    }
}
