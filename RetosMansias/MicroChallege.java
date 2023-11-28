package RetosMansias;

class MicroChallege {

    // Conocidos dos números, desarrolle un programa que calcule y muestre su
    // promedio.
    public static void main(String[] args) {

        int firstNumber = 6;
        int secondNumber = 8;

        int average = (firstNumber + secondNumber) / 2;
        System.out.println("Tu promedio es " + average);

        // Desarrolle programas que permitan calcular el área de:
        // Un cuadrado (Lado * Lado), conocido el lado.
        // Un rectángulo (Base x Altura), conocidas la base y la altura.
        // Un círculo (Pi x radio ^2) conocido el radio y siendo Pi = 3.141592

        int squareArea = firstNumber * secondNumber;
        System.out.println("El área del cuadrado es " + squareArea);

        int rectangularArea = firstNumber * secondNumber;
        System.out.println("Si tu bases es " + firstNumber + " y tu altura es " + secondNumber + " entonces el área es "
                + rectangularArea);

        double pi = 3.141592;
        double radio = firstNumber * firstNumber;

        double circuleArea = pi * radio;
        System.out.println("El área del circulo es " + circuleArea);

        // Desarrolle un programa que, conociendo sus notas (parcial, final,
        // evaluación contínua y evaluación del profesor), calcule su nota final en
        // UNEATLANTICO.

        double examPartial = 9.0;
        double finalExam = 8.0;
        double continuousEvaluation = 6.7;
        double professorEvalution = 5;

        double finalGrade = (examPartial + finalExam + continuousEvaluation + professorEvalution) / 4;
        System.out.println("Tu nota final es : " + finalGrade);

        // Extienda este reto para que le diga, conocida su nota en el examen parcial y
        // la evaluación contínua, la nota que debe obtener en el examen final
        // (asumiendo una evaluación del profesor de 5).

        double percentageOfExamPartial = 0.1;
        double percentageOfcontinuosEvaluation = 0.3;
        double percentageprofessorEvalution = 0.3;

        double finalGradeExam = (examPartial * percentageOfExamPartial)
                + (continuousEvaluation * percentageOfcontinuosEvaluation)
                + (professorEvalution * percentageprofessorEvalution);
        System.out.println("tu nota final sera : " + finalGradeExam);

    }
}
