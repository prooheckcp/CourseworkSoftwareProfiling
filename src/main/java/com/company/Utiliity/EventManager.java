package com.company.Utiliity;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/*
Simple class to implement custom events
*/

public class EventManager<CustomType> {
    public static Map<String, Vector<Event>> listenerList = new HashMap<>();

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
