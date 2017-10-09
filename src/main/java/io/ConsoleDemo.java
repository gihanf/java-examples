package io;

import java.io.Console;

public class ConsoleDemo {

    public static void main(String[] args) {
        Console console = System.console();
        if (console != null) {
            console.readLine("Hey there, what's your name?: ");
        } else {
            System.out.println("console was not available");
        }

    }
}
