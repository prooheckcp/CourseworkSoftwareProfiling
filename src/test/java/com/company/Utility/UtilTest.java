package com.company.Utility;

//Imports
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
This testing file tests the methods provided by the util class
*/

public class UtilTest {

    /*
    @DisplayName("Testing user input")
    @Test
    void getLine(){
        String userInput = Util.getLine("Please write: abc");
        Assertions.assertEquals(userInput, "abc");
    }

    @DisplayName("Test warnings")
    @ParameterizedTest
    @ValueSource(strings = {"Warning 1", "Warning 2"})
    void testWarnings(String warningMessage){
        Util.warning(warningMessage);
    }
    */


    @DisplayName("Test response tuples")
    @Test
    void testTuples(){
        Tuple<Boolean, String> responseTuple = Util.responseTuple(false, "abc");
        Tuple<Boolean, String> responseTuple2 = Util.responseTuple(true);

        Assertions.assertEquals(responseTuple.getValue1(), false);
        Assertions.assertEquals(responseTuple.getValue2(), "abc");
        Assertions.assertEquals(responseTuple2.getValue1(), true);
        Assertions.assertEquals(responseTuple2.getValue2(), "");
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
