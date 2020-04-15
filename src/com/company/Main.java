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
        float a = scanner.nextFloat();
        System.out.println("Enter second number:");
        float b = scanner.nextFloat();
        float multA = getMult("a", a);
        float multB = getMult("b", b);
        float generatorA = getGenerator(multA);
        float generatorB = getGenerator(multB);
        System.out.println("First generator:" + Integer.toBinaryString(Math.round(generatorA)) + " second generator:" + Integer.toBinaryString(Math.round(generatorB)));
    }

    private static float getGenerator(float number) {
        return number % divider;
    }

    private static float getMult(String factor, float number) {
        if (factor.equals("a")) {
            return number * factorA;
        }

        if (factor.equals("b")) {
            return number * factorB;
        }

        return 0;
    }
}
