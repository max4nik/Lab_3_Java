package ua.lviv.iot.gemstone.model;

public class Pearl extends SemipreciousStone {

    private double weightInGrams;

    public Pearl(String color, double pricePerUSDDollar, String countryOfOrigin, String chemicalFormula, double weightInCarats, double transparencyFromZeroToOne, String specialSemipreciousStoneID) {
        super(color, pricePerUSDDollar, countryOfOrigin, chemicalFormula, weightInCarats, transparencyFromZeroToOne, specialSemipreciousStoneID);
        this.weightInGrams = this.weightInCarats * 0.2;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public String getHeaders() {
        return super.getHeaders() + "," + "weightInGrams";
    }

    public String toCSV() {
        return super.toCSV() + "," + weightInGrams;
    }

}
