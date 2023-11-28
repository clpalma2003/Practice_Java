package Practicas;

import java.util.Scanner;

class BlackFriday {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int age;
        double price;

        double finalPrice;

        System.out.println("Introduce tu edad");
        age = scanner.nextInt();

        if(age <= 0 ){
            System.exit(0);
        }else{
            System.out.println("Introduce el precio del producto");
            price = scanner.nextDouble();

            if(price <= 0){
                System.exit(0);
                } else{
                    finalPrice = (age >= 65) ? price * 0.9 : price;
            
                    System.out.println("Tu precio final es " + finalPrice);
                }
            }
            scanner.close();
        }
    }

