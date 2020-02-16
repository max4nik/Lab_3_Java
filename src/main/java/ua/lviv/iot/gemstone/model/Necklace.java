package ua.lviv.iot.gemstone.model;

import java.util.LinkedList;
import java.util.List;

public class Necklace {

    private List <AbstractGemstone> gemstonesInLace = new LinkedList<>();
    private Double laceWeightInGrams;
    private Double priceInUSDDollars;
    private Double allWeightInGrams;
    private Double necklaceLength;

    public Necklace(){

    }

    public Necklace(List<AbstractGemstone> gemstonesInLace, Double laceWeightInGrams, Double priceInUSDDollars, Double necklaceLength) {
        this.gemstonesInLace = gemstonesInLace;
        this.laceWeightInGrams = laceWeightInGrams;
        this.priceInUSDDollars = priceInUSDDollars;
        this.necklaceLength = necklaceLength;
    }

    public Necklace(List<AbstractGemstone> gemstonesInLace){
        this(gemstonesInLace, null, null, null);
    }

    public List<AbstractGemstone> getGemstonesInLace() {
        return gemstonesInLace;
    }

    public void setGemstonesInLace(List<AbstractGemstone> gemstonesInLace) {
        this.gemstonesInLace = gemstonesInLace;
    }

    public double getLaceWeightInGrams() {
        return laceWeightInGrams;
    }

    public void setLaceWeightInGrams(Double laceWeightInGrams) {
        this.laceWeightInGrams = laceWeightInGrams;
    }

    public double getPriceInUSDDollars() {
        return priceInUSDDollars;
    }

    public void setPriceInUSDDollars(Double priceInUSDDollars) {
        this.priceInUSDDollars = priceInUSDDollars;
    }

    public double getAllWeightInGrams() {
        return allWeightInGrams;
    }

    public double getNecklaceLength() {
        return necklaceLength;
    }

    public void setNecklaceLength(Double necklaceLength) {
        this.necklaceLength = necklaceLength;
    }

    public void addGemstone(AbstractGemstone gemstone){
        this.gemstonesInLace.add(gemstone);
    }

    public void addGemstones(List<AbstractGemstone> gemstones){
        this.gemstonesInLace.addAll(gemstones);
    }

    public double calculateAllWeightInGrams(){
        double allGemstonesWeight = 0;
        for (AbstractGemstone gemstones : this.gemstonesInLace){
            allGemstonesWeight += (gemstones.getWeightInCarats() * 0.2);
        }
        this.allWeightInGrams = this.laceWeightInGrams + allGemstonesWeight;
        return allWeightInGrams;
    }


}

