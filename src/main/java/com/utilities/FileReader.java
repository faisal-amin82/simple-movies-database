package com.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    public static byte[] readJsonFile(String path) throws IOException {

        return Files.readAllBytes(Paths.get(path));
    }

}
