package ua.lviv.iot.gemstone.manager;

import org.junit.jupiter.api.BeforeEach;
import ua.lviv.iot.gemstone.model.*;

import java.util.LinkedList;
import java.util.List;

public class BaseGemstoneInNecklaceTest {
    protected Necklace professionalNecklace = new Necklace(0.5);
    protected Necklace amateurNecklace = new Necklace(0.3);
    protected Necklace handmadeNecklace = new Necklace(0.8);
    protected List<Necklace> necklaces;


    @BeforeEach
    public void createGems() {
        List<AbstractGemstone> firstPartyOfGemstones = new LinkedList<AbstractGemstone>();
        firstPartyOfGemstones.add(new Diamond("red", 999, "Kenya", "C", 20.5, 0.43, "p.d001", ChemicalType.II));
        firstPartyOfGemstones.add(new Ruby("red", 500, "Nigeria", "Al2O3", 12.5, 0.71, "p.r002", 0.0081));
        firstPartyOfGemstones.add(new Nephrite("green", 105, "Angola", "Са2 (Mg, Fe)5 [Si4O11]2[OH]2", 15.1, 0.90, "sp.n002", new String[]{"Cr", "Fe"}));


        List<AbstractGemstone> secondPartyOfGemstones = new LinkedList<AbstractGemstone>();
        secondPartyOfGemstones.add(new Pearl("pearl", 100, "Kenya", "CaCO3", 10, 0.31, "sp.p001"));
        secondPartyOfGemstones.add(new Ruby("red", 450, "Nigeria", "Al2O3", 11.5, 0.66, "p.r002", 0.0081));
        secondPartyOfGemstones.add(new Nephrite("green", 99, "Angola", "Са2 (Mg, Fe)5 [Si4O11]2[OH]2", 14.3, 0.81, "sp.n002", new String[]{"Fe", "Ni"}));
        secondPartyOfGemstones.add(new Pearl("pearl", 50, "Kenya", "CaCO3", 5.5, 0.25, "sp.p002"));

        professionalNecklace.addGemstones(firstPartyOfGemstones);
        amateurNecklace.addGemstones(secondPartyOfGemstones);
        handmadeNecklace.addGemstones(secondPartyOfGemstones);
        handmadeNecklace.addGemstones(firstPartyOfGemstones);

        necklaces = new LinkedList<>();
        necklaces.add(professionalNecklace);
        necklaces.add(amateurNecklace);
        necklaces.add(handmadeNecklace);

    }
}
