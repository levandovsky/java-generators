package com.company;
import java.util.Scanner;

public class Main {
    private static Generator generator = new Generator();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two whole numbers to start calculation.");
        System.out.println("If you wish to end the process, write 'exit'.");
        while (true) {
            try {
                System.out.println("Enter first number:");
                String stringA = scanner.next();
                if (checkExit(stringA)) {
                    printExit();
                    break;
                }
                long a = Long.parseLong(stringA);
                System.out.println("Enter second number:");
                String stringB = scanner.next();
                if (checkExit(stringB)) {
                    printExit();
                    break;
                }
                long b = Long.parseLong(stringB);
                System.out.println("Calculating...");
                int matches = generator.getMatchedCount(a, b);
                if (matches >= 0) {
                    System.out.println("Success! Found: " + matches + " matches!");
                    System.out.println("Finished...");
                    break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Wrong value entered! Please enter whole number!");
                System.out.println("Starting again...");
                scanner.nextLine();
            }
        }

    }

    private static boolean checkExit(String string) {
        return string.equals("exit");
    }

    private static void printExit() {
        System.out.println("Exiting...");
    }


}
