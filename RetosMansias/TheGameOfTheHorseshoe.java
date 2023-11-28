package RetosMansias;

import java.util.Scanner;

class TheGameOfTheHorseshoe {

    public static void main(String[] args) {
        final double MAX_POINTS = 50;

        int numberOfPointArmad = 0;
        int numberOfPointNaneh = 0;

        Scanner scanner = new Scanner(System.in);

        for (int numberOfTurn = 1; numberOfPointArmad <= MAX_POINTS
                && numberOfPointNaneh <= MAX_POINTS; numberOfTurn++) {

            double firstSection = 0.10;
            double secondSection = 0.12;
            double thirdSection = 0.78;

            double section = Math.random();
            String finalSection;

            if (section <= firstSection) {
                finalSection = ("Tramo 1");
                numberOfPointNaneh += 5;
            } else if (section <= secondSection + secondSection) {
                finalSection = ("Tramo 2");
                numberOfPointNaneh += 3;
            } else {
                finalSection = ("Tramo 3");
                numberOfPointNaneh += 1;
            }

            if (section <= firstSection) {
                finalSection = ("Tramo 1");
                numberOfPointArmad += 5;
            } else if (section <= secondSection) {
                finalSection = ("Tramo 2");
                numberOfPointArmad += 3;
            } else {
                finalSection = ("Tramo 3");
                numberOfPointArmad += 1;
            }
            System.out
                    .println("Lanzamiento N." + numberOfTurn + ": Naneh: " + "[" + finalSection + "]" + " Armad: " + "["
                            + finalSection + "]");

        }
        System.out.println("Puntos Naneh: " + numberOfPointNaneh);
        System.out.println("Puntos Armad: " + numberOfPointArmad);
    }
}