package com.anktech.pwjproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.anktech.pwjproject.PlayWithNumber;

class PlayWithNumberTest {

    private PlayWithNumber playWithNumber;

    @BeforeEach
    public void setUp() {
        playWithNumber = new PlayWithNumber();
    }

    @Test
    void shouldTestEncodePlainText() {
        String plainText = "aaabbfbaaac";
        String result = playWithNumber.encodePlainText(plainText);
        Assertions.assertEquals("6a3b1f1c", result);
    }

    @Test
    void shouldTestAddUpTo() {
        // given
        int[] numbers = { 10, 15, 3, 7 };
        int k1 = 17, k2 = 20;
        // Assertions
        Assertions.assertTrue(playWithNumber.addUpTo(numbers, k1));
        Assertions.assertFalse(playWithNumber.addUpTo(numbers, k2));
    }

    @Test
    void shouldTestProductOfAllExceptI() {
        // given
        int[] numbers = { 1, 2, 3, 4, 5 };
        int[] expected = { 120, 60, 40, 30, 24 };

        // Do
        int[] result = playWithNumber.productOfAllExceptI(numbers);

        // Assertions
        Assertions.assertArrayEquals(expected, result);
    }
    @Test
    void shouldFindTheLowestPositiveInteger() {
        // Given
        int[] numbers1 = { 3, 4, -1, 1 };
        int expected_1 = 2;
        int[] numbers2 = { 1, 2, 0 };
        int expected_2 = 3;

        // Do
        int result_1 = playWithNumber.findTheLowestPositiveInteger(numbers1);
        int result_2 = playWithNumber.findTheLowestPositiveInteger(numbers2);

        Assertions.assertEquals(expected_1, result_1);
        Assertions.assertEquals(expected_2, result_2);
    }

    @Test
    void shouldTestConstructionPairOfNumber() {
        //Given
        int a = 5, b = 6;
        String expected = "5,6";
        //Do
        String result = playWithNumber.cons(a,b);
        //Assertion
        Assertions.assertEquals(expected,result);
    }
    @Test
    void shouldTestIfThePairIsCorrect(){
        //Given
        String pair = ",90";

        //Do
        Exception exception = Assertions.assertThrows( IllegalArgumentException.class,()->playWithNumber.car(pair));
        String expectedMessage = "Pair Incorrect";
        Assertions.assertEquals(expectedMessage,exception.getMessage());
    }
    @Test
    void shouldTestCar(){
        //Given
        String pair = "5,6";
        int expected = 5;
        //Do
        int result = playWithNumber.car(pair);
        //Assertion
        Assertions.assertEquals(expected,result);
    }
    @Test
    void shouldTestCdr(){
        //Given
        String pair = "5,6";
        int expected = 6;
        //Do
        int result = playWithNumber.cdr(pair);
        //Assertion
        Assertions.assertEquals(expected,result);
    }
}