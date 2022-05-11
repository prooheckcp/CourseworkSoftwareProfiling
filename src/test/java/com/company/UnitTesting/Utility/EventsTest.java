package com.company.UnitTesting.Utility;

//Imports
import com.company.Utiliity.Event;
import com.company.Utiliity.EventManager;
import org.junit.jupiter.api.*;

public class EventsTest {
    //Constants
    static private final String EVENT_ONE = "EventOne";
    static private final String Event_TWO = "EventTwo";

    static private Boolean listener1Called = false;
    static private Boolean listener2Called = false;

    @BeforeAll
    static void setData(){
        //Reset variables
        listener1Called = false;
        listener2Called = false;

        //Create some event listeners
        EventManager.addListener(EVENT_ONE, new Event(){
            @Override
            public void action() {
                listener1Called = true;
            }
        });

        EventManager.addListener(Event_TWO, new Event(){
            @Override
            public void action() {
                listener2Called = true;
            }
        });
    }

    @DisplayName("Testing events calls")
    @Test
    void testingEventCalls(){
        //Make sure listeners are false at the start
        Assertions.assertEquals(listener1Called, false);
        Assertions.assertEquals(listener2Called, false);

        EventManager.fireEvent(EVENT_ONE);
        EventManager.fireEvent(Event_TWO);

        //Check if the booleans have been modified
        Assertions.assertEquals(listener1Called, true);
        Assertions.assertEquals(listener2Called, true);
    }
}
