package com.backend.filehandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by osama on 5/1/16.
 * To create, delete and auto save to file.
 */
public class FileHandler {

    String fileLocation;
    File file;
    FileWriter fw;
    BufferedWriter bw;


    public void createFile(String fileLocation) {
        file = new File(fileLocation);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean saveFile(String texts) {
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            return writeFile(texts);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean writeFile(String texts) {
        boolean status = false;
        try {
            bw.write(texts);
            bw.flush();
            status = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void cleanUp() {
        try {
            fw.close();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}