package ua.lviv.iot.gemstone.manager;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.gemstone.model.SortBy;
import ua.lviv.iot.gemstone.model.TypeOfSorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GemstoneInNecklaceManagerUtilsTest extends BaseGemstoneInNecklaceTest {


    @Test
    public void testSortGemstonesByPriceAsc() {

        GemstoneInNecklaceManagerUtils.sortNecklacesBy(necklaces, SortBy.PRICE_IN_USD_DOLLARS, TypeOfSorting.ASCENDING);
        assertEquals(699, necklaces.get(0).getPriceInUSDDollars());
        assertEquals(1604, necklaces.get(1).getPriceInUSDDollars());
        assertEquals(2303, necklaces.get(2).getPriceInUSDDollars());

    }

    @Test
    public void testSortGemstonesByWeightInCaratsDesc() {

        GemstoneInNecklaceManagerUtils.sortNecklacesBy(necklaces, SortBy.ALL_WEIGHT_IN_CARATS, TypeOfSorting.DESCENDING);
        assertEquals(89.39999999999999, necklaces.get(0).getAllWeightInCarats());
        assertEquals(48.1, necklaces.get(1).getAllWeightInCarats());
        assertEquals(41.3, necklaces.get(2).getAllWeightInCarats());

    }

    @Test
    public void testSortEmptyList() {
        GemstoneInNecklaceManagerUtils.sortNecklacesBy(null, null, null);
    }
}
