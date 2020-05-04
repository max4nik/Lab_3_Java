package ua.lviv.iot.spring.rest.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.gemstone.model.Necklace;

public interface NecklaceRepository extends JpaRepository<Necklace, Integer> {

}
