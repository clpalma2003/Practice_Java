package Practicas;

import java.util.Scanner;

class FoodMenu {
    
    public static void main(String[] args) {
        
        // 1. hamburguesa, 2. pizza, 3/ ensalda
        //elegir menu switch
        //numero = precio
        Scanner scanner = new Scanner(System.in);

        final int BURGER = 1;
        final int PIZZA = 2;
        final int SALAD = 3;

        double priceOfBurger = 12.67;
        double priceOfPizza = 30;
        double priceOfSalad = 78;

        int selectOptionOfMenu;

        System.out.println("Introduce el numero del menu que deseas comer :  1 = Hamburguesa, 2 = Pizza, 3 = Ensalada");
        selectOptionOfMenu = scanner.nextInt();

        switch (selectOptionOfMenu) {
            case BURGER:
                System.out.println(priceOfBurger);
                break;
            case PIZZA:
                System.out.println(priceOfPizza);
                break;
            case SALAD:
                System.out.println(priceOfSalad);
                break;
            default:
                System.out.println("No existe la opción ");
                break;
        }

        scanner.close();
    }
}
