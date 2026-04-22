// Main entry point
// Handles input
// Uses try-catch-finally

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n*** Smart Registration System ***");
                System.out.println("1). Register User");
                System.out.println("2). View Users");
                System.out.println("3). Delete Users");
                System.out.println("4). Exit");
                System.out.print("Choose: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        registerUser(sc);
                        break;
                    case 2:
                        viewUser();
                        break;
                    case 3:
                        deleteUser(sc);
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                Logger.logError(e.toString());
            }
        }
    }

    public static void registerUser(Scanner sc) {
        try {
            // GET NAME
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            // Input validation
            if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty!");
            }

            // GET AGE
            System.out.print("Enter age: ");
            int age = sc.nextInt(); // can throw InputMismatchException

            // CUSTOM EXCEPTION
            if (age < 18) {
                throw new UnderAgeException("You must be at least 18 years old.");
            }

            // CREATE USER
            User user = new User(name, age);

            // SAVE TO FILE
            UserService.saveUser(user); // may throw IOException
            System.out.println("User registered successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Age must be a number!");
            Logger.logError("InputMismatchException: " + e);
        } catch (UnderAgeException e) {
            System.out.println("Error: " + e.getMessage());
            Logger.logError("UnderAgeException: " + e);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            Logger.logError("IllegalArgumentException: " + e);
        } catch (IOException e) {
            System.out.println("Error: File problem!");
            Logger.logError("IOException: " + e);
        } finally {
            System.out.println("Registration attempt finished.");
            sc.close();
        }
    }

    public static void viewUser() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            String line;

            System.out.println("\n--- Registered Users ---");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file!");
            Logger.logError(e.toString());
        }
    }

    public static void deleteUser(Scanner sc) {
        try {
            List<User> users = readUsers();

            if (users.isEmpty()) {
                System.out.println("No users to delete.");
                return;
            }

            System.out.print("Enter name to delete: ");
            String name = sc.nextLine();

            boolean removed = false;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).name.equalsIgnoreCase(name)) {
                    users.remove(i);
                    removed = true;
                    break;
                }
            }

            if (!removed) {
                System.out.println("User not found.");
                return;
            }

            FileWriter writer = new FileWriter("users.txt");

            for (User u: users) {
                writer.write(u.toString() + "\n");
            }
            writer.close();
            System.out.println("User deleted successfully!");
        } catch (IOException e) {
            System.out.println("Error updating file!");
            Logger.logError(e.toString());
        }
    }

    public static List<User> readUsers() {
        List<User> users = new ArrayList<>();

        try (BufferedReader reader =
                new BufferedReader(new FileReader("users.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                String name = parts[0];
                int age = Integer.parseInt(parts[1]);

                users.add(new User(name, age));
            }
        } catch (IOException e) {
            System.out.println("Error reading file!");
            Logger.logError(e.toString());
        }
        return users;
    }
}
