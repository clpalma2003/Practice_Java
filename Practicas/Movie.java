package Practicas;

import java.util.Scanner;

class Movie {

    public static void main(String[] args) {

        // accion,comedia, drama
        // menu de las peliculas , elegir una de las opciones de la pelicula
        // horarios disponibles
        // reserva de un mensaje
        // final imprimir tal pelicula, tal genero y horario
        Scanner scanner = new Scanner(System.in);

        String typeOfMovie = " ";
        String selectMovie = " ";
        String selectTimeToWatchAMovie = " ";
        int confirmationOfTheReservation = ' ';

        System.out.println("introduce el tipo de pelicula que quiere ver: Acción, Comedia, Drama");
        typeOfMovie = scanner.next().toUpperCase();

        switch (typeOfMovie.charAt(0)) {
            case 'A':
                System.out.println(
                        "Elegiste tipo de pelicula de acción ahora selecciona una de las 2 opciones de pelicula disponibles: Qui o It");
                selectMovie = scanner.next().toUpperCase();
                break;
            case 'C':
                System.out.println(
                        "Elegiste tipo de pelicula de comedia ahora selecciona una de las 2 opciones de pelicula disponibles: Fna o Pep");
                selectMovie = scanner.next().toUpperCase();
                break;
            case 'D':
                System.out.println(
                        "Elegiste tipo de pelicula de drama ahora selecciona una de las 2 opciones de pelicula disponibles: Kep o Hui");
                selectMovie = scanner.next().toUpperCase();
                break;
            default:
                System.out.println("Lo siento esa opción no esta disponible");
                System.exit(0);
                break;
        }

        switch (selectMovie.charAt(0)) {
            case 'Q':
                System.out.println("Ahora veamos los horarios disponibles: 1. 8 am o 2. 9 pm ");
                selectTimeToWatchAMovie = scanner.next();
                selectTimeToWatchAMovie = (selectTimeToWatchAMovie.equals("1")) ? "8 am" : "9 pm";
                break;
            case 'I':
                System.out.println("Ahora veamos los horarios disponibles: 1. 10 am o 2. 15 pm ");
                selectTimeToWatchAMovie = scanner.next();
                selectTimeToWatchAMovie = (selectTimeToWatchAMovie.equals("1")) ? "10 pm" : " 15 pm";
                break;
            case 'F':
                System.out.println("Ahora veamos los horarios disponibles: 1. 16 pm o 2. 20 pm  ");
                selectTimeToWatchAMovie = scanner.next();
                selectTimeToWatchAMovie = (selectTimeToWatchAMovie.equals("1")) ? "16 pm" : "20 pm";
                break;
            case 'P':
                System.out.println("Ahora veamos los horarios disponibles: 1. 4 pm o 2. 6 pm ");
                selectTimeToWatchAMovie = scanner.next();
                selectTimeToWatchAMovie = (selectTimeToWatchAMovie.equals("1")) ? "4pm" : "6pm";
                break;
            case 'K':
                System.out.println("Ahora veamos los horarios disponibles: 1. 10 am o 2. 5 pm ");
                selectTimeToWatchAMovie = scanner.next();
                selectTimeToWatchAMovie = (Integer.parseInt(selectTimeToWatchAMovie) == 1) ? "10 am" : "5 pm";
                break;
            case 'H':
                System.out.println("Ahora veamos los horarios disponibles: 1. 8 am o  2. 3 pm ");
                selectTimeToWatchAMovie = scanner.next();
                selectTimeToWatchAMovie = (selectTimeToWatchAMovie.equals("1")) ? "8 am" : "3 pm";
                break;
            default:
                System.out.println("Lo siento esa opción no esta disponible");
                System.exit(0);
                break;
        }

        System.out.println("Tu reserva sería: El género de la pelicula " + typeOfMovie + " seleccionaste ver "
                + selectMovie + " a la hora " + selectTimeToWatchAMovie);

        System.out.println("Deseas confirmar tu reserva: 1.si o 2. no");
        confirmationOfTheReservation = scanner.nextInt();

        switch (confirmationOfTheReservation) {
            case 1:
                System.out.println("Te esperamos");
                break;
            default:
                System.out.println("Vuelve pronto");
                break;
        }
        scanner.close();
    }
}
