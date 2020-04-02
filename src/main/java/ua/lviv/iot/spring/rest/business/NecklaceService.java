package ua.lviv.iot.spring.rest.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.gemstone.model.Necklace;
import ua.lviv.iot.spring.rest.dataaccess.NecklaceRepository;

@Service
public class NecklaceService {
    @Autowired
    private NecklaceRepository necklaceRepository;


    public Necklace createNecklace(Necklace necklace) {
        return necklaceRepository.save(necklace);
    }

    public void deleteNecklace(Integer id) {
        necklaceRepository.deleteById(id);
    }

    public Necklace updateNecklace(Integer id, Necklace newNecklace) {
        Necklace necklace = necklaceRepository.getOne(id);
        necklace = newNecklace;
        return necklaceRepository.save(necklace);
    }
}
