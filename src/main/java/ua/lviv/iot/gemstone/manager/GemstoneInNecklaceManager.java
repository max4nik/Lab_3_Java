package ua.lviv.iot.gemstone.manager;

import ua.lviv.iot.gemstone.model.Gemstone;
import ua.lviv.iot.gemstone.model.Necklace;

import java.util.LinkedList;
import java.util.List;

public class GemstoneInNecklaceManager {

    private Necklace necklace;

    public GemstoneInNecklaceManager(Necklace necklace) {
        this.necklace = necklace;
    }

    public List<Gemstone> findGemstonesWithTransparencyBetween(double minimalTransparencyType, double maximalTransparencyType) {
        List<Gemstone> gemstonesForLace = this.necklace.getGemstonesInLace();
        List<Gemstone> result = new LinkedList<>();
        for (Gemstone gemstone : gemstonesForLace) {
            if (gemstone.getTransparencyFromZeroToOne() >= minimalTransparencyType && gemstone.getTransparencyFromZeroToOne() <= maximalTransparencyType) {
                result.add(gemstone);
            }
        }
        return result;
    }
}
