package com.software.challenge.ascii.algorithm;

import com.software.challenge.ascii.constants.CONSTANTS;
import com.software.challenge.ascii.enums.DIRECTIONS;
import com.software.challenge.ascii.model.ASCIIMapPosition;
import com.software.challenge.ascii.model.ASCIIMapWalkResult;
import com.software.challenge.ascii.model.ChoichesResultMatrix;
import com.software.challenge.ascii.validation.ASCIIMapValidator;

import java.util.HashMap;
import java.util.Map;

public class ASCIIMapAlgorithm {

    private char[][] asciiChar2DMap = null;

    public ASCIIMapAlgorithm(char[][] asciiChar2DMap) {
        this.asciiChar2DMap = asciiChar2DMap;
    }

    public ASCIIMapWalkResult asciiMapPathWalk() {

        ASCIIMapValidator asciiMapValidator = new ASCIIMapValidator(asciiChar2DMap);
        if (asciiMapValidator.validateASCIIMapPath()) {
            ASCIIMapWalkResult asciiMapWalkResult = new ASCIIMapWalkResult();

            int x = asciiMapValidator.getStartPosition().getX();
            int y = asciiMapValidator.getStartPosition().getY();

            int prevX = x;
            int prevY = y;

            boolean isBrokenPath = false;
            Map<String, Boolean> isCheckedPosition = new HashMap<String, Boolean>();

            char currentChar = asciiChar2DMap[x][y];
            char previousChar = currentChar;

            StringBuffer resultChars = new StringBuffer();
            StringBuffer resultCharsPath = new StringBuffer();

            resultCharsPath = resultCharsPath.append(CONSTANTS.START);

            DIRECTIONS direction;

            while (!isBrokenPath && currentChar != CONSTANTS.END) {
                previousChar = asciiChar2DMap[prevX][prevY];

                direction = getDirection(x, y, prevX, prevY);

                isCheckedPosition.put(x + String.valueOf(y), Boolean.TRUE);

                ChoichesResultMatrix possibleMoves = checkPossibleMoves(x, y, prevX, prevY);
                int numOfChoice = possibleMoves.getNumOfChoices();
                Map<DIRECTIONS, Boolean> choiceMatrixPosition = possibleMoves.getCheckChoicesMatrix();

                ASCIIMapPosition nextMapPosition;

                if (currentChar == CONSTANTS.HORIZONTAL || currentChar == CONSTANTS.VERTICAL)
                    nextMapPosition = getNextPositionOnSameDirection(x, y, possibleMoves, direction);
                else if (currentChar == CONSTANTS.TURN)
                    nextMapPosition = getNextPositionOnOppositeDirection(x, y, possibleMoves, direction);
                else if (currentChar == CONSTANTS.START)
                    nextMapPosition = getFirstPositionOnNoDirection(x, y, possibleMoves, direction);
                else nextMapPosition = getNextPositionOnNoDirection(x, y, possibleMoves, direction);

                if (nextMapPosition != null && nextMapPosition.getBrokenPath()) return null;

                prevX = x;
                prevY = y;
                x = nextMapPosition.getX();
                y = nextMapPosition.getY();

                currentChar = asciiChar2DMap[x][y];

                if (checkIsSupportedLetter(currentChar) && !isCheckedPosition.getOrDefault(String.valueOf(x) + String.valueOf(y), false))
                    resultChars = resultChars.append(currentChar);
                resultCharsPath = resultCharsPath.append(currentChar);
            }

            asciiMapWalkResult.setAsciiPathWalkResult(resultCharsPath.toString());
            asciiMapWalkResult.setAsciiPathWalkLetters(resultChars.toString());

            return asciiMapWalkResult;
        } else {
            return null;
        }
    }

    public boolean checkIsSupportedLetter(Character letter) {

        if (Character.isLetter(letter) && letter >= CONSTANTS.FIRTS_OK_LETTER && letter <= CONSTANTS.LAST_OK_LETTER)
            return true;
        else return false;
    }

    public ASCIIMapPosition getNextPositionOnSameDirection(int curX, int curY, ChoichesResultMatrix choichesResultMatrix, DIRECTIONS direction) {
        int nextX = curX;
        int nextY = curY;

        Map<DIRECTIONS, Boolean> choiceMatrixPosition = choichesResultMatrix.getCheckChoicesMatrix();

        ASCIIMapPosition nextChoicePosition = new ASCIIMapPosition();

        if (choiceMatrixPosition.getOrDefault(DIRECTIONS.LEFT, false) && direction == DIRECTIONS.LEFT) {
            nextY--;
            nextChoicePosition.setDirection(DIRECTIONS.LEFT);
        } else if (choiceMatrixPosition.getOrDefault(DIRECTIONS.RIGHT, false) && direction == DIRECTIONS.RIGHT) {
            nextY++;
            nextChoicePosition.setDirection(DIRECTIONS.RIGHT);
        } else if (choiceMatrixPosition.getOrDefault(DIRECTIONS.UP, false) && direction == DIRECTIONS.UP) {
            nextX--;
            nextChoicePosition.setDirection(DIRECTIONS.UP);
        } else if (choiceMatrixPosition.getOrDefault(DIRECTIONS.DOWN, false) && direction == DIRECTIONS.DOWN) {
            nextX++;
            nextChoicePosition.setDirection(DIRECTIONS.DOWN);
        } else {
            nextChoicePosition.setDirection(DIRECTIONS.UNDEFINED);
            nextChoicePosition.setBrokenPath(Boolean.TRUE);
            return nextChoicePosition;
        }

        nextChoicePosition.setX(nextX);
        nextChoicePosition.setY(nextY);

        return nextChoicePosition;
    }

