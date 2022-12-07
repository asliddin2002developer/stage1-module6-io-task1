package com.epam.mjc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


public class FileReader {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        File file = new File("src/main/resources/Profile.txt");
        fileReader.getDataFromFile(file);

    }

    public Profile getDataFromFile(File file) {
        String s = "";
        try (java.io.FileReader inputStream = new java.io.FileReader(file.getPath());) {
            int c;
            while ((c = inputStream.read()) != -1){
                s += (char) c;
//                System.out.println(c);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] cleanedData = new String[4];
        String[] keyVals = s.split("\n");
        for (int i = 0; i < keyVals.length; i++) {
            String[] parts = keyVals[i].split(":", 2);
            cleanedData[i] = parts[1].trim();
        }
        Profile profile = new Profile(
                cleanedData[0],
                Integer.valueOf(cleanedData[1]),
                cleanedData[2],
                Long.parseLong(cleanedData[3])
        );
//        System.out.println(profile);
        return profile;
    }
}
