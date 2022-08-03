package lecom.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lecom.desafio.model.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {

}
