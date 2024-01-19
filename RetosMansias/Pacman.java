package RetosMansias; //no es necesario
 
import java.util.Random; //para los movimientos random del fantasma

import java.util.Scanner; //siempre debe ir esto

class Pacman { //El nombre de la clase siempre va en mayuscula 

    static Scanner scanner = new Scanner(System.in); //Abrir el escaner para solicitar un input y es estatico
    
    static String lastDirection = "RIGHT"; // Aqui se agrega para poner la direccion de la skin del pacman

    static int lives = 1; //Cuantas vidas tiene el pacman
    
    static int[] ghostPosition = new int[] { 4, 4 }; //En que posicion empieza el fantasma

    public static void main(String[] args) { //aqui esta nuestro main 

        //Se crea la matriz que va contener nuestro universo recuerda que son dos dimensiones por eso lleva [][]
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

        int[] pacmanPosition = new int[] { 1, 1 }; //Se crea la posicion del pacman 

        renderWorld(pacmanWorld, pacmanPosition); // Aqui se imprime el mundo con los parametros del mundo y la posicion del pacman
        runGameLoop(pacmanWorld, pacmanPosition); // Aqui se imprime la logistica del movimiento del Pacman y del fantasma 

        scanner.close(); //Recuerda cerrar el scanner
    }

private static void renderWorld(int[][] world, int[] pacmanPosition) {  
    // Imprime una línea de guiones como borde superior del mundo de Pacman.
    System.out.println("-".repeat(world[0].length * 3 + 2));

    // Bucle para recorrer cada fila del mundo de Pacman.
    for (int row = 0; row < world.length; row++) {
        
        // Bucle para recorrer cada columna de la fila actual.
        for (int column = 0; column < world[row].length; column++) {

            // Verifica si la posición actual es la del fantasma.
            if (row == ghostPosition[0] && column == ghostPosition[1]) {
                
                // Imprime la representación del fantasma.
                System.out.print("{} ");

            // Verifica si la posición actual es la de Pacman.
            } else if (row == pacmanPosition[0] && column == pacmanPosition[1]) {

                String pacmanRepresentation; // Variable para almacenar la representación de Pacman.
                
                // Cambia la representación de Pacman según su última dirección.
                switch (lastDirection) {
                    case "UP": pacmanRepresentation = " :V"; break; // Representación de Pacman mirando hacia arriba.
                        
                    case "DOWN": pacmanRepresentation = " :^"; break; // Representación de Pacman mirando hacia abajo.
                        
                    case "LEFT": pacmanRepresentation = " >:"; break; // Representación de Pacman mirando hacia la izquierda.
                        
                    case "RIGHT": pacmanRepresentation = " :<"; break; // Representación de Pacman mirando hacia la derecha.
                        
                    default: pacmanRepresentation = " :<"; // Representación por defecto si la dirección no es reconocida.
                }
                // Imprime la representación de Pacman.
                System.out.print(pacmanRepresentation);
                
            } else {
                // Imprime el símbolo correspondiente al elemento del mundo en la posición actual.
                System.out.print(getpacmanWorldSymbol(world[row][column]));
            }
        }

        // Imprime un salto de línea para pasar a la siguiente fila.
        System.out.println();
    }

    // Imprime una línea de guiones como borde inferior del mundo de Pacman.
    System.out.println("-".repeat(world[0].length * 3 + 2));
}

private static void moveGhostOne(int[][] pacmanWorld) {
    Random randomMovementOfGosth = new Random(); // Crea un objeto Random para generar números aleatorios.

    boolean ifGhosthmove = false; // Bandera para controlar si el fantasma se ha movido.

    // Bucle que se repite hasta que el fantasma se mueva a una posición válida.
    while (!ifGhosthmove) {
        int direction = randomMovementOfGosth.nextInt(4); // Genera un número aleatorio entre 0 y 3 para la dirección del movimiento del fantasma.

        int newX = ghostPosition[0]; // Variable temporal para la nueva posición en X del fantasma.
        int newY = ghostPosition[1]; // Variable temporal para la nueva posición en Y del fantasma.

        // Estructura switch para determinar la nueva posición del fantasma basada en la dirección aleatoria.
        switch (direction) {
            case 0: newX--; break; // Mueve el fantasma hacia arriba (disminuye la coordenada X).
            case 1: newX++; break; // Mueve el fantasma hacia abajo (aumenta la coordenada X).
            case 2: newY--; break; // Mueve el fantasma hacia la izquierda (disminuye la coordenada Y).
            case 3: newY++; break; // Mueve el fantasma hacia la derecha (aumenta la coordenada Y).
        }

        // Verifica si la nueva posición está dentro de los límites del mundo de Pacman y no es una pared, evita el 2
        if (newX >= 0 && newX < pacmanWorld.length && newY >= 0 && newY < pacmanWorld[0].length
                && (pacmanWorld[newX][newY] == 0 || pacmanWorld[newX][newY] == 1)) {
            ghostPosition[0] = newX; // Actualiza la posición X del fantasma.
            ghostPosition[1] = newY; // Actualiza la posición Y del fantasma.
            ifGhosthmove = true; // Establece la bandera para indicar que el fantasma se ha movido.
        }
    }
}

