package ua.lviv.iot.spring.rest.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.gemstone.model.Gemstone;
import ua.lviv.iot.spring.rest.dataaccess.GemstoneRepository;

import java.util.List;

@Service
public class GemstoneService {
    @Autowired
    private GemstoneRepository gemstoneRepository;


    public Gemstone createGemstone(Gemstone gemstone) {
        return gemstoneRepository.save(gemstone);
    }

    public List<Gemstone> getAllGemstones() {
        return gemstoneRepository.findAll();
    }

    public Gemstone getGemstoneById(Integer id) {
        return gemstoneRepository.findById(id).get();
    }

    public ResponseEntity<Gemstone> deleteGemstone(Integer id) {
        Gemstone gemstoneToCheck = gemstoneRepository.getOne(id);
        if (gemstoneToCheck != null) {
            gemstoneRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Gemstone> updateGemstone(Integer id, Gemstone newGemstone) {
        Gemstone gemstoneToCheck = gemstoneRepository.getOne(id);
        if (gemstoneToCheck != null) {
            newGemstone.setIdGemstone(id);
            gemstoneRepository.save(newGemstone);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}

