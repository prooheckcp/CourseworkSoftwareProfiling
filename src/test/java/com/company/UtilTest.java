package com.company;

import com.company.Utiliity.Util;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

/*
This testing file tests the methods provided by the util class
*/

public class UtilTest {

    @DisplayName("Testing user input")
    @ParameterizedTest
    @ValueSource(strings = {"word"})
    void getLine(String message){
        ByteArrayInputStream in = new ByteArrayInputStream(message.getBytes());
        System.setIn(in);
    }

    @DisplayName("Testing the printInLine")
    @ParameterizedTest
    @ValueSource(strings = {"Joining ", "some ", "words ", "together"})
    void printInLine(String word){
        Util.printInLine(word);
    }

    @DisplayName("Testing the print")
    @ParameterizedTest
    @ValueSource(strings = {"word", "anotherWord", "dog", "cat"})
    void print(String word){
        Util.print(word);
    }
}
