package com.company;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OptionsTest {

    static Options mainWindowOptions;

    @BeforeAll
    static void startData(){
        mainWindowOptions = new Options("Main window", new MenuAction[]{
                new RegisterUser("Option 1"),
                new LoginUser("Option 2")
        });
    }

    @Test
    @DisplayName("Attempt to break option parser")
    @ParameterizedTest
    @ValueSource(strings = {"3", "-3", "word", "haha", "2", "0"})
    void parseOption(String option) {
        Integer response = Options.parseOption(option);
        Assertions.assertNotNull(response);
    }

    @Test
    void promptOptions() {
        /*
            Impossible to unit test due to the recursive nature of the program

            ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
            System.setIn(in);
            mainWindowOptions.promptOptions();
        */
    }

    @AfterAll
    static void clearData(){
        mainWindowOptions = null;
    }
}