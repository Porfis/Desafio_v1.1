package lecom.desafio.service;

import lecom.desafio.model.Carrier;
import lecom.desafio.model.Sale;
import lecom.desafio.model.Store;
import lecom.desafio.repository.SaleRepository;
import lecom.desafio.repository.StoreRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;	
	
	@Autowired
	private SaleRepository saleRepository;
	
//	@Autowired
//	private ItemSaleRepository itemSaleRepository;		
		
	public List<Store> findAll() {
		return storeRepository.findAll();		
	}
	
	public ResponseEntity<Store> findById(long id) {
		Optional<Store> store = storeRepository.findById(id);		
		if (store.isPresent())			
			return new ResponseEntity<Store>(store.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);				
	}
	
	public String GetCatalog() {
		String uri = "http://localhost:8080/api-store/getcatalog"; 
		RestTemplate restTemplate = new RestTemplate();		
		return restTemplate.getForObject(uri, String.class);		
	}
	
	public List<Sale> GetSales() {
		return saleRepository.findAll();		
	}
	
	public Sale PostSale(Sale sale) {
		Long id = sale.getId();
		String deliveryAddress = sale.getDeliveryAddress();
		Optional<Store> store = storeRepository.findById((long) 1);
		String senderAddress = "";
		if (store.isPresent()) 
			senderAddress = store.get().getAddress();
		Carrier carrier = new Carrier();
		carrier.setIdVenda(id);
		carrier.setDeliveryAddress(deliveryAddress);
		carrier.setSenderAddress(senderAddress);	
		carrier.setRasterCode(id+1000);
		String uri = "http://localhost:8080/api-store/carrier";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(uri, carrier, carrier.getClass());
		return saleRepository.save(sale);				
	}
}
