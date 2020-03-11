package ua.lviv.iot.gemstone.model;

public abstract class AbstractPreciousStone extends AbstractGemstone {

    protected String specialPreciousStoneID;


    public AbstractPreciousStone(String color, double pricePerUSDDollar, String countryOfOrigin, String chemicalFormula, double weightInCarats, double transparencyFromZeroToOne, String specialPreciousStoneID) {
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