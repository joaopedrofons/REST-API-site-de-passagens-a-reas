package site.de.passagens.REST.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.de.passagens.REST.API.entity.Airplane;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
