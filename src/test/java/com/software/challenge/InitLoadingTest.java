package com.software.challenge;

import com.software.challenge.ascii.loader.ASCIIMapLoader;
import com.software.challenge.ascii.loader.ASCIIMapResultLoader;
import com.software.challenge.ascii.model.ASCIIMapWalkResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class InitLoadingTest {

    @Test
    void shouldInitLoaderOnASCIIMapCorrect() throws FileNotFoundException {
        ASCIIMapLoader asciiMapLoader = new ASCIIMapLoader("inputs/test-map-1.txt");
        Assertions.assertNotEquals(asciiMapLoader, null);
    }

    @Test
    void shouldInitResultLoader() throws FileNotFoundException {
        ASCIIMapLoader asciiMapLoader = new ASCIIMapLoader("inputs/test-map-1-result.txt");
        Assertions.assertNotEquals(asciiMapLoader, null);
    }

    @Test
    void shouldLoadASCIIMap() throws FileNotFoundException {
        Assertions.assertEquals(true, new ASCIIMapLoader("inputs/test-map-1.txt").isLoaded());
    }

    @Test
    void shouldLoadResult() throws FileNotFoundException {
        ASCIIMapResultLoader asciiMapResultLoader = new ASCIIMapResultLoader("inputs/test-map-1-result.txt");

        ASCIIMapWalkResult asciiMapCheckResult = asciiMapResultLoader.loadASCIIMapResult();
        Assertions.assertNotNull(asciiMapCheckResult);
    }
}


