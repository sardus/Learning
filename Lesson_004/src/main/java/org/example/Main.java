package org.example;

import java.util.ArrayList;
import java.util.List;


import static org.example.InputReader.*;

public class Main {
    static void main() {
        InputReader reader = new InputReader();

        List<User> users = new ArrayList<>();

        List<User> loaded = UserFileReader.readUsersFromCsv("users.csv");
        if (!loaded.isEmpty()) {
            users.addAll(loaded);
            System.out.println("Loaded " + loaded.size() + " users from users.csv");
        }

        System.out.println("=== User Registration ===");

        while (true) {
            System.out.println("\nEnter name or word 'stop' to exit: ");
            String name = readString("").trim();

            if ("stop".equalsIgnoreCase(name)) {
                break;
            }

            if (name.isEmpty()) {
                System.out.println("Name can't be empty.");
                continue;
            }
            int age = readInt("How old are you? ", "Age can't be negative.");
            String email = readEmail("What's your email? ");

            users.add(new User(name, age, email));
        }

        System.out.println("\nAll registered users:");
        for (User u : users) {
            System.out.println(u);
        }
        UserFileWriter.writeUsersToCsv(users, "users.csv");

        reader.close();
    }
}