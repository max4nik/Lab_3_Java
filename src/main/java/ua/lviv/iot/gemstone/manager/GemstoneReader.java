package ua.lviv.iot.gemstone.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GemstoneReader {
    public StringBuilder readFromFile(String fileName) throws IOException {
        String currentLine;
        StringBuilder output = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((currentLine = bufferedReader.readLine()) != null) {
                output.append(currentLine);
            }
        }
        return output;
    }
}
