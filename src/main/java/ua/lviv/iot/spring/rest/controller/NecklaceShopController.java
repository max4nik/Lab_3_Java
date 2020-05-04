package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.gemstone.model.NecklaceShop;
import ua.lviv.iot.spring.rest.business.NecklaceShopService;

import java.util.List;

@RequestMapping("/shops")
@RestController
public class NecklaceShopController {

    @Autowired
    private NecklaceShopService necklaceShopService;

    @GetMapping
    public List<NecklaceShop> getAllNecklaceShops() {
        return necklaceShopService.getAllNecklaceShops();
    }

    @GetMapping(path = "/{id}")
    public NecklaceShop getNecklaceShop(final @PathVariable("id") Integer shopId) {
        return necklaceShopService.getNecklaceShopById(shopId);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public NecklaceShop createNecklaceShop(final @RequestBody NecklaceShop necklaceShop) {
        return necklaceShopService.createNecklaceShop(necklaceShop);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<NecklaceShop> deleteNecklaceShop(final @PathVariable("id") Integer shopId) {
        return necklaceShopService.deleteNecklaceShop(shopId);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<NecklaceShop> updateNecklaceShop(final @PathVariable("id") Integer shopId, final @RequestBody NecklaceShop necklaceShop) {
        return necklaceShopService.updateNecklaceShop(shopId, necklaceShop);
    }

}

