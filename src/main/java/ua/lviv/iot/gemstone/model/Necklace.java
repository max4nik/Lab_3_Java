package ua.lviv.iot.gemstone.model;

import java.util.LinkedList;
import java.util.List;

public class Necklace {

    private List<AbstractGemstone> gemstonesInLace = new LinkedList<>();
    private Double priceInUSDDollars;
    private Double allWeightInCarats;
    private Double necklaceLengthInMeters;
    private Integer amountOfGems;


    public Necklace(List<AbstractGemstone> gemstonesInLace, Double necklaceLengthInMeters) {
        this.gemstonesInLace = gemstonesInLace;
        this.necklaceLengthInMeters = necklaceLengthInMeters;
    }

    public Necklace(Double necklaceLengthInMeters) {
        this.necklaceLengthInMeters = necklaceLengthInMeters;
    }

    public Necklace(List<AbstractGemstone> gemstonesInLace) {
        this(gemstonesInLace, null);
    }

    public List<AbstractGemstone> getGemstonesInLace() {
        return gemstonesInLace;
    }

    public void setGemstonesInLace(List<AbstractGemstone> gemstonesInLace) {
        this.gemstonesInLace = gemstonesInLace;
    }

    public double getPriceInUSDDollars() {
        calculatePriceInUSDDollars();
        return priceInUSDDollars;
    }

    public double getAllWeightInCarats() {
        calculateAllWeightInCarats();
        return allWeightInCarats;
    }

    public double getNecklaceLengthInMeters() {
        return necklaceLengthInMeters;
    }

    public void setNecklaceLengthInMeters(Double necklaceLengthInMeters) {
        this.necklaceLengthInMeters = necklaceLengthInMeters;
    }

    public void addGemstone(AbstractGemstone gemstone) {
        this.gemstonesInLace.add(gemstone);
    }

    public void addGemstones(List<AbstractGemstone> gemstones) {
        this.gemstonesInLace.addAll(gemstones);
    }

    public Integer getAmountOfGems() {
        this.calculateAmountOfGems();
        return amountOfGems;
    }


    private void calculateAllWeightInCarats() {
        double allGemstonesWeight = 0;
        for (AbstractGemstone gemstones : this.gemstonesInLace) {
            allGemstonesWeight += gemstones.getWeightInCarats();
        }
        this.allWeightInCarats = allGemstonesWeight;
    }

    private void calculatePriceInUSDDollars() {
        double price = 0;
        for (AbstractGemstone gemstones : this.gemstonesInLace) {
            price += gemstones.getPriceInUSDDollars();
        }
        this.priceInUSDDollars = price;
    }

    private Integer calculateAmountOfGems() {
        Integer countOfGems = 0;
        for (AbstractGemstone gemstone : this.gemstonesInLace) {
            countOfGems++;
        }
        this.amountOfGems = countOfGems;
        return amountOfGems;
    }

}