    private static void runGameLoop(int[][] pacmanWorld, int[] pacmanPosition) {
    boolean hasEnoughLives = true; // Booleano para indicar si Pacman todavía tiene vidas.
    boolean thereAreStillDots = true; // Booleano para indicar si todavía hay puntos por comer en el juego.
    boolean isRunning = hasEnoughLives && thereAreStillDots; // Controla si el juego sigue en ejecución.
    int totalScore = 0; // Variable para llevar la puntuación total.
    int time = 0; // Contador de tiempo (segundos) del juego.

    // Bucle principal del juego. Se ejecuta mientras Pacman tenga vidas y haya puntos por comer.
    while (isRunning) {
        time++; // Incrementa el contador de tiempo en cada iteración del bucle.
        
        // Mueve a Pacman basado en la entrada del usuario y actualiza su posición.
        pacmanPosition = movePacman(pacmanPosition, pacmanWorld.length, pacmanWorld[0].length, pacmanWorld);
        moveGhostOne(pacmanWorld); // Mueve al fantasma.
        totalScore += calculateScore(pacmanWorld, pacmanPosition); // Actualiza la puntuación basada en la posición de Pacman.
        renderWorld(pacmanWorld, pacmanPosition); // Renderiza el mundo de Pacman con las posiciones actualizadas.

        // Comprueba si hay una colisión entre Pacman y el fantasma.
        if (checkCollision(pacmanPosition, ghostPosition)) {
            lives--; // Decrementa una vida si hay colisión.
            // Verifica el estado de las vidas de Pacman después de la colisión.
            if (lives == 0) {
                System.out.println("¡Game Over! Has perdido todas tus vidas.");
                hasEnoughLives = false; // Establece la bandera a false si Pacman no tiene más vidas.
            } else if (lives == 2 || lives == 1) {
                System.out.println("Haz perdido una vida."); // Informa al jugador que ha perdido una vida.
            } else {
                // Resetea la posición de Pacman si todavía le quedan vidas.
                pacmanPosition[0] = 1;
                pacmanPosition[1] = 1;
            }
        }

        // Imprime información relevante sobre el estado actual del juego.
        System.out.println("Time: " + time + " seconds");
        System.out.println("Pacman position: " + pacmanPosition[0] + " fila " + " : " + pacmanPosition[1] + " columna");
        System.out.println("Total Score: " + totalScore);
        System.out.println("Total Lives: " + lives);

        thereAreStillDots = checkDots(pacmanWorld, pacmanPosition); // Verifica si todavía quedan puntos por comer.

        isRunning = hasEnoughLives && thereAreStillDots; // Actualiza la condición de ejecución del juego.
    }
}


