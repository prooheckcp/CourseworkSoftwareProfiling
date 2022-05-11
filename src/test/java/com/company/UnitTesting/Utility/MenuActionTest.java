package com.company.UnitTesting.Utility;

//Imports
import com.company.Utiliity.MenuAction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuActionTest {
    //Constants
    private static final String ACTION_NAME = "SomeName";

    //Variables
    private static Boolean toChange = false;

    @BeforeAll
    static void setData(){
        toChange = false;
    }

    @DisplayName("Testing menu action")
    @Test
    void menuActionTesting(){
        MenuAction newAction = new MenuAction(ACTION_NAME){
            @Override
            public void Main() {
                toChange = true;
            }
        };

        Assertions.assertEquals(newAction.actionName, ACTION_NAME);
        Assertions.assertEquals(toChange, false);
        newAction.Main();
        Assertions.assertEquals(toChange, true);
    }
}
