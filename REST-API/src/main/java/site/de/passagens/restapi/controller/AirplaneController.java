package site.de.passagens.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.de.passagens.restapi.entity.Airplane;
import site.de.passagens.restapi.service.AirplaneService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airplanes")
public class AirplaneController {

    private final AirplaneService airplaneService;

    @Autowired
    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @GetMapping
    public List<Airplane> getAllAirplanes() {
        return airplaneService.getAllAirplanes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airplane> getAirplaneById(@PathVariable Long id) {
        Optional<Airplane> airplane = airplaneService.getAirplaneById(id);
        return airplane.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Airplane> createAirplane(@RequestBody Airplane airplane) {
        return Optional.ofNullable(airplaneService.createAirplane(airplane))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airplane> updateAirplane(@PathVariable Long id, @RequestBody Airplane newAirplane) {
        return Optional.ofNullable(airplaneService.updateAirplane(id, newAirplane))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirplane(@PathVariable Long id) {
        airplaneService.deleteAirplane(id);
        return ResponseEntity.noContent().build();
    }

    public Optional<Airplane> getAirplane(long id) {
        return airplaneService.getAirplaneById(id);
    }
}
