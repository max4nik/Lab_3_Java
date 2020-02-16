package ua.lviv.iot.gemstone.manager;

import ua.lviv.iot.gemstone.model.AbstractGemstone;
import ua.lviv.iot.gemstone.model.Necklace;
import ua.lviv.iot.gemstone.model.SortBy;
import ua.lviv.iot.gemstone.model.TypeOfSorting;

import java.util.Comparator;

public class GemstoneInNecklaceManagerUtils {
    private static final GemsSorterByWeightInCarats GEMS_BY_WEIGHT_IN_CARATS_SORTER = new GemsSorterByWeightInCarats();
    private static final GemsSorterByPricePerCaratInUSDDollars GEMS_BY_PRICE_PER_CARAT_IN_USD_DOLLARS_SORTER = new GemsSorterByPricePerCaratInUSDDollars();

    public static void sortGemstonesBy(Necklace necklace, SortBy sortBy, TypeOfSorting typeOfSorting) {

        if (sortBy == SortBy.WEIGHT_IN_CARATS) {
            necklace.getGemstonesInLace().sort(typeOfSorting == TypeOfSorting.ASCENDING ? GEMS_BY_WEIGHT_IN_CARATS_SORTER : GEMS_BY_WEIGHT_IN_CARATS_SORTER.reversed());
        } else if (sortBy == SortBy.PRICE_PER_CARAT_IN_USD_DOLLARS) {
            necklace.getGemstonesInLace().sort(typeOfSorting == TypeOfSorting.ASCENDING ? GEMS_BY_PRICE_PER_CARAT_IN_USD_DOLLARS_SORTER : GEMS_BY_PRICE_PER_CARAT_IN_USD_DOLLARS_SORTER.reversed());
        }

    }

}

class GemsSorterByWeightInCarats implements Comparator<AbstractGemstone> {
    @Override
    public int compare(AbstractGemstone firstGemstone, AbstractGemstone secondGemstone) {

        if (firstGemstone.getWeightInCarats() < secondGemstone.getWeightInCarats()) {
            return -1;
        } else if (firstGemstone.getWeightInCarats() > secondGemstone.getWeightInCarats()) {
            return 1;
        } else {
            return 0;
        }
    }
}

class GemsSorterByPricePerCaratInUSDDollars implements Comparator<AbstractGemstone> {
    @Override
    public int compare(AbstractGemstone firstGemstone, AbstractGemstone secondGemstone) {
        if (firstGemstone.getPricePerUSDDollar() < secondGemstone.getPricePerUSDDollar()) {
            return -1;
        } else if (firstGemstone.getPricePerUSDDollar() > secondGemstone.getPricePerUSDDollar()) {
            return 1;
        } else {
            return 0;
        }
    }
}
