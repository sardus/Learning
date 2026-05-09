package org.example;

import java.util.ArrayList;


import static org.example.InputReader.*;

public class Main {
    static void main() {
        InputReader reader = new InputReader();

        System.out.println("=== User Registration ===");

        ArrayList<User> users = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            String name = readString("What's your name? ");
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