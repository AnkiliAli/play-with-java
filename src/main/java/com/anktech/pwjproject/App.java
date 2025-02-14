package com.anktech.pwjproject;


import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


/**
 * ANK-TECH
 *
 */

public class App {
    static Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
         String[] array = { "Hello", "World" };
         Arrays.stream(array).forEach(w->logger.info(w));

         StreamApi streamApi = new StreamApi();
         List<Integer> numbers = Arrays.asList(12, 17, 87, 68, 34, 20);

         var avg = streamApi.getAverage(numbers);
         int[] intArray = numbers.stream()
         .mapToInt(Integer::intValue)
         .sorted()
         .toArray();
         System.out.println(PlayWithNumber.isNumberInTable(intArray, 100));
         System.out.println(PlayWithNumber.theLittleAbsoluteValue(intArray));
         System.out.println(avg);
         Integer a = 4;
         Integer b = 4;
         logger.info(String.valueOf(a.equals(b)));
         logger.info(new PlayWithNumber().encodePlainText("aabbaac"));
    }
}
