package ua.lviv.iot.gemstone.model;

import java.util.Arrays;

public class Nephrite extends SemipreciousStone {

    public String[] impurities;

    public Nephrite(String color, double pricePerUSDDollar, String countryOfOrigin, String chemicalFormula, double weightInCarats, double transparencyFromZeroToOne, String specialSemipreciousStoneID, String[] impurities) {
        super(color, pricePerUSDDollar, countryOfOrigin, chemicalFormula, weightInCarats, transparencyFromZeroToOne, specialSemipreciousStoneID);
        this.impurities = impurities;
    }

    public String[] getImpurities() {
        return Arrays.copyOf(impurities, impurities.length);
    }

    public void setImpurities(String[] impurities) {
        this.impurities = impurities;
    }

    public String getHeaders() {
        return super.getHeaders() + "," + "impurities";
    }

    public String toCSV() {
        return super.toCSV() + "," + Arrays.toString(impurities);
    }
}
