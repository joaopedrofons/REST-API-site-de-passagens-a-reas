package site.de.passagens.restapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import site.de.passagens.restapi.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
   
    List<Passenger> findByName(String name);

    
    List<Passenger> findByPassportNumber(String passportNumber);

    
    List<Passenger> findByCpf(String cpf);

   
    List<Passenger> findByRg(String rg);


	Optional<Passenger> findById(Long id);
}