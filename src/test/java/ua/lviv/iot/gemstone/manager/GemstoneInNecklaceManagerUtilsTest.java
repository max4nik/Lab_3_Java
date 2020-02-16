package ua.lviv.iot.gemstone.manager;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.gemstone.model.AbstractGemstone;
import ua.lviv.iot.gemstone.model.SortBy;
import ua.lviv.iot.gemstone.model.TypeOfSorting;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GemstoneInNecklaceManagerUtilsTest extends BaseGemstoneInNecklaceTest {

    private List<AbstractGemstone> gemstones = necklace.getGemstonesInLace();


    @Test
    public void testSortGemstonesByPriceAsc() {

        GemstoneInNecklaceManagerUtils.sortGemstonesBy(necklace, SortBy.PRICE_PER_CARAT_IN_USD_DOLLARS, TypeOfSorting.ASCENDING);
        assertEquals(105, gemstones.get(0).getPricePerUSDDollar());
        assertEquals(500, gemstones.get(1).getPricePerUSDDollar());
        assertEquals(999, gemstones.get(2).getPricePerUSDDollar());

    }

    @Test
    public void testSortGemstonesByWeightInCaratsDesc() {

        GemstoneInNecklaceManagerUtils.sortGemstonesBy(necklace, SortBy.WEIGHT_IN_CARATS, TypeOfSorting.DESCENDING);
        assertEquals(20.5, gemstones.get(0).getWeightInCarats());
        assertEquals(15.1, gemstones.get(1).getWeightInCarats());
        assertEquals(12.5, gemstones.get(2).getWeightInCarats());

    }

    @Test
    public void testSortEmptyList() {
        GemstoneInNecklaceManagerUtils.sortGemstonesBy(null, null, null);
    }
}
