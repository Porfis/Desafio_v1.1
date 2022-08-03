package lecom.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import lecom.desafio.model.Carrier;

public interface CarrierRepository extends JpaRepository<Carrier, Long> {
	
	public Optional<Carrier> findByRasterCode(@Param("rasterCode") int rasterCode);

}
