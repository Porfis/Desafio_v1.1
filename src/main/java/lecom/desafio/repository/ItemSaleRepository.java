package lecom.desafio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import lecom.desafio.model.ItemSale;

public interface ItemSaleRepository extends JpaRepository<ItemSale, Long>{
	
	//public List<ItemSale> findByIdVenda(@Param("idVenda") Long idvenda);
	
	//public List<ItemSale> saveAll(@Param("items") List<ItemSale> itemsSale);

}
