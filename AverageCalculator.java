import java.util.Scanner; 
import java.util.function.IntConsumer; 
import java.util.stream.IntStream; 

public class AverageCalculator { 
    interface NumberReader { 
        int[] readNumbers(int count); 
    } 
    
    interface NumberProcessor { 
        double processNumbers(int[] numbers); 
                              } 
    interface NumberPrinter { 
        void printNumber(double number); 
    } 
    
    public static void main(String[] args) {
        NumberReader reader = (count) -> 
        { 
            Scanner scanner = new Scanner(System.in); 
            return IntStream.range(0, count) .map(i -> { System.out.println("Enter number " + (i + 1) + ":"); 
            return scanner.nextInt(); }).toArray(); }; 
        
        NumberProcessor processor = (numbers) -> IntStream.of(numbers).average().orElse(Double.NaN); 
        
        NumberPrinter printer = (average) -> { System.out.println("The average is: " + average); 
                                              String message = average > 70? "The average is above 70." : "The average is 70 or below."; 
                                              System.out.println(message); 
                                             }; 
        
        int[] numbers = reader.readNumbers(10); double average = processor.processNumbers(numbers); 
        printer.printNumber(average); 
    } 
}
