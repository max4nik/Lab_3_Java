package ua.lviv.iot.gemstone.manager;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.gemstone.model.TypeOfSorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GemstoneInNecklaceManagerUtilsTest extends BaseGemstoneInNecklaceTest {


    @Test
    public void testSortNecklacesByPriceAsc() {
        GemstoneInNecklaceManagerUtils.sortNecklacesByPriceInUSDDollars(necklaces, TypeOfSorting.ASCENDING);
        assertEquals(699, necklaces.get(0).getPriceInUSDDollars());
        assertEquals(1604, necklaces.get(1).getPriceInUSDDollars());
        assertEquals(2303, necklaces.get(2).getPriceInUSDDollars());

    }


    @Test
    public void testSortNecklacesByWeightInCaratsDesc() {
        GemstoneInNecklaceManagerUtils.sortNecklacesByAllWeightInCarats(necklaces, TypeOfSorting.DESCENDING);
        assertEquals(89.39999999999999, necklaces.get(0).getAllWeightInCarats());
        assertEquals(48.1, necklaces.get(1).getAllWeightInCarats());
        assertEquals(41.3, necklaces.get(2).getAllWeightInCarats());
    }

    @Test
    public void testSortNecklacesByAmountOfGemsDesc() {
        GemstoneInNecklaceManagerUtils.sortNecklacesByAmountOfGems(necklaces, TypeOfSorting.DESCENDING);
        assertEquals(7, necklaces.get(0).getAmountOfGems());
        assertEquals(4, necklaces.get(1).getAmountOfGems());
        assertEquals(3, necklaces.get(2).getAmountOfGems());
    }

    @Test
    public void testSortNecklacesByLengthInMeters() {
        GemstoneInNecklaceManagerUtils.sortNecklacesByLengthInMeters(necklaces, TypeOfSorting.ASCENDING);
        assertEquals(0.3, necklaces.get(0).getNecklaceLengthInMeters());
        assertEquals(0.5, necklaces.get(1).getNecklaceLengthInMeters());
        assertEquals(0.8, necklaces.get(2).getNecklaceLengthInMeters());

    }
}
