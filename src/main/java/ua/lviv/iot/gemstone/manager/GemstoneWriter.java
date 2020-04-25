package ua.lviv.iot.gemstone.manager;

import ua.lviv.iot.gemstone.model.Gemstone;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class GemstoneWriter {
    private Writer writer;

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public void writeToFile(List<Gemstone> gemstones, String fileName) {
        StringBuilder allHeaders = new StringBuilder();
        StringBuilder allCSV = new StringBuilder();
        gemstones.forEach(gemstone -> allHeaders.append(gemstone.getHeaders()).append("\n"));
        gemstones.forEach(gemstone -> allCSV.append(gemstone.toCSV()).append("\n"));
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            writeLine(this.writer, allHeaders);
            writeLine(this.writer, allCSV);
        } catch (IOException exception) {
            System.out.println("ERROR: " + exception);
        }
    }

    private void writeLine(Writer writer, StringBuilder text) throws IOException {
        writer.write(String.valueOf(text));
    }
}
