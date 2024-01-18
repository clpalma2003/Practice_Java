package Practice_Java;
import java.util.Scanner;

class Pacman {

    public static void main(String[] args) {
        int[][] pacmanWorld = {
                { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
                { 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2 },
                { 2, 1, 2, 1, 2, 2, 2, 2, 1, 0, 0, 1, 2, 2, 1, 2, 2, 1, 2 },
                { 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2 },
                { 2, 2, 2, 1, 0, 2, 2, 1, 1, 1, 1, 1, 1, 0, 0, 2, 2, 2, 2 },
                { 0, 0, 2, 1, 0, 2, 2, 2, 1, 2, 2, 2, 1, 1, 1, 2, 0, 0, 0 },
                { 2, 2, 2, 1, 0, 2, 0, 2, 1, 2, 1, 2, 1, 1, 0, 2, 2, 2, 2 },
                { 3, 0, 0, 1, 0, 2, 0, 2, 1, 2, 1, 2, 1, 2, 0, 0, 0, 0, 3 },
                { 2, 2, 2, 1, 0, 2, 2, 2, 1, 1, 1, 1, 1, 0, 0, 2, 2, 2, 2 },
                { 0, 0, 2, 1, 0, 2, 2, 2, 1, 2, 2, 2, 1, 1, 1, 2, 0, 0, 0 },
                { 2, 2, 2, 1, 0, 2, 0, 2, 1, 2, 1, 2, 1, 2, 0, 2, 2, 2, 2 },
                { 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2 },
                { 2, 1, 2, 1, 2, 2, 2, 2, 1, 0, 0, 1, 2, 2, 1, 2, 2, 1, 2 },
                { 2, 1, 1, 1, 1, 2, 1, 1, 1, 0, 2, 1, 2, 1, 1, 1, 1, 1, 2 },
                { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 }
        };

        int[] pacmanPosition = new int[] { 1, 1 };
        boolean isRunning = true;
        int totalScore = 0;

        renderWorld(pacmanWorld, pacmanPosition);

        for (int time = 0; time < 100; time++) {
            pacmanPosition = movePacman(pacmanPosition, pacmanWorld.length, pacmanWorld[0].length, pacmanWorld);
            totalScore += calculateScore(pacmanWorld, pacmanPosition);

            System.out.println("Time: " + time + " Segundos");
            System.out.println("Total Score: " + totalScore);
            System.out.println(
                    "Pacman position: " + pacmanPosition[0] + " fila " + " : " + pacmanPosition[1] + " columna");
            renderWorld(pacmanWorld, pacmanPosition);
        }

        while (isRunning) {
            renderWorld(pacmanWorld, pacmanPosition);
            pacmanPosition = movePacman(pacmanPosition, pacmanWorld.length, pacmanWorld[0].length, pacmanWorld);
        }

    }

    private static int calculateScore(int[][] pacmanWorld, int[] pacmanPosition) {
        if (pacmanWorld[pacmanPosition[0]][pacmanPosition[1]] == 1) {
            pacmanWorld[pacmanPosition[0]][pacmanPosition[1]] = 0;
            return 10;
        }

        return 0;
    }

    static Scanner scanner = new Scanner(System.in);

    private static int[] movePacman(int[] pacmanPosition, int rows, int columns, int[][] pacmanWorld) {

        char movementsPacman;
        System.out.println("Selecciona una opcion para mover la pacman: w/a/s/d");
        movementsPacman = scanner.next().charAt(0);

        int newX = pacmanPosition[0];
        int newY = pacmanPosition[1];

        if (movementsPacman == 'w' && newX > 0 && pacmanWorld[newX - 1][newY] != 2) {
            newX--;
        } else if (movementsPacman == 'a' && newY > 0 && pacmanWorld[newX][newY - 1] != 2) {
            newY--;
        } else if (movementsPacman == 's' && newX < rows - 1 && pacmanWorld[newX + 1][newY] != 2) {
            newX++;
        } else if (movementsPacman == 'd' && newY < columns - 1 && pacmanWorld[newX][newY + 1] != 2) {
            newY++;
        } else {
            System.out.println("Movimiento no válido. El pacman no puede atravesar paredes.");
        }

        if (pacmanWorld[newX][newY] == 3) {
            if (newY == 0) {
                newY = columns - 2;
            } else if (newY == columns - 1) {
                newY = 1;
            }
        }

        return new int[] { newX, newY };

    }

    private static String getpacmanWorldSymbol(int pacmanWorldElement) {

        String[] pacmanWorldSymbols = { "   ", " . ", "\u001B[31m" + "***" + "\u001B[0m", "   " };

        return pacmanWorldSymbols[pacmanWorldElement];
    }

    private static void renderWorld(int[][] world, int[] pacmanPosition) {
        System.out.println("-".repeat(world[0].length * 3 + 2));
        for (int row = 0; row < world.length; row++) {
            for (int column = 0; column < world[row].length; column++) {
                if (row == pacmanPosition[0] && column == pacmanPosition[1]) {
                    System.out.print(" :v");
                } else {
                    System.out.print(getpacmanWorldSymbol(world[row][column]));
                }
            }

            System.out.println();
        }
        System.out.println("-".repeat(world[0].length * 3 + 2));
    }
}
