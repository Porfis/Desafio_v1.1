package lecom.desafio.controller;

import lecom.desafio.model.Catalog;
import lecom.desafio.service.CatalogService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api-store/getcatalog")
public class CatalogController {
		
	@Autowired
	private CatalogService catalogService;
	
	@GetMapping
	public List<Catalog> GetAll() {		
		return catalogService.findAll();				
	}
}
