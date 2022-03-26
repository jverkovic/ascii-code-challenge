package com.software.challenge;

import com.software.challenge.ascii.algorithm.ASCIIMapAlgorithm;
import com.software.challenge.ascii.loader.ASCIIMapLoader;
import com.software.challenge.ascii.loader.ASCIIMapResultLoader;
import com.software.challenge.ascii.model.ASCIIMapWalkResult;
import com.software.challenge.ascii.test.ASCIIMapWalkTest;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        if (args.length >= 2) {

            for (int i = 0; i < args.length; i += 2) {

                ASCIIMapLoader asciiMap2DCharLoader = new ASCIIMapLoader(args[i]);
                ASCIIMapResultLoader asciiMapResultLoader = new ASCIIMapResultLoader(args[i + 1]);
                ASCIIMapWalkResult asciiMapCheckResult = asciiMapResultLoader.loadASCIIMapResult();

                System.out.println("----------------------------------------------\nFILE: " + args[i]);

                if (asciiMap2DCharLoader.printASCIIMapAsChar2D() != null)
                    System.out.println(asciiMap2DCharLoader.printASCIIMapAsChar2D());

                boolean error = Boolean.TRUE;

                if (asciiMap2DCharLoader.getChar2DArray() != null) {

                    ASCIIMapAlgorithm asciiMapAlgorithm = new ASCIIMapAlgorithm(asciiMap2DCharLoader.getChar2DArray());
                    ASCIIMapWalkResult asciiMapWalkResult = asciiMapAlgorithm.asciiMapPathWalk();

                    if (asciiMapWalkResult != null && asciiMapCheckResult != null) {
                        error = Boolean.FALSE;

                        ASCIIMapWalkTest asciiMapWalkTest = new ASCIIMapWalkTest(asciiMapWalkResult, asciiMapCheckResult);

                        System.out.println("LETTER: " + asciiMapWalkResult.getAsciiPathWalkLetters());
                        System.out.println("PATH: " + asciiMapWalkResult.getAsciiPathWalkResult());

                        System.out.println("COMPARED: " + asciiMapWalkTest.checkIsEquals());
                    }
                }
                if (error) System.out.println("Error");
            }
        } else System.out.println("Invalid arguments");

    }

}





