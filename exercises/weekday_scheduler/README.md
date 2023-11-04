# Exercise: Simple Weekday Scheduler

## Objective:

Write a program that outputs the type of activity planned for a day of the week based on user input using a switch statement.

## Task

Ask the user to enter a day of the week (1 for Monday, 2 for Tuesday, etc.). Depending on the day, print out the scheduled activity:

- Monday: Workday
- Tuesday: Gym
- Wednesday: Coding Practice
- Thursday: Workday
- Friday: Reading
- Saturday: Relaxation
- Sunday: Family Time

If the user inputs a number outside of 1-7, print an error message.

## Requirements:

Use a switch statement to select the activity for the chosen day.
Include a default case to handle invalid inputs.

## Sample Output:

```
Enter a number for a day of the week (1-7): 4
Thursday: Workday
```

Or, for an invalid input:

```
Enter a number for a day of the week (1-7): 8
Invalid input! Please enter a number between 1 and 7.
```