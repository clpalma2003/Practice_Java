package RetosMansias;

import java.util.Scanner;

class VampireBattle {

    public static void main(String[] args) {

        // int vampireLife = 20;
        // int warriorLife = 10;

        int warriorEnergy = 150;
        int vampireEnergy = 60;

        double probabilityOfSuccessWarrior;
        double probabilityOfSuccessVampire;

        int powerOfAttackVampire = 0;
        int powerOfAttackWarrior = 0;

        int selectTheWeapon;

        boolean warriorCanAttack = true;
        boolean vampireCanAttack = true;

        System.out.println("empieza la batalla");

        Scanner scanner = new Scanner(System.in);

        while (vampireEnergy > 0 && warriorEnergy > 0) {

            if (vampireEnergy <= 20 || warriorEnergy <= 30) {
                System.out.println("el personaje se ha desmayado");
                while (!vampireCanAttack || !warriorCanAttack) {
                    warriorEnergy += 2;
                    vampireEnergy += 2;
                    vampireCanAttack = true;
                    warriorCanAttack = true;
                }
            }
            boolean heroDrinkingPotion = true;
            int turnsSincePotion = 0;

            if (heroDrinkingPotion) {
                System.out.println("El guerrero está bebiendo la poción y no puede atacar ni defenderse.");
                turnsSincePotion++;
            }

            if (turnsSincePotion >= 3) {
                System.out.println("El guerrero ha recuperado toda su energía.");
                warriorEnergy = 150;
                heroDrinkingPotion = false;
                turnsSincePotion = 0;
            }

            System.out.println(
                    "Elige el arma que deseas usar: (1) Arma1 = 7 de ataque, (2) Arma2 = 15 de ataque, (3) Arma3 = 30 de ataque, (4) Defenderte = -5 puntos al ataque del vampiro");
            selectTheWeapon = scanner.nextInt();

            if (selectTheWeapon == 1) {
                System.out.println("Seleccionaste el arma 1");
                probabilityOfSuccessWarrior = 0.5;
                powerOfAttackWarrior = 7;
            } else if (selectTheWeapon == 2) {
                System.out.println("Seleccionaste el arma 2");
                probabilityOfSuccessWarrior = 0.25;
                powerOfAttackWarrior = 15;
            } else if (selectTheWeapon == 4) {
                System.out.println("seleccionaste defenderte ");
                probabilityOfSuccessWarrior = 0.80;
                powerOfAttackVampire -= 5;
            } else {
                System.out.println("seleccionaste el arma 3");
                probabilityOfSuccessWarrior = 0.12;
                powerOfAttackWarrior = 20;
            }

            if (Math.random() == 1) {
                System.out.println("el vampiro selecciono el ataque 1");
                probabilityOfSuccessVampire = 0.9;
                powerOfAttackVampire = 5;
            } else if (Math.random() == 2) {
                System.out.println("el vampiro selecciono el ataque 2");
                probabilityOfSuccessVampire = 0.6;
                powerOfAttackVampire = 10;
            } else {
                System.out.println("el vampiro selecciono el ataque 3");
                probabilityOfSuccessVampire = 0.4;
                powerOfAttackVampire = 20;
            }

            if (Math.random() < probabilityOfSuccessVampire) {
                System.out.println("El vampiro ataca");
                warriorEnergy -= powerOfAttackVampire;
                System.out.println("Al Vampiro le queda de energia " + vampireEnergy);
                System.out.println("Al Guerrero le queda de vida " + warriorEnergy);
                System.out.println(
                        "Al guerrero le queda de energia " + warriorEnergy + " y al vampiro le queda "
                                + vampireEnergy);

            } else {
                System.out.println(" Falla el ataque el vampiro ");
                System.out.println("Al Vampiro le queda de vida " + vampireEnergy);
                System.out.println("Al Guerrero le queda de vida " + warriorEnergy);
                System.out.println(
                        "Al guerrero le queda de energia " + warriorEnergy + " y al vampiro le queda "
                                + vampireEnergy);
            }

            if (Math.random() < probabilityOfSuccessWarrior) {
                System.out.println("El guerrero ataca");
                vampireEnergy -= powerOfAttackWarrior;
                System.out.println("Al Vampiro le queda de vida " + vampireEnergy);
                System.out.println("Al Guerrero le queda de vida " + warriorEnergy);
                System.out.println(
                        "Al guerrero le queda de energia " + warriorEnergy + " y al vampiro le queda "
                                + vampireEnergy);
            } else {
                System.out.println(" Falla el ataque el guerrero ");
                System.out.println("Al Vampiro le queda de vida " + vampireEnergy);
                System.out.println("Al Guerrero le queda de vida " + warriorEnergy);
                System.out.println(
                        "Al guerrero le queda de energia " + warriorEnergy + " y al vampiro le queda "
                                + vampireEnergy);
            }

            vampireEnergy -= 5;
            warriorEnergy -= 10;
        }

        if (vampireEnergy <= 0) {
            System.out.println("gana el guerrero");
        } else {
            System.out.println("gana el vampiro");
        }
    }
}