package com.anktech.pwjproject;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayWithNumber {

    public static boolean isNumberInTable(int[] ints, int k) {
        int minIndex = 0, l = ints.length, maxIndex = l - 1;
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
        if (ints[maxIndex] == k || ints[minIndex] == k)
            return true;
        return false;
    }

    public static int theLittleAbsoluteValue(int[] ints) {
        if (ints == null || ints.length == 0)
            return 0;
        Arrays.sort(ints);
        if (ints[0] > 0)
            return ints[0];
        if (ints[ints.length - 1] < 0)
            return ints[ints.length - 1];
        int maxNegValue = 0, minPosValue = 0;
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
        // TODO: Implement the encoding logic here
        while (!plainTest.isEmpty()) {
            String c = plainTest.substring(0, 1);
            String miniCode = extractCharCode(plainTest, c);
            str.append(miniCode);
            plainTest = plainTest.replaceAll(c, " ").trim();
        }
        return str.toString();
    }

    private String extractCharCode(String plainTest, String c) {
        // TODO Auto-generated method stub
        Pattern pattern = Pattern.compile(c);
        Matcher matcher = pattern.matcher(plainTest);
        int size = 0;
        while (matcher.find()) {
            size += matcher.group().length();
        }
        return String.valueOf(size) + c;
    }
}
