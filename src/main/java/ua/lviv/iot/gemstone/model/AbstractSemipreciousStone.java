package ua.lviv.iot.gemstone.model;

public abstract class AbstractSemipreciousStone extends AbstractGemstone{

    protected String specialSemipreciousStoneID;

    public AbstractSemipreciousStone(String color, double pricePerUSDDollar, String countryOfOrigin, String chemicalFormula, double weightInCarats, double transparencyFromZeroToOne, String specialSemipreciousStoneID) {
        super(color, pricePerUSDDollar, countryOfOrigin, chemicalFormula, weightInCarats, transparencyFromZeroToOne);
        this.specialSemipreciousStoneID = specialSemipreciousStoneID;
    }

    public String getSpecialSemipreciousStoneID() {
        return specialSemipreciousStoneID;
    }

    public void setSpecialSemipreciousStoneID(String specialSemipreciousStoneID) {
        this.specialSemipreciousStoneID = specialSemipreciousStoneID;
    }
}
