package com.software.challenge.ascii.validation;

import com.software.challenge.ascii.constants.CONSTANTS;

import java.util.Map;

public class ASCIIMapValidator {

    private char[][] asciiMapChar2D;
    private Map<Character, Integer> charMapNumbers;
    private ASCIIMapPositionValidate startPosition;
    private ASCIIMapPositionValidate endPosition;

    public ASCIIMapValidator(char[][] asciiMapChar2D) {
        this.asciiMapChar2D = asciiMapChar2D;
        this.startPosition = new ASCIIMapPositionValidate(0, 0, 0);
        this.endPosition = new ASCIIMapPositionValidate(0, 0, 0);
    }

    public boolean validateASCIIMapPath() {

        for (int x = 0; x < asciiMapChar2D.length; x++) {
            for (int y = 0; y < asciiMapChar2D[x].length; y++) {
                if (asciiMapChar2D[x][y] == CONSTANTS.START) {
                    startPosition.setX(x);
                    startPosition.setY(y);
                    startPosition.setCount(startPosition.getCount() + 1);
                } else if (asciiMapChar2D[x][y] == CONSTANTS.END) {
                    endPosition.setX(x);
                    endPosition.setY(y);
                    endPosition.setCount(endPosition.getCount() + 1);
                }
            }
        }
        if (startPosition.getCount() > 1 || startPosition.getCount() == 0) return false;
        else if (endPosition.getCount() > 1 || endPosition.getCount() == 0) return false;
        else return true;
    }

    public ASCIIMapPositionValidate getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(ASCIIMapPositionValidate startPosition) {
        this.startPosition = startPosition;
    }

    public ASCIIMapPositionValidate getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(ASCIIMapPositionValidate endPosition) {
        this.endPosition = endPosition;
    }
}
