package com.software.challenge.ascii.model;

public class ASCIIMapWalkResult {
    private String asciiPathWalkLetters;
    private String asciiPathWalkResult;

    public ASCIIMapWalkResult() {
        this.asciiPathWalkLetters = null;
        this.asciiPathWalkResult = null;
    }

    public ASCIIMapWalkResult(String asciiPathWalkLetters, String asciiPathWalkResult) {
        this.asciiPathWalkLetters = asciiPathWalkLetters;
        this.asciiPathWalkResult = asciiPathWalkResult;
    }

    public String getAsciiPathWalkResult() {
        return asciiPathWalkResult;
    }

    public void setAsciiPathWalkResult(String asciiPathWalkResult) {
        this.asciiPathWalkResult = asciiPathWalkResult;
    }

    public String getAsciiPathWalkLetters() {
        return asciiPathWalkLetters;
    }

    public void setAsciiPathWalkLetters(String asciiPathWalkLetters) {
        this.asciiPathWalkLetters = asciiPathWalkLetters;
    }

    public void printASCIIMapAlgorithmResult() {
        if (asciiPathWalkResult != null && asciiPathWalkLetters != null) {
            System.out.println("LETTER: " + asciiPathWalkLetters);
            System.out.println("PATH: " + asciiPathWalkResult);
        }
    }
}
