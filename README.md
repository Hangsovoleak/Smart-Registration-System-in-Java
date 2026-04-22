# Smart Registration System (Java Console App)

A simple Java console-based application that demonstrates how to handle exceptions, validate user input, and manage basic file operations such as saving, reading, and deleting user data.

## 📌 Overview

This project was built to practice core Java concepts, especially exception handling. It allows users to register, view, and delete records stored in a text file while ensuring proper validation and error handling.

## ⚙️ Features

* Register a new user (name and age)
* View all registered users
* Delete a user by name
* Input validation (empty name, invalid age, etc.)
* Custom exception for age restriction
* Error logging to a file (`error.log`)
* File handling for storing user data (`users.txt`)
* Menu-based console interface

## 🧠 Concepts Used

* Exception Handling (`try-catch-finally`)
* Custom Exceptions (`UnderAgeException`)
* Checked vs Unchecked Exceptions
* File I/O (`FileWriter`, `BufferedReader`)
* Collections (`List`, `ArrayList`)
* Basic Object-Oriented Programming (OOP)

## 📂 Project Structure

```
src/
 ├── Main.java
 ├── User.java
 ├── UserService.java
 ├── Logger.java
 └── UnderAgeException.java

users.txt
error.log
```

## ▶️ How It Works

1. The user selects an option from the menu.
2. Inputs are validated before processing.
3. Valid users are saved into `users.txt`.
4. Errors are caught and logged into `error.log`.
5. Data is read from the file and converted into objects when needed.

## 🚀 Future Improvements

* Prevent duplicate user registration
* Update user information
* Add email validation
* Improve logging format with timestamps
* Convert to GUI (JavaFX) or web application

## 📝 Example Output

```
*** Smart Registration System ***
1). Register User
2). View Users
3). Delete User
4). Exit
```

## 📖 Purpose

This project is designed for learning and practicing Java fundamentals, especially how real-world applications handle errors and manage data safely.

---

Feel free to fork, improve, and expand this project.
It's just a small project that I want to practice and applied with the lessons I have already learned.