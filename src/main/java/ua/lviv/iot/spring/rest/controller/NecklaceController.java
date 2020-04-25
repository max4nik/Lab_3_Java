package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.gemstone.model.Necklace;
import ua.lviv.iot.spring.rest.business.NecklaceService;

import java.util.List;

@RequestMapping("/necklaces")
@RestController
public class NecklaceController {

    @Autowired
    private NecklaceService necklaceService;

    @GetMapping
    public List<Necklace> getAllNecklaces() {
        return necklaceService.getAllNecklaces();
    }

    @GetMapping(path = "/{id}")
    public Necklace getNecklace(final @PathVariable("id") Integer necklaceId) {
        return necklaceService.getNecklaceById(necklaceId);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Necklace createNecklace(final @RequestBody Necklace necklace) {
        return necklaceService.createNecklace(necklace);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Necklace> deleteNecklace(final @PathVariable("id") Integer necklaceId) {
        return necklaceService.deleteNecklace(necklaceId);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Necklace> updateNecklace(final @PathVariable("id") Integer necklaceId, final @RequestBody Necklace necklace) {
        return necklaceService.updateNecklace(necklaceId, necklace);
    }

}

