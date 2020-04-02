package ua.lviv.iot.gemstone.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Necklace {


    private Double priceInUSDDollars;
    @Transient
    private List<AbstractGemstone> gemstonesInLace = new LinkedList<>();
    private Double allWeightInCarats;
    private Double necklaceLengthInMeters;
    @Transient
    private Integer amountOfGems;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer necklaceId;

    public Necklace() {

    }

    public Necklace(List<AbstractGemstone> gemstonesInLace, Double necklaceLengthInMeters) {
        this.gemstonesInLace = gemstonesInLace;
        this.necklaceLengthInMeters = necklaceLengthInMeters;
    }

    public Necklace(List<AbstractGemstone> gemstonesInLace) {
        this(gemstonesInLace, null);
    }

    public Integer getId() {
        return necklaceId;
    }

    public void setId(Integer necklaceId) {
        this.necklaceId = necklaceId;
    }

    public Necklace(Double necklaceLengthInMeters) {
        this.necklaceLengthInMeters = necklaceLengthInMeters;
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

    public double returnCalculatedPriceInUSDDollars() {
        calculatePriceInUSDDollars();
        return priceInUSDDollars;
    }

    public double getAllWeightInCarats() {
        return allWeightInCarats;
    }

    public double returnCalculatedAllWeightInCarats() {
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
        for (int iterator = 0; iterator < this.gemstonesInLace.size(); iterator++) {
            countOfGems++;
        }
        this.amountOfGems = countOfGems;
        return amountOfGems;
    }

    public String getHeaders() {
        return "gemstonesInLace" + "," + "priceInUSDDollars" + "," + "allWeightInCarats" + "," + "necklaceLengthInMeters" + "," + "amountOfGems";
    }

    public String toCSV() {
        return gemstonesInLace + "," + priceInUSDDollars + "," + allWeightInCarats + "," + necklaceLengthInMeters + "," + amountOfGems;
    }

    @Override
    public String toString() {
        return "Necklace{" +
                "gemstonesInLace=" + gemstonesInLace +
                ", priceInUSDDollars=" + priceInUSDDollars +
                ", allWeightInCarats=" + allWeightInCarats +
                ", necklaceLengthInMeters=" + necklaceLengthInMeters +
                ", amountOfGems=" + amountOfGems +
                ", necklaceId=" + necklaceId +
                '}';
    }
}

