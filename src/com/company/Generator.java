package com.company;

import java.util.Arrays;
import java.util.List;

class Generator {
    private int iterationNumber = 1000000;
    private int divider = 2147483647;
    private int factorA = 16807;
    private int factorB = 48271;
    private int numbersToCheck = 8;

    private long getGenerator(long number) {
        return Math.floorMod(number, divider);
    }

    private long getFactoredGenerator(String factor, long num) {
        long factoredNumber = getFactoredNumber(factor, num);
        return getGenerator(factoredNumber);
    }

    private long getFactoredNumber(String factor, long num) {
        if (factor.equals("a")) {
            return num * factorA;
        }

        if (factor.equals("b")) {
            return num * factorB;
        }

        return 1;
    }

    private boolean lastNEqual(int n, long a, long b) {
        String binaryA = getBinaryFromGenerator("a", a);
        String binaryB = getBinaryFromGenerator("b", b);
        List<String> stringA = Arrays.asList(binaryA.split(""));
        List<String> stringB = Arrays.asList(binaryB.split(""));
        return getLastNSublist(n, stringA).equals(getLastNSublist(n, stringB));
    }

    private List getLastNSublist(int n, List<String> list) {
        if (n < list.size()) {
            return list.subList(list.size() - n, list.size());
        } else {
            return list;
        }
    }

    private String getBinaryFromGenerator(String factor, long num) {
        long generator = getFactoredGenerator(factor, num);
        String binaryStringRaw = Long.toBinaryString(generator);
        return String.format("%32s", binaryStringRaw.replace(" ", "0"));
    }

    int getMatchedCount(long a, long b) {
        int matchedTimes = 0;

        for (int i = 0; i <= iterationNumber; i++) {
            if (lastNEqual(numbersToCheck, a, b)) {
                matchedTimes++;
            }
            a = getFactoredGenerator("a", a);
            b = getFactoredGenerator("b", b);
        }

        return matchedTimes;
    }
}
