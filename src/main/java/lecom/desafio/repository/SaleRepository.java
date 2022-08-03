package lecom.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lecom.desafio.model.Sale;
import lecom.desafio.serializable.SaleId;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
