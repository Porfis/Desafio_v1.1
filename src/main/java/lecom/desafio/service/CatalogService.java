package lecom.desafio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lecom.desafio.model.Catalog;

@Service
public class CatalogService {
	
	private List<Catalog> catalogs;
	private Catalog catalog;
	
	public void createCatalogList() {
		if (catalogs == null) {
			catalogs = new ArrayList<>();
//			catalog = new Catalog();
//			catalog.setCategory("Alimentos");
//			catalog.setName("Biscoito Óreo 80g");
//			catalog.setValue(5.19);
//			catalogs.add(catalog);	
//			catalog = new Catalog();
//			catalog.setCategory("Vestuário");
//			catalog.setName("Calça jeans M adulto feminino");
//			catalog.setValue(149.9);
//			catalogs.add(catalog);	
		}		
	}	
		
	public List<Catalog> find(){
		createCatalogList();
		return catalogs;		
	}	

}
