package ua.lviv.iot.gemstone.model;

public class Pearl extends AbstractSemipreciousStone{

    private double weightInGrams;

    public Pearl(String color, double pricePerUSDDollar, String countryOfOrigin, String chemicalFormula, double weightInCarats, double transparencyFromZeroToOne, String specialSemipreciousStoneID) {
        super(color, pricePerUSDDollar, countryOfOrigin, chemicalFormula, weightInCarats, transparencyFromZeroToOne, specialSemipreciousStoneID);
        this.weightInGrams = this.weightInCarats * 0.2;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

}
