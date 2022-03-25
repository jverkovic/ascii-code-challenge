package com.software.challenge.ascii.model;

import com.software.challenge.ascii.enums.DIRECTIONS;

import java.util.Map;

public class ChoichesResultMatrix {
    private Map<DIRECTIONS, Boolean> checkChoicesMatrix;
    private int numOfChoices;

    public Map<DIRECTIONS, Boolean> getCheckChoicesMatrix() {
        return checkChoicesMatrix;
    }

    public void setCheckChoicesMatrix(Map<DIRECTIONS, Boolean> checkChoicesMatrix) {
        this.checkChoicesMatrix = checkChoicesMatrix;
    }

    public int getNumOfChoices() {
        return numOfChoices;
    }

    public void setNumOfChoices(int numOfChoices) {
        this.numOfChoices = numOfChoices;
    }
}
