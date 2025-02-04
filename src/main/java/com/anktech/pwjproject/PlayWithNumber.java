package com.anktech.pwjproject;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayWithNumber {

    public static boolean isNumberInTable(int[] ints, int k) {
        int minIndex = 0;
        int l = ints.length;
        int maxIndex = l - 1;
        if (k < ints[minIndex] || k > ints[maxIndex])
            return false;
        do {
            if (k < ints[minIndex + l / 2]) {
                maxIndex = minIndex + l / 2;
            } else if (k > ints[maxIndex - l / 2]) {
                minIndex = maxIndex - l / 2;
            } else
                return true;
            l = maxIndex - minIndex + 1;
        } while (l > 2);
        return ints[maxIndex] == k || ints[minIndex] == k;
    }

    public static int theLittleAbsoluteValue(int[] ints) {
        if (ints == null || ints.length == 0)
            return 0;
        Arrays.sort(ints);
        if (ints[0] > 0)
            return ints[0];
        if (ints[ints.length - 1] < 0)
            return ints[ints.length - 1];
        int maxNegValue = 0;
        int minPosValue = 0;
        for (int i : ints) {
            if (i < 0) {
                maxNegValue = i;
            } else {
                minPosValue = i;
                break;
            }
        }
        int absMaxNegValue = Math.abs(maxNegValue);

        return absMaxNegValue < minPosValue ? maxNegValue : minPosValue;
    }

    public String encodePlainText(String plainTest) {
        StringBuilder str = new StringBuilder();
        while (!plainTest.isEmpty()) {
            String c = plainTest.substring(0, 1);
            String miniCode = extractCharCode(plainTest, c);
            str.append(miniCode);
            plainTest = plainTest.replaceAll(c, " ").trim();
        }
        return str.toString();
    }

    public boolean addUpTo(int[] numbers, int k) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    // 26/ 01/ 25
    private String extractCharCode(String plainTest, String c) {
        Pattern pattern = Pattern.compile(c);
        Matcher matcher = pattern.matcher(plainTest);
        int size = 0;
        while (matcher.find()) {
            size += matcher.group().length();
        }
        return size + c;
    }

    // 27/ 01/ 25
    public int[] productOfAllExceptI(int[] numbers) {
        int product = Arrays.stream(numbers).reduce(1, (a, b) -> a * b);
        return Arrays.stream(numbers).map(i -> product / i).toArray();
    }

    // 28/ 01/ 25
    public int findTheLowestPositiveInteger(int[] numbers1) {
        int[] postNumber = Arrays.stream(numbers1)
                .filter(i -> i > 0).sorted().toArray();
        if (postNumber.length == 0) {
            return 1;
        }
        int lowPos = 0;
        for (int posNumber : postNumber) {
            lowPos++;
            if (lowPos < posNumber)
                return lowPos;
        }
        return ++lowPos;
    }

    // 29/ 01/ 25
    public String cons(int a, int b) {
        return a+","+b;
    }

    public int car(String pair) {
        checkIfThePairIsCorrect(pair);
        return Integer.parseInt(pair.split(",")[0]);
    }

    private void checkIfThePairIsCorrect(String pair) {
        Pattern pattern = Pattern.compile("\\d,\\d");
        Matcher matcher = pattern.matcher(pair);
        if(!matcher.find())
            throw new IllegalArgumentException("Pair Incorrect");
    }

    public int cdr(String pair) {
        checkIfThePairIsCorrect(pair);
        return Integer.parseInt(pair.split(",")[1]);
    }
}
