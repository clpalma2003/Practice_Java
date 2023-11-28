package exercises.grade_classifier;

import java.util.Scanner;

public class GradeClassifier {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int grade;
        char gradeLetter;

        System.out.println("Input a grade from 0 to 100");

        grade = scanner.nextInt();

        if (grade > 100 || grade < 0) {
            System.out.println("Invalid Grade");
        } else if (grade >= 90 && grade <= 100) {
            gradeLetter = 'A';
        } else if (grade >= 80 && grade < 90) {
            gradeLetter = 'B';
        } else if (grade >= 70 && grade < 80) {
            gradeLetter = 'C';
        } else if (grade >= 60 && grade < 70) {
            gradeLetter = 'D';

        } else if (grade < 60) {
            gradeLetter = 'F';
        }


        scanner.close();
    }
}

