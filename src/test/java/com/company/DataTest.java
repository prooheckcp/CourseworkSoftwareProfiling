package com.company;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
This testing file tests the methods provided
by the "pseudo-database"
*/

public class DataTest {
    @DisplayName("Get random users")
    @ParameterizedTest
    @ValueSource(strings = {"prooheckcp", "tom", "proohec", "anotherUser"})
    void getUser(String username){
        Tuple<Boolean, User> result = Data.getUser(username);
        if(result.getValue1()){
            Util.print("Found user!");
            Assertions.assertNotNull(result.getValue2());
        }
        else {
            Util.print("Did not find user!");
            Assertions.assertNull(result.getValue2());
        }
    }
}
