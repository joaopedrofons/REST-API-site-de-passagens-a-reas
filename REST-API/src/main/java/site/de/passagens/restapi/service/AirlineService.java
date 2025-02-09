package site.de.passagens.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.repository.AirlineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public Optional<Airline> createAirLine(String airlineName) {
        Airline airline = new Airline(airlineName);
        return Optional.ofNullable(save(airline));
    }

    private void validateAirline(Airline airline) {
        if (airline == null) {
            throw new IllegalArgumentException("Airline cannot be null.");
        }
        String name = airline.getName();
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Airline name cannot be null or empty.");
        }
        airline.setName(name.trim());
    }

    public Optional<Airline> findByName(String name) {
        return airlineRepository.findByName(name);
    }

    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    public Airline save(Airline airline) {
        validateAirline(airline);
        return airlineRepository.save(airline);
    }

    public void delete(Airline airline) {
        airlineRepository.delete(airline);
    }

    public Optional<Airline> getAirlineById(long id) {
        return airlineRepository.findById(id);
    }
}
