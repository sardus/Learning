package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UserFileReader {
    public static List<User> readUsersFromCsv(String filename) {
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(filename), StandardCharsets.UTF_8)){
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] fields = parseCsvLine(line);
                if (fields.length != 3) {
                    System.err.println("Skipping invalid line: " + line);
                    continue;
                }

                try {
                    String name = fields[0];
                    int age = Integer.parseInt(fields[1]);
                    String email = fields[2];
                    users.add(new User(name, age, email));
                } catch (Exception e) {
                    System.err.println("Failed to parse user from line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Cannot read file '" + filename + "': " + e.getMessage());
        }
        return users;
    }

    private static String[] parseCsvLine(String line) {
        List<String> fields = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                if (inQuotes && i + 1 < line.length() && line.charAt(i) + 1 == '"') {
                    current.append('"');
                    i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (c == ',' && !inQuotes) {
                fields.add(current.toString());
                current = new StringBuilder();

            } else {
                current.append(c);
            }

        }
        fields.add(current.toString());
        return fields.toArray(new String[0]);
    }
}
