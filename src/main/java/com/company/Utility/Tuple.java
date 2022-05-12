package com.company.Utility;

/*
Implements a simple 2 dimensional tuple

    Public methods
        getValue1
            Description:
                Gives you the first value of the tuple

            Returns:
                T -> Returns the first value of type T

        getValue2
            Description:
                Gives you the second value of the tuple

            Returns:
                T -> Returns the second value of type T
*/

public class Tuple<V1, V2> {
    private V1 first;
    private V2 second;

    public Tuple(V1 first, V2 second){
        this.first = first;
        this.second = second;
    }

    public V1 getValue1(){
        return first;
    }

    public V2 getValue2(){
        return second;
    }
}