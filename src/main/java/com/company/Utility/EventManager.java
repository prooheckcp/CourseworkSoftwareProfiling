package com.company.Utility;

//Imports
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/*
Simple class to implement custom events with the observer pattern

    Public Static Methods:
        addListener
            Description:
                Adds a callback correlated to a given String

            Arguments:
                name : String -> The name of the event that you wish to subscribe to
                event : Event -> The callback method

        fireEvent
            Description:
                Triggers all the callbacks with the given name

            Arguments:
                name : String -> The name of the event that you wish to create
*/

public class EventManager<CustomType> {
    private static Map<String, Vector<Event>> listenerList = new HashMap<>();

    public static void addListener(String name, Event event){
        if(!listenerList.containsKey(name))
            listenerList.put(name, new Vector<Event>());

        Vector<Event> listenersList = listenerList.get(name);
        listenersList.add(event);
    }

    public static void fireEvent(String name){
        if(!listenerList.containsKey(name)){
            return;
        }

        Vector<Event> listenersList = listenerList.get(name);
        for(int i = 0; i < listenersList.size(); i++){
            Event event = listenersList.get(i);
            event.action();
        }
    }
}