    public ASCIIMapPosition getNextPositionOnOppositeDirection(int curX, int curY, ChoichesResultMatrix choichesResultMatrix, DIRECTIONS direction) {
        int nextX = curX;
        int nextY = curY;

        Map<DIRECTIONS, Boolean> choiceMatrixPosition = choichesResultMatrix.getCheckChoicesMatrix();

        ASCIIMapPosition nextChoicePosition = new ASCIIMapPosition();

        if (choiceMatrixPosition.getOrDefault(DIRECTIONS.LEFT, false) && (direction == DIRECTIONS.UP || direction == DIRECTIONS.DOWN)) {
            nextY--;
            nextChoicePosition.setDirection(DIRECTIONS.LEFT);
        } else if (choiceMatrixPosition.getOrDefault(DIRECTIONS.RIGHT, false) && (direction == DIRECTIONS.UP || direction == DIRECTIONS.DOWN)) {
            nextY++;
            nextChoicePosition.setDirection(DIRECTIONS.RIGHT);
        } else if (choiceMatrixPosition.getOrDefault(DIRECTIONS.UP, false) && (direction == DIRECTIONS.LEFT || direction == DIRECTIONS.RIGHT)) {
            nextX--;
            nextChoicePosition.setDirection(DIRECTIONS.UP);
        } else if (choiceMatrixPosition.getOrDefault(DIRECTIONS.DOWN, false) && (direction == DIRECTIONS.LEFT || direction == DIRECTIONS.RIGHT)) {
            nextX++;
            nextChoicePosition.setDirection(DIRECTIONS.DOWN);
        } else {
            nextChoicePosition.setDirection(DIRECTIONS.UNDEFINED);
            nextChoicePosition.setBrokenPath(Boolean.TRUE);
            return nextChoicePosition;
        }

        nextChoicePosition.setX(nextX);
        nextChoicePosition.setY(nextY);

        return nextChoicePosition;
    }

    // Can go in every direction, but have to keep direction if is possible
    public ASCIIMapPosition getNextPositionOnNoDirection(int curX, int curY, ChoichesResultMatrix choichesResultMatrix, DIRECTIONS direction) {
        int nextX = curX;
        int nextY = curY;
        boolean isBrokenPath = false;

        Map<DIRECTIONS, Boolean> choiceMatrixPosition = choichesResultMatrix.getCheckChoicesMatrix();

        ASCIIMapPosition nextChoicePosition = new ASCIIMapPosition();

        if (direction == DIRECTIONS.LEFT || direction == DIRECTIONS.RIGHT) {
            if (choiceMatrixPosition.getOrDefault(DIRECTIONS.LEFT, false)) {
                nextY--;
                nextChoicePosition.setDirection(DIRECTIONS.LEFT);
            } else if (choiceMatrixPosition.getOrDefault(DIRECTIONS.RIGHT, false)) {
                nextY++;
                nextChoicePosition.setDirection(DIRECTIONS.RIGHT);
            } else if (choiceMatrixPosition.getOrDefault(DIRECTIONS.UP, false)) {
                nextX--;
                nextChoicePosition.setDirection(DIRECTIONS.UP);
            } else {
                nextX++;
                nextChoicePosition.setDirection(DIRECTIONS.DOWN);
            }
        } else if ((direction == DIRECTIONS.UP || direction == DIRECTIONS.DOWN)) {
            if (choiceMatrixPosition.getOrDefault(DIRECTIONS.UP, false)) {
                nextX--;
                nextChoicePosition.setDirection(DIRECTIONS.UP);
            } else if (choiceMatrixPosition.getOrDefault(DIRECTIONS.DOWN, false)) {
                nextX++;
                nextChoicePosition.setDirection(DIRECTIONS.DOWN);
            } else if (choiceMatrixPosition.getOrDefault(DIRECTIONS.LEFT, false)) {
                nextY--;
                nextChoicePosition.setDirection(DIRECTIONS.LEFT);
            } else {
                nextY++;
                nextChoicePosition.setDirection(DIRECTIONS.RIGHT);
            }
        } else {
            nextChoicePosition.setDirection(DIRECTIONS.UNDEFINED);
            nextChoicePosition.setBrokenPath(Boolean.TRUE);
            return nextChoicePosition;
        }

        nextChoicePosition.setX(nextX);
        nextChoicePosition.setY(nextY);
        return nextChoicePosition;
    }

