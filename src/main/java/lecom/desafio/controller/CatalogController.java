package lecom.desafio.controller;

import lecom.desafio.model.Catalog;
import lecom.desafio.repository.CatalogRepository;
import lecom.desafio.service.CatalogService;

import java.util.List;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api-store/getcatalog")
public class CatalogController {
	
	private static final Logger logger = LogManager.getLogger(CatalogController.class.getName());
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private CatalogRepository catalogRepository;
	
	@GetMapping
	public List<Catalog> GetAll() {
		
		return catalogRepository.findAll();
		
		//return ResponseEntity.ok(catalogService.find());
				
	}
	
	
	
	
	

}
