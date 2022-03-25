package com.software.challenge;

import com.software.challenge.ascii.algorithm.ASCIIMapAlgorithm;
import com.software.challenge.ascii.loader.ASCIIMapLoader;
import com.software.challenge.ascii.loader.ASCIIMapResultLoader;
import com.software.challenge.ascii.model.ASCIIMapWalkResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class AlgorithmTest {

    @Test
    void validMapPath() throws FileNotFoundException {
        ASCIIMapLoader asciiMap2DCharLoader = new ASCIIMapLoader("inputs/test-map-1.txt");
        ASCIIMapAlgorithm asciiMapAlgorithm = new ASCIIMapAlgorithm(asciiMap2DCharLoader.getChar2DArray());
        ASCIIMapWalkResult asciiMapWalkResult = asciiMapAlgorithm.asciiMapPathWalk();

        Assertions.assertNotNull(asciiMapWalkResult);
    }

    //Test isEquals for pair file
    @Test
    void validMapPathAndLetterResult() throws FileNotFoundException {
        ASCIIMapLoader asciiMap2DCharLoader = new ASCIIMapLoader("inputs/test-map-1.txt");
        ASCIIMapAlgorithm asciiMapAlgorithm = new ASCIIMapAlgorithm(asciiMap2DCharLoader.getChar2DArray());
        ASCIIMapWalkResult asciiMapWalkResult = asciiMapAlgorithm.asciiMapPathWalk();

        ASCIIMapResultLoader asciiMapResultLoader = new ASCIIMapResultLoader("inputs/test-map-1-result.txt");
        ASCIIMapWalkResult asciiMapCheckResult = asciiMapResultLoader.loadASCIIMapResult();

        Assertions.assertEquals(asciiMapWalkResult.getAsciiPathWalkResult(), asciiMapCheckResult.getAsciiPathWalkResult());
        Assertions.assertEquals(asciiMapWalkResult.getAsciiPathWalkLetters(), asciiMapCheckResult.getAsciiPathWalkLetters());
    }

    @Test
    void validMapPathResult() throws FileNotFoundException {
        ASCIIMapLoader asciiMap2DCharLoader = new ASCIIMapLoader("inputs/test-map-1.txt");
        ASCIIMapAlgorithm asciiMapAlgorithm = new ASCIIMapAlgorithm(asciiMap2DCharLoader.getChar2DArray());
        ASCIIMapWalkResult asciiMapWalkResult = asciiMapAlgorithm.asciiMapPathWalk();

        ASCIIMapResultLoader asciiMapResultLoader = new ASCIIMapResultLoader("inputs/test-map-1-result.txt");
        ASCIIMapWalkResult asciiMapCheckResult = asciiMapResultLoader.loadASCIIMapResult();

        Assertions.assertEquals(asciiMapWalkResult.getAsciiPathWalkResult(), asciiMapCheckResult.getAsciiPathWalkResult());

    }

    @Test
    void validMapLetterResult() throws FileNotFoundException {
        ASCIIMapLoader asciiMap2DCharLoader = new ASCIIMapLoader("inputs/test-map-1.txt");
        ASCIIMapAlgorithm asciiMapAlgorithm = new ASCIIMapAlgorithm(asciiMap2DCharLoader.getChar2DArray());
        ASCIIMapWalkResult asciiMapWalkResult = asciiMapAlgorithm.asciiMapPathWalk();

        ASCIIMapResultLoader asciiMapResultLoader = new ASCIIMapResultLoader("inputs/test-map-1-result.txt");
        ASCIIMapWalkResult asciiMapCheckResult = asciiMapResultLoader.loadASCIIMapResult();

        Assertions.assertEquals(asciiMapWalkResult.getAsciiPathWalkLetters(), asciiMapCheckResult.getAsciiPathWalkLetters());

    }

    @Test
    void validMapBrokenPath() throws FileNotFoundException {
        ASCIIMapLoader asciiMap2DCharLoader = new ASCIIMapLoader("inputs/test-map-6-inv.txt");
        ASCIIMapAlgorithm asciiMapAlgorithm = new ASCIIMapAlgorithm(asciiMap2DCharLoader.getChar2DArray());
        ASCIIMapWalkResult asciiMapWalkResult = asciiMapAlgorithm.asciiMapPathWalk();

        Assertions.assertNull(asciiMapWalkResult);
    }
}
