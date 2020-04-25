package ua.lviv.iot.gemstone.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "\"gemstone\"")
public class Gemstone {

    protected String color;
    protected Double priceInUSD;
    protected String countryOfOrigin;
    protected String chemicalFormula;
    protected Double weightInCarats;

    protected double transparencyFromZeroToOne;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idGemstone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "necklace_id")
    @JsonIgnoreProperties("gemstones")
    private Necklace necklace;

    public Gemstone(String color, double priceInUSD, String countryOfOrigin, String chemicalFormula, double weightInCarats, double transparencyFromZeroToOne) {
        this.color = color;
        this.priceInUSD = priceInUSD;
        this.countryOfOrigin = countryOfOrigin;
        this.chemicalFormula = chemicalFormula;
        this.weightInCarats = weightInCarats;
        this.transparencyFromZeroToOne = transparencyFromZeroToOne;
    }

    public Gemstone() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPriceInUSD() {
        return priceInUSD;
    }

    public void setPriceInUSD(Double priceInUSDDollars) {
        this.priceInUSD = priceInUSDDollars;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getChemicalFormula() {
        return chemicalFormula;
    }

    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }

    public Double getWeightInCarats() {
        return weightInCarats;
    }

    public void setWeightInCarats(Double weightInCarats) {
        this.weightInCarats = weightInCarats;
    }

    public void setTransparencyFromZeroToOne(double transparencyFromZeroToOne) {
        this.transparencyFromZeroToOne = transparencyFromZeroToOne;
    }

    public double getTransparencyFromZeroToOne() {
        return transparencyFromZeroToOne;
    }

    @Transient
    public String getHeaders() {
        return "color" + "," + "priceInUSDDollars" + "," + "countryOfOrigin" + "," + "chemicalFormula" + "," + "weightInCarats";
    }

    public String toCSV() {
        return color + "," + priceInUSD + "," + countryOfOrigin + "," + chemicalFormula + "," + weightInCarats;
    }

    public void setIdGemstone(Integer idGemstone) {
        this.idGemstone = idGemstone;
    }

    public Integer getIdGemstone() {
        return idGemstone;
    }

    public Necklace getNecklace() {
        return necklace;
    }

    public void setNecklace(Necklace necklace) {
        this.necklace = necklace;
    }

}