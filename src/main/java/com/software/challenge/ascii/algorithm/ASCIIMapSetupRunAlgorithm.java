package com.software.challenge.ascii.algorithm;

import com.software.challenge.ascii.loader.ASCIIMapLoader;

import java.io.FileNotFoundException;

public class ASCIIMapSetupRunAlgorithm {

    //Load and print if successfully
    //Run ASCIIMapPathWalkAlgorithm and print result
    public void run(String[] args) throws FileNotFoundException {
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                ASCIIMapLoader asciiMap2DCharLoader = new ASCIIMapLoader(args[i]);
                if (asciiMap2DCharLoader.isLoaded() && asciiMap2DCharLoader.getChar2DArray() != null) {
                    asciiMap2DCharLoader.printASCIIMapAsChar2D();
                    ASCIIMapAlgorithm asciiMapAlgorithm = new ASCIIMapAlgorithm(asciiMap2DCharLoader.getChar2DArray());
                    if (asciiMapAlgorithm.asciiMapPathWalk() != null)
                        asciiMapAlgorithm.asciiMapPathWalk().printASCIIMapAlgorithmResult();
                    else System.out.println("Error");
                }
            }
        } else {
            System.out.println("Expected arguments");
            return;
        }
    }

}
