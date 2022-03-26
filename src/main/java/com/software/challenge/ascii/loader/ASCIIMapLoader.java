package com.software.challenge.ascii.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ASCIIMapLoader {
    private ArrayList array;
    private char[][] char2DArray = null;
    private String mapFileName;
    private boolean isLoaded;

    public ASCIIMapLoader(String mapFileName) {
        this.mapFileName = mapFileName;
        this.array = new ArrayList();
        this.isLoaded = loadASCIIMapAsChar2D();
    }

    public char[][] getChar2DArray() {
        return char2DArray;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean isLoaded) {
        this.isLoaded = isLoaded;
    }

    public boolean loadASCIIMapAsChar2D() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(mapFileName));
            String mapData;
            while ((mapData = bufferedReader.readLine()) != null) {
                array.add(mapData.toCharArray());
            }
            bufferedReader.close();
            //Creating a 2D char array base on the array size
            char2DArray = new char[array.size()][];

            //Convert array from ArrayList to 2D array
            for (int i = 0; i < array.size(); i++) {
                char2DArray[i] = (char[]) array.get(i);
            }

            return true;
        } catch (IOException | NullPointerException ioE) {
            //System.out.println("Error - opening map file.");
            //ioE.printStackTrace();
            return false;
        }
    }

    public void printASCIIMapAsChar2D() {
        if (this.isLoaded()) {
            System.out.println("----------------------------------------------\nFILE: " + mapFileName);
            for (int x = 0; x < char2DArray.length; x++) {
                char[] temp = char2DArray[x];

                for (int y = 0; y < temp.length; y++) {
                    System.out.print(temp[y]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Unloaded Map");
        }

        return;
    }

    public void setChar2DArray(char[][] char2DArray) {
        this.char2DArray = char2DArray;
    }

}
