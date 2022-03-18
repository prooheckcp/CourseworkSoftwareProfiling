package com.company;

/*
Simple Enum to resemble 4 different states of authentication.
None and Password are essentially the same state however as the Password one
is being used by default by the system.
*/

public enum AuthenticationMethod {
    NONE,
    PASSWORD,
    TWO_FACTOR,
    EMAIL
}
