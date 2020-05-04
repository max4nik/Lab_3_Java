package ua.lviv.iot.gemstone.model;

public class PreciousStone extends Gemstone {

    protected String specialPreciousStoneID;


    public PreciousStone(String color, double pricePerUSDDollar, String countryOfOrigin, String chemicalFormula, double weightInCarats, double transparencyFromZeroToOne, String specialPreciousStoneID) {
        super(color, pricePerUSDDollar, countryOfOrigin, chemicalFormula, weightInCarats, transparencyFromZeroToOne);
        this.specialPreciousStoneID = specialPreciousStoneID;
    }

    public String getSpecialPreciousStoneID() {
        return specialPreciousStoneID;
    }

    public void setSpecialPreciousStoneID(String specialPreciousStoneID) {
        this.specialPreciousStoneID = specialPreciousStoneID;
    }

    public String getHeaders() {
        return super.getHeaders() + "," + "specialPreciousStoneID";
    }

    public String toCSV() {
        return super.toCSV() + "," + specialPreciousStoneID;
    }
}