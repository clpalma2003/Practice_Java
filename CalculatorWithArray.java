
import java.util.Scanner;

// solicitar al usuario una serie de numeros
// alamcenarlos en un array
// utilizar un bucle para sumar los estos numeros 
// calcular el promedio de los numeros
// usar una condicional para mostrar mensajes si el promedio es mayor  a 70.

class CalculatorWithArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresar el tamaño del array:");
        int lengthOfArray = scanner.nextInt();

        int[] newListArray = new int[lengthOfArray];

        for (int i = 0; i < lengthOfArray; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            newListArray[i] = scanner.nextInt();

            System.out.println("Contenido del array: " + newListArray[i]);
        }

        int suma = 0;
        int promedio = 0;
        for (int i = 0; i < newListArray.length; i++) {
            suma = suma + newListArray[i];
            promedio = suma / newListArray.length;
        }

        System.out.println("La suma de los números en el array es: " + suma);
        System.out.println("El promedio de los números en el array es: " + promedio);

        if (promedio > 70) {
            System.out.println("Tu promedio es mayor a 70 pasaste el curso");
        } else {
            System.out.println("El promedio es menor a 70 :(");
        }

    }

}

//Reto aspiradora
int[][] laOficina = {
    {0,0,0,0},
    {0,2,2,4}
    {0,1,2,3}
    {0,1,2,3}
}

    imprimeMundo(laOficina);
    int posicionAspiradoraEnX = 0;
    int posicionAspiradoraEnY = 0;

    private static void imprimeMundo(int[][] mundo, xAspiradora, yAspiradora                                                                            ){
        cleanScreen();
        for(int fila = 0; fila < laOficina; fila++){
            for(int columna = 0; columna < mundo[fila].leght; columna++){
                 System.out.println(muestraCasilla(mundo[fila][columna]))
            }
        System.out.println();
    }
}

  private static String muestraCasilla(int casilla){
        String[] casillas = {"**","//","00"};
        return casillas [casilla];
    } 

