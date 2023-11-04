# Exercise: Class Gradebook

## Objective
Write a program that simulates a simple gradebook for a class. The user (teacher) can enter grades for multiple students and perform operations like finding the average grade, the highest grade, and the lowest grade.

## Task
Implement a program with the following features:

- The user can enter the number of students in a class.
- For each student, the user can enter a fixed number of grades (let's say 5 grades per student).
- Store the grades in a 2D array (matrix) where each row represents a student and each column represents a grade.
- After entering all grades, the program should:
- Calculate the average grade for each student.
- Find the highest grade in the class and the student who achieved it.
- Find the lowest grade in the class and the student who achieved it.
- The program should display the results with appropriate messages.

## Requirements:

- Use arrays or matrices to store students' grades.
- Use loops to populate the array and to compute averages, highest, and lowest grades.
- Use conditionals to determine the highest and lowest grades.

## Sample Output:

```
Enter the number of students: 3

Enter grades for student 1:
Grade 1: 85
Grade 2: 90
Grade 3: 78
Grade 4: 92
Grade 5: 88

Enter grades for student 2:
Grade 1: 75
Grade 2: 80
Grade 3: 70
Grade 4: 80
Grade 5: 85

Enter grades for student 3:
Grade 1: 90
Grade 2: 94
Grade 3: 92
Grade 4: 91
Grade 5: 90

Student 1 Average: 86.6
Student 2 Average: 78.0
Student 3 Average: 91.4

Highest Grade: 94 (Student 3)
Lowest Grade: 70 (Student 2)

```