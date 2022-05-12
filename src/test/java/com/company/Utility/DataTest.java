package com.company.Utility;

//Imports
import com.company.AccountManagers.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
This testing file tests the methods provided by the data class
*/

public class DataTest {
    @DisplayName("Testing getUser")
    @ParameterizedTest
    @ValueSource(strings = {"prooheckcp", "name"})
    void getUser(String username){
        Tuple<Boolean, User> response = Data.getUser(username);
        Boolean success = response.getValue1();
        User user = response.getValue2();

        if(success)
            Assertions.assertNotNull(user);
        else
            Assertions.assertNull(user);
    }

    @DisplayName("Testing createUser")
    @ParameterizedTest
    @CsvSource({ "gdshahdah,wrongPass", "gdsaga,password", "hdaha,32", "dgag,password" })
    void createUser(String username, String password){
        Data.createUser(username, password);

        Tuple<Boolean, User> response = Data.getUser(username);
        Assertions.assertEquals(response.getValue1(), true);
    }
}
