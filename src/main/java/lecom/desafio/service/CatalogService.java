package lecom.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lecom.desafio.model.Catalog;
import lecom.desafio.repository.CatalogRepository;

@Service
public class CatalogService {
	
	@Autowired
	private CatalogRepository catalogRepository;	
		
	public List<Catalog> findAll(){
		return catalogRepository.findAll();		
	}

}
