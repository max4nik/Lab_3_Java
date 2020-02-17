package ua.lviv.iot.gemstone.manager;

import ua.lviv.iot.gemstone.model.Necklace;
import ua.lviv.iot.gemstone.model.SortBy;
import ua.lviv.iot.gemstone.model.TypeOfSorting;

import java.util.Comparator;
import java.util.List;

public class GemstoneInNecklaceManagerUtils {
    private static final NecklaceSorterByAllWeightInCarats NECKLACE_BY_ALL_WEIGHT_IN_CARATS_SORTER = new NecklaceSorterByAllWeightInCarats();
    private static final NecklaceSorterByPriceInUSDDollars NECKLACE_SORTER_BY_PRICE_IN_USD_DOLLARS = new NecklaceSorterByPriceInUSDDollars();

    public static void sortNecklacesBy(List<Necklace> necklaces, SortBy sortBy, TypeOfSorting typeOfSorting) {

        if (sortBy == SortBy.ALL_WEIGHT_IN_CARATS) {
            necklaces.sort(typeOfSorting == TypeOfSorting.ASCENDING ? NECKLACE_BY_ALL_WEIGHT_IN_CARATS_SORTER : NECKLACE_BY_ALL_WEIGHT_IN_CARATS_SORTER.reversed());
        } else if (sortBy == SortBy.PRICE_IN_USD_DOLLARS) {
            necklaces.sort(typeOfSorting == TypeOfSorting.ASCENDING ? NECKLACE_SORTER_BY_PRICE_IN_USD_DOLLARS : NECKLACE_SORTER_BY_PRICE_IN_USD_DOLLARS.reversed());
        }

    }

}

class NecklaceSorterByAllWeightInCarats implements Comparator<Necklace> {
    @Override
    public int compare(Necklace firstNecklace, Necklace secondNecklace) {

        if (firstNecklace.getAllWeightInCarats() < secondNecklace.getAllWeightInCarats()) {
            return -1;
        } else if (firstNecklace.getAllWeightInCarats() > secondNecklace.getAllWeightInCarats()) {
            return 1;
        } else {
            return 0;
        }
    }
}

class NecklaceSorterByPriceInUSDDollars implements Comparator<Necklace> {
    @Override
    public int compare(Necklace firstNecklace, Necklace secondNecklace) {
        if (firstNecklace.getPriceInUSDDollars() < secondNecklace.getPriceInUSDDollars()) {
            return -1;
        } else if (firstNecklace.getPriceInUSDDollars() > secondNecklace.getPriceInUSDDollars()) {
            return 1;
        } else {
            return 0;
        }
    }
}
