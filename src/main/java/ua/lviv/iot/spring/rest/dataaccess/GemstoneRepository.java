package ua.lviv.iot.spring.rest.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.gemstone.model.Gemstone;

public interface GemstoneRepository extends JpaRepository<Gemstone, Integer> {

}
