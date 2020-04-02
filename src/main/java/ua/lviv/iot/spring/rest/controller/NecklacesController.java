package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.gemstone.model.Necklace;
import ua.lviv.iot.spring.rest.business.NecklaceService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/necklaces")
@RestController
public class NecklacesController {

    private Map<Integer, Necklace> necklaces = new HashMap<>();
    private AtomicInteger IdCounter = new AtomicInteger();

    @Autowired
    private NecklaceService necklaceService;

    @GetMapping
    public List<Necklace> getAllNecklaces() {
        return new LinkedList<>(necklaces.values());
    }

    @GetMapping(path = "/{id}")
    public Necklace getNecklace(final @PathVariable("id") Integer necklaceId) {
        return necklaces.get(necklaceId);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Necklace createNecklace(final @RequestBody Necklace necklace) {
        necklace.setId(IdCounter.incrementAndGet());
        necklaces.put(necklace.getId(), necklace);
        necklaceService.createNecklace(necklace);
        return necklace;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Necklace> deleteNecklace(final @PathVariable("id") Integer necklaceId) {
        HttpStatus status = necklaces.remove(necklaceId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        necklaceService.deleteNecklace(necklaceId);
        return ResponseEntity.status(status).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Necklace> updateNecklace(final @PathVariable("id") Integer necklaceId, final @RequestBody Necklace necklace) {
        HttpStatus status = necklaces.put(necklaceId, necklace) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        necklaceService.updateNecklace(necklaceId, necklace);
        return ResponseEntity.status(status).build();
    }

}