    // Método para comprobar si hay una colisión entre Pacman y el fantasma.
private static boolean checkCollision(int[] pacmanPosition, int[] ghostPosition) {
    return pacmanPosition[0] == ghostPosition[0] && pacmanPosition[1] == ghostPosition[1];
    // Retorna true si las posiciones de Pacman y el fantasma son iguales, indicando una colisión.
}

// Método para obtener el símbolo correspondiente a cada elemento del mundo de Pacman.
private static String getpacmanWorldSymbol(int pacmanWorldElement) {
    // Array que mapea los elementos del mundo de Pacman a sus símbolos.
    String[] pacmanWorldSymbols = { "   ", " . ", "\u001B[31m" + "***" + "\u001B[0m", "   " };
    // Retorna el símbolo correspondiente al elemento dado.
    return pacmanWorldSymbols[pacmanWorldElement];
}

// Método para mover a Pacman basado en la entrada del usuario.
private static int[] movePacman(int[] pacmanPosition, int rows, int columns, int[][] pacmanWorld) {
    // Pide al usuario que elija una dirección para mover a Pacman.
    System.out.println("Selecciona una opcion para mover la pacman: w/a/s/d");
    char movementsPacman = scanner.next().charAt(0); // Lee el carácter ingresado por el usuario.

    int newX = pacmanPosition[0]; // Posición temporal en X para Pacman.
    int newY = pacmanPosition[1]; // Posición temporal en Y para Pacman.

    // Estructura switch para mover a Pacman basado en la entrada del usuario, siempre que no haya paredes.
    switch (movementsPacman) {
        case 'w': if (newX > 0 && pacmanWorld[newX - 1][newY] != 2) { newX--; lastDirection = "UP"; } break;
        case 'a': if (newY > 0 && pacmanWorld[newX][newY - 1] != 2) { newY--; lastDirection = "LEFT"; } break;
        case 's': if (newX < rows - 1 && pacmanWorld[newX + 1][newY] != 2) { newX++; lastDirection = "DOWN"; } break;
        case 'd': if (newY < columns - 1 && pacmanWorld[newX][newY + 1] != 2) { newY++; lastDirection = "RIGHT"; } break;
        default: System.out.println("Movimiento no válido. El pacman no puede atravesar paredes."); break;
    }

    // Llama al método para manejar los puntos de teletransporte en el mundo de Pacman.
    int[] newPosition = handleWarpPoints(newX, newY, columns, pacmanWorld);
    return newPosition; // Retorna la nueva posición de Pacman.
}

// Método para manejar los puntos de teletransporte en el mundo de Pacman.
private static int[] handleWarpPoints(int newX, int newY, int columns, int[][] pacmanWorld) {
    // Comprueba si Pacman está en un punto de teletransporte.
    if (pacmanWorld[newX][newY] == 3) {
        // Si Pacman se mueve hacia el borde izquierdo, aparece en el derecho, y viceversa.
        if (newY == 0) { newY = columns - 2; }
        else if (newY == columns - 1) { newY = 1; }
    }
    return new int[] { newX, newY }; // Retorna la posición actualizada de Pacman.
}

// Método para calcular la puntuación de Pacman.
private static int calculateScore(int[][] pacmanWorld, int[] pacmanPosition) {
    // Si Pacman está en una posición con un punto, incrementa la puntuación.
    if (pacmanWorld[pacmanPosition[0]][pacmanPosition[1]] == 1) {
        pacmanWorld[pacmanPosition[0]][pacmanPosition[1]] = 0; // Elimina el punto del mundo.
        return 10; // Retorna 10 puntos.
    }
    return 0; // Si no hay punto, retorna 0.
}

// Método para comprobar si quedan puntos por comer en el mundo de Pacman.
private static boolean checkDots(int[][] pacmanWorld, int[] pacmanPosition) {
    // Recorre cada celda del mundo de Pacman.
    for (int[] row : pacmanWorld) {
        for (int cell : row) {
            if (cell == 1) {
                return true; // Retorna true si encuentra un punto.
            }
        }
    }
    return false; // Retorna false si no hay puntos restantes.
}
