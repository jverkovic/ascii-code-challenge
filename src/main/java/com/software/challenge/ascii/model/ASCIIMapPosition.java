package com.software.challenge.ascii.model;

import com.software.challenge.ascii.enums.DIRECTIONS;

public class ASCIIMapPosition {
    private int x;
    private int y;
    private Boolean isBrokenPath = false;
    private DIRECTIONS direction;

    public ASCIIMapPosition(int x, int y, DIRECTIONS direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public ASCIIMapPosition() {
        this.x = 0;
        this.y = 0;
        this.direction = DIRECTIONS.UNDEFINED;
    }

    public DIRECTIONS getDirection() {
        return direction;
    }

    public void setDirection(DIRECTIONS direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Boolean getBrokenPath() {
        return isBrokenPath;
    }

    public void setBrokenPath(Boolean brokenPath) {
        isBrokenPath = brokenPath;
    }

    public static class ASCIIMapWalkResult {

        private String asciiMapPath;
        private String asciiMapPathLetter;

        public String getAsciiMapPath() {
            return asciiMapPath;
        }

        public void setAsciiMapPath(String asciiMapPath) {
            this.asciiMapPath = asciiMapPath;
        }

        public String getAsciiMapPathLetter() {
            return asciiMapPathLetter;
        }

        public void setAsciiMapPathLetter(String asciiMapPathLetter) {
            this.asciiMapPathLetter = asciiMapPathLetter;
        }
    }
}
