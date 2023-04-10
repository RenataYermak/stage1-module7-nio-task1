package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            String line;
            while ((line = reader.readLine()) != null) {
                String key = line.split(" ")[0];
                String value = line.split(" ")[1];
                switch (key) {
                    case "Name:":
                        profile.setName(value);
                        break;
                    case "Age:":
                        profile.setAge(Integer.parseInt(value));
                        break;
                    case "Email:":
                        profile.setEmail(value);
                        break;
                    case "Phone:":
                        profile.setPhone(Long.parseLong(value));
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return profile;
    }
}
