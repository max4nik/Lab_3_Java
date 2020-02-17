package ua.lviv.iot.gemstone.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.gemstone.model.AbstractGemstone;

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

        List<AbstractGemstone> gems = gemstoneInNecklaceManager.findGemstonesWithTransparencyBetween(0.2, 0.8);
        assertEquals(2, gems.size());

        //sort transparencies
        double transparencies[] = new double[gems.size()];
        int iterator = 0;
        for (AbstractGemstone gemstone : gems) {
            transparencies[iterator] = gems.get(iterator).getTransparency();
            iterator++;
        }
        Arrays.sort(transparencies);

        // verify found gemstones transparency
        assertEquals(0.43, transparencies[0]);
        assertEquals(0.71, transparencies[1]);

    }
}