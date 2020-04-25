package ua.lviv.iot.gemstone.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class NecklaceShop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "shops",
            joinColumns = {@JoinColumn(name = "shop_id", nullable = false)},
            inverseJoinColumns = @JoinColumn(name = "necklace_id", nullable = false))
    @JsonIgnoreProperties("shops")
    private Set<Necklace> necklaces;

    public NecklaceShop() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Necklace> getNecklaces() {
        return necklaces;
    }

    public void setNecklaces(Set<Necklace> students) {
        this.necklaces = students;
    }
}
