package lecom.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lecom.desafio.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long>{
	
}
	