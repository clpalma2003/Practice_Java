import java.util.Scanner;

class FavoriteColor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String favoriteColor;
        String tryTheUserDoes;
        int MAXATTEMPTS = 3;

        System.out.println("Introduce tu color favorito");
        favoriteColor = scanner.nextLine();

        System.out.println("Trata de adivinar el color");

        for (int tries = 0; tries < MAXATTEMPTS; tries++) {

            tryTheUserDoes = scanner.nextLine();

            if (tryTheUserDoes.equals(favoriteColor)) {
                System.out.println("¡Lo adivinaste!");
                break;

            } else {
                System.out.println("Vuelve a intentarlo");
            }
            scanner.close();
        }
    }
}

// pedir al usuario su color favorito
// otro usuario adivine el color
// tiene 3 intento