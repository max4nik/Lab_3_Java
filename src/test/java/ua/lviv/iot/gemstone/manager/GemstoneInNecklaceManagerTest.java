package ua.lviv.iot.gemstone.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.gemstone.model.Gemstone;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GemstoneInNecklaceManagerTest extends BaseGemstoneInNecklaceTest {

    private GemstoneInNecklaceManager gemstoneInNecklaceManager;

    @BeforeEach
    public void setUp() {
        gemstoneInNecklaceManager = new GemstoneInNecklaceManager(professionalNecklace);
    }

    @Test
    void testFindGemstonesWithTransparencyBetween() {

        List<Gemstone> gems = gemstoneInNecklaceManager.findGemstonesWithTransparencyBetween(0.2, 0.8);
        assertEquals(2, gems.size());

        //sort transparencies
        double transparencies[] = new double[gems.size()];
        int iterator = 0;
        for (Gemstone gemstone : gems) {
            transparencies[iterator] = gems.get(iterator).getTransparencyFromZeroToOne();
            iterator++;
        }
        Arrays.sort(transparencies);

        // verify found gemstones transparency
        assertEquals(0.43, transparencies[0]);
        assertEquals(0.71, transparencies[1]);

    }
}