package com.software.challenge.ascii.validation;

public class ASCIIMapPositionValidate {

    private int x;
    private int y;
    private int count;

    public ASCIIMapPositionValidate(){
        this.x = 0;
        this.y = 0;
        this.count = 0;
    }

    public ASCIIMapPositionValidate(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
