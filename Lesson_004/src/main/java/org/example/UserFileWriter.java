package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class UserFileWriter {

    public static void writeUsersToCsv(List<User> users, String filename) {
        try (FileWriter writer = new FileWriter(filename, StandardCharsets.UTF_8)) {
            writer.write("name,age,email\n");

            for (User user : users) {
                String name = escapeCsv(user.name());
                String email = escapeCsv(user.email());
                writer.write(name + "," + user.age() + "," + email + "\n");
            }
            System.out.println("Date saved to " + filename + " (UTF-8)");
        } catch (IOException e) {
            System.err.println("Filed to write file: " + e.getMessage());
        }
    }

    private static String escapeCsv(String value) {
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }
}
