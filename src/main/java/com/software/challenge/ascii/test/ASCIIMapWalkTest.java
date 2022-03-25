package com.software.challenge.ascii.test;

import com.software.challenge.ascii.model.ASCIIMapWalkResult;

public class ASCIIMapWalkTest {
    private ASCIIMapWalkResult asciiMapWalkAlgorithmResult = null;
    private ASCIIMapWalkResult asciiMapWalkLoadedResult = null;


    public ASCIIMapWalkTest(ASCIIMapWalkResult asciiMapWalkAlgorithmResult, ASCIIMapWalkResult asciiMapWalkLoadedResult) {
        this.asciiMapWalkAlgorithmResult = asciiMapWalkAlgorithmResult;
        this.asciiMapWalkLoadedResult = asciiMapWalkLoadedResult;
    }

    public ASCIIMapWalkResult getAsciiMapWalkAlgorithmResult() {
        return asciiMapWalkAlgorithmResult;
    }

    public void setAsciiMapWalkAlgorithmResult(ASCIIMapWalkResult asciiMapWalkAlgorithmResult) {
        this.asciiMapWalkAlgorithmResult = asciiMapWalkAlgorithmResult;
    }

    public ASCIIMapWalkResult getAsciiMapWalkLoadedResult() {
        return asciiMapWalkLoadedResult;
    }

    public void setAsciiMapWalkLoadedResult(ASCIIMapWalkResult asciiMapWalkLoadedResult) {
        this.asciiMapWalkLoadedResult = asciiMapWalkLoadedResult;
    }

    public boolean checkIsEquals() {

        if (asciiMapWalkAlgorithmResult != null && asciiMapWalkLoadedResult != null)
            if (asciiMapWalkAlgorithmResult.getAsciiPathWalkResult().equals(asciiMapWalkLoadedResult.getAsciiPathWalkResult()) && asciiMapWalkAlgorithmResult.getAsciiPathWalkLetters().equals(asciiMapWalkLoadedResult.getAsciiPathWalkLetters()))
                return true;

        return false;
    }
}
