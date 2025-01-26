package com.anktech.pwjproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayWithNumberTest {

    private PlayWithNumber playWithNumber;

    @BeforeEach
    private void setUp() {
        playWithNumber = new PlayWithNumber();
    }

    @Test
    private void shouldEncodePlainText() {
        String plainText = "aaabbfbaaac";
        String result = playWithNumber.encodePlainText(plainText);
        Assertions.assertEquals("6a3b1f1c", result);
    }
}