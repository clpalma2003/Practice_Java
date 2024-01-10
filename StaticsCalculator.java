
import java.util.Scanner;

class StatisticsCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresar el tamaño del array:");
        int arraySize = scanner.nextInt();

        int[] newListArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            newListArray[i] = scanner.nextInt();
        }

        printNumbers(newListArray, arraySize);
        getMaxNumber(newListArray);
        getMinNumber(newListArray);
        getAverageNumbers(newListArray);
        getMedian(newListArray);
        orderNumbers(newListArray);

        scanner.close();
    }

    private static void printNumbers(int[] listOfNumbers, int arraySize) {
        System.out.println("Lista de números ingresados: ");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(listOfNumbers[i] + "\n");
        }
    }

    private static void getMaxNumber(int[] listOfNumbers) {
        int maxNumber = listOfNumbers[0];
        for (int i = 1; i < listOfNumbers.length; i++) {
            if (listOfNumbers[i] > maxNumber) {
                maxNumber = listOfNumbers[i];
            }
        }
        System.out.println("El número mayor es: " + maxNumber);
    }

    private static void getMinNumber(int[] listOfNumbers) {
        int minNumber = listOfNumbers[0];
        for (int i = 1; i < listOfNumbers.length; i++) {
            if (listOfNumbers[i] < minNumber) {
                minNumber = listOfNumbers[i];
            }
        }
        System.out.println("El número menor es: " + minNumber);
    }

    private static void getAverageNumbers(int[] listOfNumbers) {
        int sum = 0;
        for (int i = 0; i < listOfNumbers.length; i++) {
            sum += listOfNumbers[i];
        }
        System.out.println("El promedio de los números es: " + (sum / listOfNumbers.length));
    }

    
    private static void bubbleSort(int[] listOfNumbers) {
        int n = listOfNumbers.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (listOfNumbers[j - 1] > listOfNumbers[j]) {
                    // swap elements
                    temp = listOfNumbers[j - 1];
                    listOfNumbers[j - 1] = listOfNumbers[j];
                    listOfNumbers[j] = temp;
                }
                
            }
        }
        
    }
    
    public static void orderNumbers(int[] listOfNumbers) {
        System.out.println("Array Before Bubble Sort");
        for (int i = 0; i < listOfNumbers.length; i++) {
            System.out.print(listOfNumbers[i] + " ");
        }
        System.out.println();
        
        bubbleSort(listOfNumbers);// sorting array elements using bubble sort
        
        System.out.println("Array After Bubble Sort");
        for (int i = 0; i < listOfNumbers.length; i++) {
            System.out.print(listOfNumbers[i] + " ");
        }
    }

    private static void getMedian(int[] listOfNumbers) {
    
        int n = listOfNumbers.length;
    
        double median = (n % 2 == 0)
                ? (double) (listOfNumbers[(n - 1) / 2] + listOfNumbers[n / 2]) / 2
                : listOfNumbers[n / 2];
    
        System.out.println("La mediana es: " + median);
    }
}