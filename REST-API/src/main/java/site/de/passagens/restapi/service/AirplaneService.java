package site.de.passagens.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.entity.Airplane;
import site.de.passagens.restapi.repository.AirplaneRepository;

@Service
public class AirplaneService {

    private final AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneService(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    public Airplane createAirplane(String model, int maxCapacity, Airline airline) {
        return airplaneRepository.save(new Airplane(model, maxCapacity, airline));
    }

    public int getTotalCapacity(Airline airline) {
        List<Airplane> airplanes = (List<Airplane>) airplaneRepository.findByAirline(airline);
        return airplanes.stream().mapToInt(Airplane::getMaxCapacity).sum();
    }

	public List<Airplane> getAllAirplanes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Airplane> getAirplaneById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Airplane createAirplane(Airplane airplane) {
		// TODO Auto-generated method stub
		return null;
	}

	public Airplane updateAirplane(Long id, Airplane airplane) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAirplane(Long id) {
		// TODO Auto-generated method stub
		
	}
}