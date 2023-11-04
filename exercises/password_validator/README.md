# Exercise: Password Validator

## Objective

Write a program that asks the user to create a password and then enter it again for confirmation. The password must meet certain criteria, and the user should keep being prompted until a valid password is created.

## Task 

The user must enter a password that is at least 8 characters long. If the password is too short, they are informed and asked to enter a new one. This process repeats until the password meets the length requirement. Then the user is asked to confirm the password. If the confirmation does not match, the user is informed and must start over.

## Requirements

- Use a do-while loop to ensure the user is prompted at least once and keeps being prompted until the criteria are met.
- Use a nested do-while loop to ask for the password confirmation if the first password is valid.

## Sample Output

```
Create your password: cat
Your password must be at least 8 characters long.
Create your password: happyday
Confirm your password: happydays
Passwords do not match.
Confirm your password: happyday
Password created successfully!
```