package ua.lviv.iot.gemstone.manager;

import org.junit.jupiter.api.BeforeEach;
import ua.lviv.iot.gemstone.model.*;

import java.util.LinkedList;
import java.util.List;

public class BaseGemstoneInNecklaceTest {
    protected List<AbstractGemstone> gemstonesForTest;
    protected Necklace necklace = new Necklace();

    @BeforeEach
    public void createGems() {
        gemstonesForTest = new LinkedList<AbstractGemstone>();
        gemstonesForTest.add(new Diamond("red", 999, "Kenya", "C", 20.5, 0.43, "p.d001", ChemicalType.II));
        gemstonesForTest.add(new Ruby("red", 500, "Nigeria", "Al2O3", 12.5, 0.71, "p.r001", 0.0081));
        gemstonesForTest.add(new Nephrite("green", 105, "Angola", "Са2 (Mg, Fe)5 [Si4O11]2[OH]2", 15.1, 0.90, "sp.n001", null));
        necklace.addGemstones(gemstonesForTest);
    }
}
