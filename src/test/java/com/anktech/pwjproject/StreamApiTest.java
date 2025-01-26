package com.anktech.pwjproject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class StreamApiTest {

    private StreamApi streamApi;

    @BeforeEach
    public void setUp() {
        streamApi = new StreamApi();
    }

    @Test
    public void testGetAverageMethod() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        var result = streamApi.getAverage(numbers);

        Assertions.assertEquals(3.0, result);
    }

    @Test
    public void testThatCaseMethodWillReturnTheSameData() {
        // given
        List<String> data = Arrays.asList("hello", "world", "java");

        var result = streamApi.cases(data, "null");
        Assertions.assertEquals(data, result);
    }

    @Test
    public void testGetAverageMethodWithEmptyList() {
        // given
        List<Integer> emptyList = Collections.emptyList();

        var result = streamApi.getAverage(emptyList);

        Assertions.assertEquals(0.0, result);
    }

}
