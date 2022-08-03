package lecom.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lecom.desafio.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long>{
	
}
	