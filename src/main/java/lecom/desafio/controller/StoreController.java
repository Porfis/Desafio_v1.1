package lecom.desafio.controller;

import lecom.desafio.model.Sale;
import lecom.desafio.model.Store;
import lecom.desafio.service.StoreService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-store/store")
public class StoreController {
	@Autowired
	private StoreService storeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Store> GetAll() {
		return storeService.findAll();	
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Store> GetById(@PathVariable(value = "id") long id) {
		return storeService.findById(id);	
	}
	
	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public String GetCatalog() {
		return storeService.GetCatalog();
	}		
	
	@RequestMapping(value = "/sale", method = RequestMethod.GET)
	public List<Sale> GetSales() {
		return storeService.GetSales();
	}
	
	@RequestMapping(value = "/sale", method = RequestMethod.POST)
	public Sale PostSale(@RequestBody Sale sale) {
		return storeService.PostSale(sale);
	}	
}
