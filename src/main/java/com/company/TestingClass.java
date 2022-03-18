package com.company;

public class TestingClass {
    /*
    @param x letter
    @return returns true if it is a letter between A and Z
    @throws NullPointerException if x is null
    */
    public static boolean functionalTesting(char letter){
        int asciiValue = (int)letter;
        return asciiValue > 64 && asciiValue < 91;
    }

    public static int structuralTesting(int x, int y){
        if(x < 0){
            if(x + y > 5)
                return 1;
            else if(x + y > 2)
                return 3;

            return 4;
        }else if(y < 0){
            if(x + y > 6)
                return 2;

            return 5;
        }

        if(x - y < 0)
            return -1;
        else
            return 0;
    }
}
