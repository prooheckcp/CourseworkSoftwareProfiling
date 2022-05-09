package com.company;

import com.company.Utiliity.TestingClass;
import com.company.Utiliity.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FunctionalTesting {

    @DisplayName("Testing functional method")
    @ParameterizedTest
    @ValueSource(chars = {'A', '2', '-'})
    public void testing(char letter){
        boolean isLetter = TestingClass.functionalTesting(letter);
        Util.print("" + letter + ":" + isLetter);
    }
}
