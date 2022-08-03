package lecom.desafio.controller;

import lecom.desafio.model.Carrier;
import lecom.desafio.model.ItemSale;
import lecom.desafio.model.Sale;
import lecom.desafio.model.Store;
import lecom.desafio.repository.ItemSaleRepository;
import lecom.desafio.repository.SaleRepository;
import lecom.desafio.repository.StoreRepository;
import lecom.desafio.service.StoreService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api-store/store")
public class StoreController {
	
	private static final Logger logger = LogManager.getLogger(StoreController.class.getName());	
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private ItemSaleRepository itemSaleRepository;	
		
//	@GetMapping
//	public ResponseEntity<List<Store>> find(){
//		if(storeService.find().toString().equals("")) {
//			return ResponseEntity.notFound().build();			
//		}		
//		logger.info(storeService.find());
//		return ResponseEntity.ok(storeService.find());
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Store> GetAll() {
		return storeRepository.findAll();	
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Store> GetById(@PathVariable(value = "id") long id) {
		Optional<Store> store = storeRepository.findById(id);		
		if (store.isPresent())			
			return new ResponseEntity<Store>(store.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
		
	}
	
	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public String GetCatalog() {
		String uri = "http://localhost:8080/api-store/getcatalog"; 
		RestTemplate restTemplate = new RestTemplate();		
		return restTemplate.getForObject(uri, String.class);		
	}		
	
	@RequestMapping(value = "/sale", method = RequestMethod.GET)
	public List<Sale> GetSales() {
		return saleRepository.findAll();
	}
	
	//@RequestMapping(value = "/sale/{id}", method = RequestMethod.GET)
	//public List<ItemSale> GetItemSales(@PathVariable("id") Long idVenda) {
		//return itemSaleRepository.findByIdVenda(idVenda);
//	}
	
	@RequestMapping(value = "/sale", method = RequestMethod.POST)
	public Sale PostSale(@RequestBody Sale sale) {
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
		String uri = "http://localhost:8080/api-store/carrier";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(uri, carrier, carrier.getClass());
		return saleRepository.save(sale);		
	}	
}
