package ua.lviv.iot.gemstone.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.gemstone.model.Gemstone;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GemstoneWriterPrinterTest extends BaseGemstoneInNecklaceTest {
    private GemstoneWriter gemstoneWriter;
    private GemstoneReader gemstoneReader;
    private static final String FILE = "Lab5.csv";

    @BeforeEach
    void setUp() {
        this.gemstoneWriter = new GemstoneWriter();
        this.gemstoneReader = new GemstoneReader();
    }


    @Test
    void testWriteToFileAndReadFromFile() throws IOException {
        List<Gemstone> gemstonesInFile = handmadeNecklace.getGemstonesInLace();
        try (Writer fileWriter = new FileWriter(FILE)) {
            this.gemstoneWriter.setWriter(fileWriter);
            this.gemstoneWriter.writeToFile(gemstonesInFile, FILE);
        }
        StringBuilder expectedOutput = new StringBuilder();
        gemstonesInFile.forEach((gemstone -> expectedOutput.append(gemstone.getHeaders())));
        gemstonesInFile.forEach((gemstone -> expectedOutput.append(gemstone.toCSV())));

        assertEquals(expectedOutput.toString(), gemstoneReader.readFromFile(FILE).toString());
    }
}