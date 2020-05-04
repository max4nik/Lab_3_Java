package ua.lviv.iot.gemstone.model;

public class Ruby extends PreciousStone {

    private double refractiveIndex;

    public Ruby(String color, double pricePerUSDDollar, String countryOfOrigin, String chemicalFormula, double weightInCarats, double transparencyFromZeroToOne, String specialPreciousStoneID, double refractiveIndex) {
        super(color, pricePerUSDDollar, countryOfOrigin, chemicalFormula, weightInCarats, transparencyFromZeroToOne, specialPreciousStoneID);
        this.refractiveIndex = refractiveIndex;
    }

    public double getRefractiveIndex() {
        return refractiveIndex;
    }

    public void setRefractiveIndex(double refractiveIndex) {
        this.refractiveIndex = refractiveIndex;
    }

    public String getHeaders() {
        return super.getHeaders() + "," + "refractiveIndex";
    }

    public String toCSV() {
        return super.toCSV() + "," + refractiveIndex;
    }
}