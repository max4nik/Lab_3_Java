package ua.lviv.iot.spring.rest.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.gemstone.model.NecklaceShop;
import ua.lviv.iot.spring.rest.dataaccess.NecklaceShopRepository;

import java.util.List;

@Service
public class NecklaceShopService {
    @Autowired
    private NecklaceShopRepository necklaceShopRepository;


    public NecklaceShop createNecklaceShop(NecklaceShop necklaceShop) {
        return necklaceShopRepository.save(necklaceShop);
    }

    public List<NecklaceShop> getAllNecklaceShops() {
        return necklaceShopRepository.findAll();
    }

    public NecklaceShop getNecklaceShopById(Integer id) {
        return necklaceShopRepository.findById(id).get();
    }

    public ResponseEntity<NecklaceShop> deleteNecklaceShop(Integer id) {
        NecklaceShop necklaceShopToCheck = necklaceShopRepository.getOne(id);
        if (necklaceShopToCheck != null) {
            necklaceShopRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<NecklaceShop> updateNecklaceShop(Integer id, NecklaceShop newNecklaceShop) {
        NecklaceShop necklaceShopToCheck = necklaceShopRepository.getOne(id);
        if (necklaceShopToCheck != null) {
            newNecklaceShop.setId(id);
            necklaceShopRepository.save(newNecklaceShop);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}

