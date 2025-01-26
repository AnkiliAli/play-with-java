package com.anktech.pwjproject;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("null");
        // String[] array = { "Hello", "World" };
        // Arrays.stream(array).forEach(System.out::println);

        // StreamApi streamApi = new StreamApi();
        // List<Integer> numbers = Arrays.asList(12, 17, 87, 68, 34, 20);

        // var avg = streamApi.getAverage(numbers);
        // int[] intArray = numbers.stream()
        // .mapToInt(Integer::intValue)
        // .sorted()
        // .peek(System.out::println)
        // .toArray();
        // System.out.println(PlayWithNumber.isNumberInTable(intArray, 100));
        // System.out.println(PlayWithNumber.theLittleAbsoluteValue(intArray));
        // System.out.println(avg);
        // Integer a = 4;
        // Integer b = 4;
        // System.out.println(a.equals(b));
        System.out.println(new PlayWithNumber().encodePlainText("aabbaac"));
    }
}
