package com.company;

import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static int divider = 2147483647;
    static int factorA = 16807;
    static int factorB = 48271;

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number:");
        int a = scanner.nextInt();
        System.out.println("Enter second number:");
        int b = scanner.nextInt();
        int multA = getMult("a", a);
        int multB = getMult("b", b);
        int generatorA = getGenerator(multA);
        int generatorB = getGenerator(multB);
        System.out.println(generatorA);
        System.out.println(generatorB);
        System.out.println("First generator:" + Integer.toBinaryString(generatorA) + " second generator:" + Integer.toBinaryString(generatorB));
    }

    private static int getGenerator(int number) {
        return number % divider;
    }

    private static int getMult(String factor, int number) {
        if (factor.equals("a")) {
            return number * factorA;
        }

        if (factor.equals("b")) {
            return number * factorB;
        }

        return 0;
    }
}
