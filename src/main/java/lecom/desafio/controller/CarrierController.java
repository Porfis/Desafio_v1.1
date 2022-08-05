package lecom.desafio.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lecom.desafio.model.Carrier;
import lecom.desafio.service.CarrierService;

@RestController
@RequestMapping("/api-store/carrier")
public class CarrierController {
	
	private static final Logger logger = LogManager.getLogger(CarrierController.class);
	
	@Autowired
	private CarrierService carrierService;
	
	@GetMapping
	public List<Carrier> GetAll(){
		return carrierService.findAll();		
	}
	
	@RequestMapping(value = "/{rasterCode}", method = RequestMethod.GET)
	public ResponseEntity<Carrier> GetById(@PathVariable(value = "rasterCode") int rasterCode){
		return carrierService.findByRasterCode(rasterCode);				
	}	
	
	@PostMapping
	public Carrier create(@RequestBody Carrier carrier) {
		return carrierService.save(carrier);
	}	
}
