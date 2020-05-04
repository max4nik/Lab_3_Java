package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.gemstone.model.Gemstone;
import ua.lviv.iot.spring.rest.business.GemstoneService;

import java.util.List;

@RequestMapping("/gemstones")
@RestController
public class GemstonesController {

    @Autowired
    private GemstoneService gemstoneService;

    @GetMapping
    public List<Gemstone> getAllGemstones() {
        return gemstoneService.getAllGemstones();
    }

    @GetMapping(path = "/{id}")
    public Gemstone getGemstone(final @PathVariable("id") Integer gemstoneId) {
        return gemstoneService.getGemstoneById(gemstoneId);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Gemstone createGemstone(final @RequestBody Gemstone gemstone) {
        return gemstoneService.createGemstone(gemstone);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Gemstone> deleteGemstone(final @PathVariable("id") Integer gemstoneId) {
        return gemstoneService.deleteGemstone(gemstoneId);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Gemstone> updateGemstone(final @PathVariable("id") Integer gemstoneId, final @RequestBody Gemstone gemstone) {
        return gemstoneService.updateGemstone(gemstoneId, gemstone);
    }

}

