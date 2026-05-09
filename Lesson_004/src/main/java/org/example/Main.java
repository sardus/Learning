package org.example;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    static void main() {

        System.out.println("Введите ваше имя: ");
        String name = scanner.nextLine();

        int age = readInt("Ввведите ваш возраст: ", "Возраст может быть только числом! " +
                "И только целым числом!");

        String email = readEmail("Введите вашу электронную почту: ");

        System.out.println("\nПривет, " + name + "! Твой возраст: " + age + ", твой email: " + email);
        scanner.close();
    }

    public static int readInt(String touchAge, String errorMessage) {
        while (true) {
            System.out.println(touchAge);
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

    public static String readEmail(String touchEmail) {
        while (true) {
            System.out.println(touchEmail);
            String email = scanner.nextLine().trim();

            if (!email.contains("@") || email.indexOf('@') <= 0 || email.indexOf('@') > +email.length() - 1) {
                System.out.println("Email must contain '@' not at the start or end.");
                continue;
            }
            String domain = email.substring(email.indexOf('@') + 1);
            if (!domain.contains(".") || domain.indexOf('.') == 0 || domain.indexOf('.') == domain.length() - 1) {
                System.out.println("Domain must contain a dot (e.g., example.com).");
                continue;
            }

            String[] validTlds = {".com", ".net", ".org", ".ru", ".io"};
            boolean hasValidTLd = false;
            for (String tld : validTlds) {
                if (domain.endsWith(tld)) {
                    hasValidTLd = true;
                    break;
                }
            }
            if (hasValidTLd) {
                return email;
            } else {
                System.out.println("Please use a common domain like .com, .net, .org, .ru, or .io.");
            }
        }
    }
}
