package ua.lviv.iot.spring.rest.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.gemstone.model.Necklace;
import ua.lviv.iot.spring.rest.dataaccess.NecklaceRepository;

import java.util.List;

@Service
public class NecklaceService {
    @Autowired
    private NecklaceRepository necklaceRepository;


    public Necklace createNecklace(Necklace necklace) {
        return necklaceRepository.save(necklace);
    }

    public List<Necklace> getAllNecklaces() {
        return necklaceRepository.findAll();
    }

    public Necklace getNecklaceById(Integer id) {
        return necklaceRepository.findById(id).get();
    }

    public ResponseEntity<Necklace> deleteNecklace(Integer id) {
        Necklace necklaceToCheck = necklaceRepository.getOne(id);
        if (necklaceToCheck != null) {
            necklaceRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Necklace> updateNecklace(Integer id, Necklace newNecklace) {
        Necklace necklaceToCheck = necklaceRepository.getOne(id);
        if (necklaceToCheck != null) {
            newNecklace.setNecklaceId(id);
            necklaceRepository.save(newNecklace);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}

