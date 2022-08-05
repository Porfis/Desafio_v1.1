package lecom.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lecom.desafio.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
