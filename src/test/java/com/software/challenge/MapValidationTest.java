package com.software.challenge;

import com.software.challenge.ascii.algorithm.ASCIIMapAlgorithm;
import com.software.challenge.ascii.loader.ASCIIMapLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class MapValidationTest {

    //Load first Map for test
    @Test
    void validASCIIMap() throws FileNotFoundException {
        ASCIIMapAlgorithm asciiMapAlgorithm = new ASCIIMapAlgorithm(new ASCIIMapLoader("inputs/test-map-1.txt").getChar2DArray());
        Assertions.assertNotNull(asciiMapAlgorithm.asciiMapPathWalk());
    }

}
