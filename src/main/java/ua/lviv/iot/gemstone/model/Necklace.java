package ua.lviv.iot.gemstone.model;

import java.util.LinkedList;
import java.util.List;

public class Necklace {

    private List<AbstractGemstone> gemstonesInLace = new LinkedList<>();
    private Double priceInUSDDollars;
    private Double allWeightInCarats;
    private Double necklaceLength;

    public Necklace() {

    }

    public Necklace(List<AbstractGemstone> gemstonesInLace, Double priceInUSDDollars, Double necklaceLength) {
        this.gemstonesInLace = gemstonesInLace;
        this.priceInUSDDollars = priceInUSDDollars;
        this.necklaceLength = necklaceLength;
    }

    public Necklace(List<AbstractGemstone> gemstonesInLace) {
        this(gemstonesInLace, null, null);
    }

    public List<AbstractGemstone> getGemstonesInLace() {
        return gemstonesInLace;
    }

    public void setGemstonesInLace(List<AbstractGemstone> gemstonesInLace) {
        this.gemstonesInLace = gemstonesInLace;
    }

    public double getPriceInUSDDollars() {
        return priceInUSDDollars;
    }

    public double getAllWeightInCarats() {
        return allWeightInCarats;
    }

    public double getNecklaceLength() {
        return necklaceLength;
    }

    public void setNecklaceLength(Double necklaceLength) {
        this.necklaceLength = necklaceLength;
    }

    public void addGemstone(AbstractGemstone gemstone) {
        this.gemstonesInLace.add(gemstone);
    }

    public void addGemstones(List<AbstractGemstone> gemstones) {
        this.gemstonesInLace.addAll(gemstones);
    }

    public double calculateAllWeightInCarats() {
        double allGemstonesWeight = 0;
        for (AbstractGemstone gemstones : this.gemstonesInLace) {
            allGemstonesWeight += gemstones.getWeightInCarats();
        }
        this.allWeightInCarats = allGemstonesWeight;
        return allWeightInCarats;
    }

    public double calculatePriceInUSDDollars() {
        double price = 0;
        for (AbstractGemstone gemstones : this.gemstonesInLace) {
            price += gemstones.getPriceInUSDDollars();
        }
        this.priceInUSDDollars = price;
        return priceInUSDDollars;
    }

}

