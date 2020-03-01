package ua.lviv.iot.gemstone.manager;

import ua.lviv.iot.gemstone.model.Necklace;
import ua.lviv.iot.gemstone.model.TypeOfSorting;

import java.util.Comparator;
import java.util.List;

public class GemstoneInNecklaceManagerUtils {
    private static final NecklaceSorterByPriceInUSDDollars NECKLACE_SORTER_BY_PRICE_IN_USD_DOLLARS = new NecklaceSorterByPriceInUSDDollars();
    private static GemstoneInNecklaceManagerUtils gemstoneInNecklaceManagerUtils = new GemstoneInNecklaceManagerUtils();
    private static final GemstoneInNecklaceManagerUtils.NecklaceSorterByAllWeightInCarats NECKLACE_SORTER_BY_ALL_WEIGHT_IN_CARATS = gemstoneInNecklaceManagerUtils.new NecklaceSorterByAllWeightInCarats();

    // sort with inner class
    public static void sortNecklacesByAllWeightInCarats(List<Necklace> necklaces, TypeOfSorting typeOfSorting) {
        necklaces.sort(typeOfSorting == TypeOfSorting.ASCENDING ? NECKLACE_SORTER_BY_ALL_WEIGHT_IN_CARATS : NECKLACE_SORTER_BY_ALL_WEIGHT_IN_CARATS.reversed());
    }

    // sort with nested class
    public static void sortNecklacesByPriceInUSDDollars(List<Necklace> necklaces, TypeOfSorting typeOfSorting) {
        necklaces.sort(typeOfSorting == TypeOfSorting.ASCENDING ? NECKLACE_SORTER_BY_PRICE_IN_USD_DOLLARS : NECKLACE_SORTER_BY_PRICE_IN_USD_DOLLARS.reversed());
    }

    // sort with anonymous inner class
    public static void sortNecklacesByLengthInMeters(List<Necklace> necklaces, TypeOfSorting typeOfSorting) {

        Comparator<Necklace> comparator = new Comparator<Necklace>() {

            public int compare(Necklace firstNecklace, Necklace secondNecklace) {
                return Double.compare(firstNecklace.getNecklaceLengthInMeters(), secondNecklace.getNecklaceLengthInMeters());
            }
        };

        necklaces.sort(typeOfSorting == TypeOfSorting.ASCENDING ? comparator : comparator.reversed());
    }

    // sort with lambda
    public static void sortNecklacesByAmountOfGems(List<Necklace> necklaces, TypeOfSorting typeOfSorting) {
        int comparator = typeOfSorting == TypeOfSorting.DESCENDING ? -1 : 1;
        necklaces.sort((firstNecklace, secondNecklace) -> comparator * (firstNecklace.getAmountOfGems() - secondNecklace.getAmountOfGems()));
    }

    class NecklaceSorterByAllWeightInCarats implements Comparator<Necklace> {
        @Override
        public int compare(Necklace firstNecklace, Necklace secondNecklace) {
            return Double.compare(firstNecklace.getAllWeightInCarats(), secondNecklace.getAllWeightInCarats());
        }
    }

    static class NecklaceSorterByPriceInUSDDollars implements Comparator<Necklace> {
        @Override
        public int compare(Necklace firstNecklace, Necklace secondNecklace) {
            return Double.compare(firstNecklace.getPriceInUSDDollars(), secondNecklace.getPriceInUSDDollars());
        }
    }

}