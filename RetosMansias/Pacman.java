package RetosMansias;

import java.util.Random;
import java.util.Scanner;

class Pacman {

    static Scanner scanner = new Scanner(System.in);
    static String lastDirection = "RIGHT";
    static int lives = 1;
    static int[] ghostPosition = new int[] { 4, 4 };

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

        renderWorld(pacmanWorld, pacmanPosition);
        runGameLoop(pacmanWorld, pacmanPosition);

        scanner.close();
    }

    private static void renderWorld(int[][] world, int[] pacmanPosition) {
        System.out.println("-".repeat(world[0].length * 3 + 2));
        for (int row = 0; row < world.length; row++) {
            for (int column = 0; column < world[row].length; column++) {

                if (row == ghostPosition[0] && column == ghostPosition[1]) {
                    System.out.print("{} ");

                } else if (row == pacmanPosition[0] && column == pacmanPosition[1]) {

                    String pacmanRepresentation;
                    switch (lastDirection) {
                        case "UP":
                            pacmanRepresentation = " :V";
                            break;
                        case "DOWN":
                            pacmanRepresentation = " :^";
                            break;
                        case "LEFT":
                            pacmanRepresentation = " >:";
                            break;
                        case "RIGHT":
                            pacmanRepresentation = " :<";
                            break;
                        default:
                            pacmanRepresentation = " :<";
                    }
                    System.out.print(pacmanRepresentation);
                } else {
                    System.out.print(getpacmanWorldSymbol(world[row][column]));
                }
            }

            System.out.println();
        }
        System.out.println("-".repeat(world[0].length * 3 + 2));
    }

    private static void moveGhostOne(int[][] pacmanWorld) {
        Random randomMovementOfGosth = new Random();

        boolean ifGhosthmove = false;

        while (!ifGhosthmove) {
            int direction = randomMovementOfGosth.nextInt(4);
            int newX = ghostPosition[0];
            int newY = ghostPosition[1];

            switch (direction) {
                case 0:
                    newX--;
                    break;
                case 1:
                    newX++;
                    break;
                case 2:
                    newY--;
                    break;
                case 3:
                    newY++;
                    break;
            }

            if (newX >= 0 && newX < pacmanWorld.length && newY >= 0 && newY < pacmanWorld[0].length
                    && (pacmanWorld[newX][newY] == 0 || pacmanWorld[newX][newY] == 1)) {
                ghostPosition[0] = newX;
                ghostPosition[1] = newY;
                ifGhosthmove = true;
            }
        }
    }

    private static void runGameLoop(int[][] pacmanWorld, int[] pacmanPosition) {
        boolean hasEnoughLives = true;
        boolean thereAreStillDots = true;
        boolean isRunning = hasEnoughLives && thereAreStillDots;
        int totalScore = 0;
        int time = 0;

        while (isRunning) {
            time++;
            pacmanPosition = movePacman(pacmanPosition, pacmanWorld.length, pacmanWorld[0].length, pacmanWorld);
            moveGhostOne(pacmanWorld);
            totalScore += calculateScore(pacmanWorld, pacmanPosition);
            renderWorld(pacmanWorld, pacmanPosition);

            if (checkCollision(pacmanPosition, ghostPosition)) {
                lives--;
                if (lives == 0) {
                    System.out.println("¡Game Over! Has perdido todas tus vidas.");
                    hasEnoughLives = false;
                } else if (lives == 2 || lives == 1) {
                    System.out.println("Haz perdido una vida.");
                } else {
                    pacmanPosition[0] = 1;
                    pacmanPosition[1] = 1;
                }
            }

            System.out.println("Time: " + time + " seconds");
            System.out.println(
                    "Pacman position: " + pacmanPosition[0] + " fila " + " : " + pacmanPosition[1] + " columna");
            System.out.println("Total Score: " + totalScore);
            System.out.println("Total Lives: " + lives);

            thereAreStillDots = checkDots(pacmanWorld, pacmanPosition);

            isRunning = hasEnoughLives && thereAreStillDots;

        }

    }

    private static boolean checkCollision(int[] pacmanPosition, int[] ghostPosition) {
        return pacmanPosition[0] == ghostPosition[0] && pacmanPosition[1] == ghostPosition[1];
    }

    private static String getpacmanWorldSymbol(int pacmanWorldElement) {

        String[] pacmanWorldSymbols = { "   ", " . ", "\u001B[31m" + "***" + "\u001B[0m", "   " };

        return pacmanWorldSymbols[pacmanWorldElement];
    }

    private static int[] movePacman(int[] pacmanPosition, int rows, int columns, int[][] pacmanWorld) {

        char movementsPacman;
        System.out.println("Selecciona una opcion para mover la pacman: w/a/s/d");
        movementsPacman = scanner.next().charAt(0);

        int newX = pacmanPosition[0];
        int newY = pacmanPosition[1];

        if (movementsPacman == 'w' && newX > 0 && pacmanWorld[newX - 1][newY] != 2) {
            newX--;
            lastDirection = "UP";
        } else if (movementsPacman == 'a' && newY > 0 && pacmanWorld[newX][newY - 1] != 2) {
            newY--;
            lastDirection = "LEFT";
        } else if (movementsPacman == 's' && newX < rows - 1 && pacmanWorld[newX + 1][newY] != 2) {
            newX++;
            lastDirection = "DOWN";
        } else if (movementsPacman == 'd' && newY < columns - 1 && pacmanWorld[newX][newY + 1] != 2) {
            newY++;
            lastDirection = "RIGHT";
        } else {
            System.out.println("Movimiento no válido. El pacman no puede atravesar paredes.");
        }

        int[] newPosition = handleWarpPoints(newX, newY, columns, pacmanWorld);
        return newPosition;

    }

    private static int[] handleWarpPoints(int newX, int newY, int columns, int[][] pacmanWorld) {
        if (pacmanWorld[newX][newY] == 3) {
            if (newY == 0) {
                newY = columns - 2;
            } else if (newY == columns - 1) {
                newY = 1;
            }
        }
        return new int[] { newX, newY };
    }

    private static int calculateScore(int[][] pacmanWorld, int[] pacmanPosition) {
        if (pacmanWorld[pacmanPosition[0]][pacmanPosition[1]] == 1) {
            pacmanWorld[pacmanPosition[0]][pacmanPosition[1]] = 0;
            return 10;
        }

        return 0;
    }

    private static boolean checkDots(int[][] pacmanWorld, int[] pacmanPosition) {
        for (int[] row : pacmanWorld) {
            for (int cell : row) {
                if (cell == 1) {
                    return true;
                }
            }
        }
        return false;
    }

}