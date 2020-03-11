package ua.lviv.iot.gemstone.model;

public class Diamond extends AbstractPreciousStone{
    private ChemicalType chemicalType;

    public Diamond(String color, double pricePerUSDDollar, String countryOfOrigin, String chemicalFormula, double weightInCarats, double transparencyFromZeroToOne, String specialPreciousStoneID, ChemicalType chemicalType) {
        super(color, pricePerUSDDollar, countryOfOrigin, chemicalFormula, weightInCarats, transparencyFromZeroToOne, specialPreciousStoneID);
        this.chemicalType = chemicalType;
    }

    public ChemicalType getChemicalType() {
        return chemicalType;
    }

    public void setChemicalType(ChemicalType chemicalType) {
        this.chemicalType = chemicalType;
    }

    public String getHeaders() {
        return super.getHeaders() + "," + "chemicalType";
    }

    public String toCSV() {
        return super.toCSV() + "," + chemicalType;
    }
}
