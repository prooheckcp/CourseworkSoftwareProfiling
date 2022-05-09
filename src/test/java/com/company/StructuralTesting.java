package com.company;

import com.company.Utiliity.TestingClass;
import com.company.Utiliity.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class StructuralTesting {
    public static int[][] dataSetForTesting() {
        return new int[][] {
                { 2, 3 },
                {-4, 2},
                {0, 0},
                {3, -2},
                {-2, 9},
                {-1, 4},
                {12, -3}
        };
    }

    //This CFG does not contain enough complexity for MC/DC
    //allowing us to easily test every path with the given dataset
    //Reaches every leaf of the whole tree
    @DisplayName("Testing structural method")
    @ParameterizedTest
    @MethodSource("dataSetForTesting")
    public void testing(int[] set){
        Util.print("Output: " + TestingClass.structuralTesting(set[0], set[1]));
    }
}
