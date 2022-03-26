package com.software.challenge.ascii.loader;

import com.software.challenge.ascii.model.ASCIIMapWalkResult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ASCIIMapResultLoader {
    private String mapResultName;
    private ASCIIMapWalkResult asciiMapWalkResult;
    private Boolean isLoaded = false;

    public String getMapResultName() {
        return mapResultName;
    }

    public void setMapResultName(String mapResultName) {
        this.mapResultName = mapResultName;
    }

    public ASCIIMapWalkResult getAsciiMapWalkResult() {
        return asciiMapWalkResult;
    }

    public void setAsciiMapWalkResult(ASCIIMapWalkResult asciiMapWalkResult) {
        this.asciiMapWalkResult = asciiMapWalkResult;
    }

    public Boolean getLoaded() {
        return isLoaded;
    }

    public void setLoaded(Boolean loaded) {
        isLoaded = loaded;
    }

    public ASCIIMapResultLoader(String mapResultName) {
        this.mapResultName = mapResultName;
    }

    public ASCIIMapWalkResult loadASCIIMapResult() {
        ArrayList<String> arrayListResult = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(mapResultName));
            String mapData;
            while ((mapData = bufferedReader.readLine()) != null) {
                arrayListResult.add(mapData);
            }
            bufferedReader.close();


            if (arrayListResult.size() == 2) {
                setLoaded(true);
                return new ASCIIMapWalkResult(arrayListResult.get(0), arrayListResult.get(1));
            } else {
                return null;
            }

        } catch (IOException ioE) {
            ioE.printStackTrace();
            return null;
        }
    }
}
