

import java.util.Scanner;

class Vacuum {

    final static int TOTAL_GARBAGE_BAG_CAPACITY = 10;

    public static void main(String[] args) {

        int[][] theOffice = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 2, 0, 4, 4, 2, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 2, 0, 4, 0, 4, 4, 2, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 2, 3, 4, 4, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 2, 0, 4, 3, 3, 3, 1, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 2, 3, 4, 0, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 2, 3, 4, 3, 1, 3, 1, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 2, 3, 4, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 2, 3, 4, 3, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        int[] vacuumPosition = { 0, 0 };
        int battery = calculateInitialBattery(theOffice.length, theOffice[0].length, 5);
        int totalDirt = 0;
        int[] garbageCollection = { 0 };

        for (int time = 0; battery > 0; time++) {
            totalDirt = calculateTotalOfDirtyTiles(theOffice);
            System.out.println(" Time " + time + " minutes");
            System.out.println("Movements: " + time);
            System.out.println("Total dirty: " + totalDirt);
            System.out.println("Battery: " + battery);
            System.out.println("Garbage: " + garbageCollection[0]);
            renderWorld(theOffice, vacuumPosition);
            battery = moveVacuum(vacuumPosition, theOffice[0].length, theOffice.length, theOffice, battery);
            theOffice[vacuumPosition[0]][vacuumPosition[1]] = cleanTile(
                    theOffice[vacuumPosition[0]][vacuumPosition[1]], garbageCollection);

            batteryDecreaseBattery(battery);
        }

    }

    private static int batteryDecreaseBattery(int battery) {
        return battery -= 1;
    }

    private static int calculateInitialBattery(int rows, int columns, int numbersOfInterations) {
        int battery = rows * columns * numbersOfInterations;
        return battery;
    }

    private static int calculateTotalOfDirtyTiles(int[][] theOffice) {
        int totalDirt = 0;
        for (int row = 0; row < theOffice.length; row++) {
            for (int column = 0; column < theOffice[row].length; column++) {
                if (theOffice[row][column] > 0) {
                    totalDirt++;
                }
            }
        }
        return totalDirt;
    }

    private static int cleanTile(int tile, int[] garbageCollection) {
        if (canClean(tile, garbageCollection)) {
            tile--;
            garbageCollection[0]++;
        }
        return tile;
    }

    private static boolean canClean(int tile, int[] garbageCollection) {
        return tile > 0 && garbageCollection[0] < TOTAL_GARBAGE_BAG_CAPACITY;
    }

    static Scanner scanner = new Scanner(System.in);

    private static int moveVacuum(int[] vacuumPosition, int rows, int columns, int[][] theOffice, int battery) {

        char movementsVacuum;
        System.out.println("Selecciona una opcion para mover la aspiradora: w/a/s/d");
        movementsVacuum = scanner.next().charAt(0);

        int newX = vacuumPosition[0];
        int newY = vacuumPosition[1];

        if (battery > 0) {
            if (movementsVacuum == 'w' && newX > 0 && theOffice[newX - 1][newY] != 5) {
                newX--;
            } else if (movementsVacuum == 'a' && newY > 0 && theOffice[newX][newY - 1] != 5) {
                newY--;
            } else if (movementsVacuum == 's' && newX < columns - 1 && theOffice[newX + 1][newY] != 5) {
                newX++;
            } else if (movementsVacuum == 'd' && newY < rows - 1 && theOffice[newX][newY + 1] != 5) {
                newY++;
            } else {
                System.out.println("Movimiento no válido. La aspiradora no puede atravesar paredes o muebles.");
                return battery;
            }

            battery--;
        } else {
            System.out.println("La aspiradora se ha quedado sin batería.");
            return battery;
        }

        vacuumPosition[0] = newX;
        vacuumPosition[1] = newY;

        return battery;
    }

    // int dx = (int) (Math.random() * 3) - 1;//
    // int dy = (int) (Math.random() * 3) - 1;//

    // int newX = Math.min(Math.max(vacuumPosition[0] + dx, 0), columns - 1);//
    // int newY = Math.min(Math.max(vacuumPosition[1] + dy, 0), rows - 1);//

    // vacuumPosition[0] = newX;//
    // vacuumPosition[1] = newY;//

    private static void renderWorld(int[][] world, int[] vacuumPosition) {
        System.out.println("-".repeat(world[1].length * 3 + 2));
        for (int row = 0; row < world.length; row++) {
            System.out.print("|");
            for (int column = 0; column < world[row].length; column++) {
                if (row == vacuumPosition[0] && column == vacuumPosition[1]) {
                    System.out.print("(0)");
                } else
                    System.out.print(showTile(world[row][column]));
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-".repeat(world[1].length * 3 + 2));
    }

    private static String showTile(int tile) {
        String[] tiles = { " . ", "...", "ooo", "OOO", "***", "####" };
        return tiles[tile];
    }
}
