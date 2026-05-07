package org.example;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    static void main() {

        System.out.println("Введите ваше имя: ");
        String name = scanner.nextLine();

        int age = readInt("Ввведите ваш возраст: ", "Возраст может быть только числом! И только целым числом!");

        String email = readEmail("Введите вашу электронную почту: ");

        System.out.println("\nПривет, " + name + "! Твой возраст: " + age + ", твой email: " + email);
        scanner.close();
    }

    public static int readInt(String promt, String errorMessage) {
        while (true) {
            System.out.println(promt);
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value < 0) {
                    System.out.println(errorMessage);
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer (e.g., 25).");
            }
        }
    }

    public static String readEmail(String promt) {
        while (true) {
            System.out.println(promt);
            String email = scanner.nextLine().trim();
            if (email.contains("@") && email.indexOf('@') > 0 && email.indexOf('@') < email.length() - 1) {
                return email;
            }
            System.out.println("Please enter a valid email (must contain @, e.g., user@example.com).");
        }
    }
}
