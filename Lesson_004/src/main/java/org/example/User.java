package org.example;

public record User(String name, int age, String email) {

    public User {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Valid email required");
        }
    }

    @Override
    public String toString() {
        return "User{Your name='" + name() + "', Your age=" + age() + ", Your email='" + email() + "'}";
    }
}