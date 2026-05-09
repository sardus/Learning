package org.example;

public record User(String name, int age, String email) {

    @Override
    public String toString() {
        return "User{Your name='" + name() + "', Your age=" + age() + ", Your email='" + email() + "'}";
    }
}