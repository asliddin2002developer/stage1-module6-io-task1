package com.epam.mjc.io;

import java.io.File;
import java.io.IOException;



public class FileReader {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        File file = new File("src/main/resources/Profile.txt");
        fileReader.getDataFromFile(file);

    }

    public Profile getDataFromFile(File file) {
        StringBuilder s = new StringBuilder();
        try (java.io.FileReader inputStream = new java.io.FileReader(file.getPath());) {
            int c;
            while ((c = inputStream.read()) != -1){
                s.append(Character.toString((char)c));
            }
        } catch (IOException e) {
            System.err.print(e.toString());;
        }
        String stringContentOfFile = s.toString();

        String[] cleanedData = new String[4];
        String[] keyVals = stringContentOfFile.split("\n");
        for (int i = 0; i < keyVals.length; i++) {
            String[] parts = keyVals[i].split(":", 2);
            cleanedData[i] = parts[1].trim();
        }
        return new Profile(
                cleanedData[0],
                Integer.valueOf(cleanedData[1]),
                cleanedData[2],
                Long.parseLong(cleanedData[3])
        );
    }
}
