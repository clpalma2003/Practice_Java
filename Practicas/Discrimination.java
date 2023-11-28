package Practicas;
import java.util.Scanner;

class Discrimination {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int age;
        String clasification = "";

        System.out.println("Introduce tu edad");
        age = scanner.nextInt();

        if( age >= 0 && age <= 12){
            clasification = "Niño";
        } else if(age >= 13 && age <= 18){
            clasification = "Adolescente";
        } else if(age >= 19 && age <= 60){
            clasification = "Adulto";
        } else if(age >= 61 ){
            clasification = "Anciano";
        } else{
            System.out.println("Edad mala");
        };

        if(!clasification.equals("")){
            System.out.println(clasification);
        }

        scanner.close();
    }
}
