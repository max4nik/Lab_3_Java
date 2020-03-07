package ua.lviv.iot.gemstone.manager;

import ua.lviv.iot.gemstone.model.AbstractGemstone;
import ua.lviv.iot.gemstone.model.Necklace;

import java.util.LinkedList;
import java.util.List;

public class GemstoneInNecklaceManager {

    private Necklace necklace;

    public GemstoneInNecklaceManager(Necklace necklace) {
        this.necklace = necklace;
    }

    public List<AbstractGemstone> findGemstonesWithTransparencyBetween(double minimalTransparencyType, double maximalTransparencyType) {
        List<AbstractGemstone> gemstonesForLace = this.necklace.getGemstonesInLace();
        List<AbstractGemstone> result = new LinkedList<>();
        for (AbstractGemstone gemstone : gemstonesForLace) {
            if (gemstone.getTransparency() >= minimalTransparencyType && gemstone.getTransparency() <= maximalTransparencyType) {
                result.add(gemstone);
            }
        }
        return result;
    }
}
