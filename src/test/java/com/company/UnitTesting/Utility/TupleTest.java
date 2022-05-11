package com.company.UnitTesting.Utility;

//Imports
import com.company.Utiliity.Tuple;
import org.junit.jupiter.api.*;

public class TupleTest {
    @DisplayName("Testing user input")
    @Test
    void testTuples(){
        Tuple<Boolean, Boolean> a = new Tuple<>(true, false);
        Tuple<String, Integer> b = new Tuple<>("hello", 3);
        Tuple<Float, Character> c = new Tuple<>(2.3f, 'b');

        Assertions.assertEquals(a.getValue1(), true);
        Assertions.assertEquals(a.getValue2(), false);

        Assertions.assertEquals(b.getValue1(), "hello");
        Assertions.assertEquals(b.getValue2(), 3);

        Assertions.assertEquals(c.getValue1(), 2.3f);
        Assertions.assertEquals(c.getValue2(), 'b');
    }
}