    public ASCIIMapPosition getFirstPositionOnNoDirection(int curX, int curY, ChoichesResultMatrix choichesResultMatrix, DIRECTIONS direction) {
        int nextX = curX;
        int nextY = curY;
        boolean isBrokenPath = false;

        Map<DIRECTIONS, Boolean> choiceMatrixPosition = choichesResultMatrix.getCheckChoicesMatrix();

        ASCIIMapPosition nextChoicePosition = new ASCIIMapPosition();

        //First direction is always DIRECTION.UNDEFINED, just one choice to decide, otherwise error
        if (direction == DIRECTIONS.UNDEFINED && choichesResultMatrix.getNumOfChoices() == 1) {
            if (choiceMatrixPosition.getOrDefault(DIRECTIONS.LEFT, false)) {
                nextY--;
                nextChoicePosition.setDirection(DIRECTIONS.LEFT);
            } else if (choiceMatrixPosition.getOrDefault(DIRECTIONS.RIGHT, false)) {
                nextY++;
                nextChoicePosition.setDirection(DIRECTIONS.RIGHT);
            } else if (choiceMatrixPosition.getOrDefault(DIRECTIONS.UP, false)) {
                nextX--;
                nextChoicePosition.setDirection(DIRECTIONS.UP);
            } else {
                nextX++;
                nextChoicePosition.setDirection(DIRECTIONS.DOWN);
            }
        } else {
            nextChoicePosition.setBrokenPath(Boolean.TRUE);
            return nextChoicePosition;
        }

        nextChoicePosition.setX(nextX);
        nextChoicePosition.setY(nextY);
        return nextChoicePosition;
    }

    public DIRECTIONS getDirection(int x, int y, int prevX, int prevY) {

        DIRECTIONS direction = DIRECTIONS.UNDEFINED;

        if (prevX == x && prevY != y) {
            if (prevY < y) direction = DIRECTIONS.RIGHT;
            else direction = DIRECTIONS.LEFT;
        } else if (prevX != x && prevY == y) {
            if (prevX < x) direction = DIRECTIONS.DOWN;
            else direction = DIRECTIONS.UP;
        }

        return direction;
    }


    public boolean isInRangeOfMap(int x, int y) {
        if ((x >= 0 && x < asciiChar2DMap.length) && (y >= 0 && y < asciiChar2DMap[x].length)) return true;
        else return false;
    }


    public boolean moveLeft(int currentX, int currentY, int previousX, int previousY) {
        if (isInRangeOfMap(currentX, currentY - 1) && asciiChar2DMap[currentX][currentY - 1] != ' ' && ((previousX != currentX) || (previousY != currentY - 1)))
            return true;
        else return false;
    }

    public boolean moveRight(int currentX, int currentY, int previousX, int previousY) {
        if (isInRangeOfMap(currentX, currentY + 1) && asciiChar2DMap[currentX][currentY + 1] != ' ' && ((previousX != (currentX)) || (previousY != (currentY + 1))))
            return true;
        else return false;
    }

    public boolean moveUp(int currentX, int currentY, int previousX, int previousY) {
        if (isInRangeOfMap(currentX - 1, currentY) && asciiChar2DMap[currentX - 1][currentY] != ' ' && ((previousX != (currentX - 1)) || (previousY != currentY)))
            return true;
        else return false;
    }

    public boolean moveDown(int currentX, int currentY, int previousX, int previousY) {
        if (isInRangeOfMap(currentX + 1, currentY) && asciiChar2DMap[currentX + 1][currentY] != ' ' && ((previousX != (currentX + 1)) || (previousY != currentY)))
            return true;
        else return false;
    }


    public ChoichesResultMatrix checkPossibleMoves(int currentX, int currentY, int previousX, int previousY) {
        Map<DIRECTIONS, Boolean> checkOptionsMatrix = new HashMap<>();
        int numOfPossibleChoices = 0;

        if (moveLeft(currentX, currentY, previousX, previousY) == true) {
            checkOptionsMatrix.put(DIRECTIONS.LEFT, true);
            numOfPossibleChoices++;
        }
        if (moveRight(currentX, currentY, previousX, previousY)) {
            checkOptionsMatrix.put(DIRECTIONS.RIGHT, true);
            numOfPossibleChoices++;
        }
        if (moveUp(currentX, currentY, previousX, previousY)) {
            checkOptionsMatrix.put(DIRECTIONS.UP, true);
            numOfPossibleChoices++;
        }
        if (moveDown(currentX, currentY, previousX, previousY)) {
            checkOptionsMatrix.put(DIRECTIONS.DOWN, true);
            numOfPossibleChoices++;
        }

        ChoichesResultMatrix choichesResultMatrix = new ChoichesResultMatrix();
        choichesResultMatrix.setCheckChoicesMatrix(checkOptionsMatrix);
        choichesResultMatrix.setNumOfChoices(numOfPossibleChoices);

        return choichesResultMatrix;
    }

}
