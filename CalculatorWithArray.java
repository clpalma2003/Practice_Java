
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
        int lengthNumbers = scanner.nextInt();

        int[] newListArray = new int[lengthNumbers];

        for (int i = 0; i < lengthNumbers; i++) {
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


int[][] laOficina = {
    {0,0,0,0},
    {0,2,2,4}
    {0,1,2,3}
    {0,1,2,3}
}

    imprimeMundo(laOficina);

    private static void imprimeMundo(int[][] Mundo){
        cleanScreen();
        for(int fila = 0; fila < laOficina; fila++)
            for(int columna = 0; columna < mundo[fila].leght; columna++){
                 System.out.println(traduce(muestraCasilla[fila][columna]))
            }
        System.out.println();
    }

  private static String traduce(int i){
        if(i==1) = "++";
        if(i==2) = "---";
        if(i==3) = "$$";

        return"  ";
    } 

  private static String muestraCasilla(int casilla){
        String[] casillas = {"**","//","00"};
        return casillas [casilla];
    } 

