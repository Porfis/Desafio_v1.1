package lecom.desafio.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.*;

import lecom.desafio.model.Carrier;
import lecom.desafio.repository.CarrierRepository;
import lecom.desafio.service.CarrierService;

@RestController
@RequestMapping("/api-store/carrier")
public class CarrierController {
	
	private static final Logger logger = LogManager.getLogger(CarrierController.class);
	
	@Autowired
	private CarrierService carrierService;
	
	@Autowired
	private CarrierRepository carrierRepository;
	
	@GetMapping
	public List<Carrier> GetAll(){
		return carrierRepository.findAll();		
	}
	
//  RequestMapping(value = "/{id}", method = RequestMethod.GET)
//  public ResponseEntity<Carrier> GetById(@PathVariable(value = "id") long id){
//		Optional<Carrier> carrier = carrierRepository.findById(id);
//		if (carrier.isPresent()) 
//			return new ResponseEntity<Carrier>(carrier.get(), HttpStatus.OK);
//		else
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
//	}
	
	@RequestMapping(value = "/{rasterCode}", method = RequestMethod.GET)
	public ResponseEntity<Carrier> GetById(@PathVariable(value = "rasterCode") int rasterCode){
		Optional<Carrier> carrier = carrierRepository.findByRasterCode(rasterCode);
		if (carrier.isPresent()) 
			return new ResponseEntity<Carrier>(carrier.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
	}	
	
	@PostMapping
	public Carrier create(@RequestBody Carrier carrier) {
		return carrierRepository.save(carrier);
	}
	
//	@PostMapping
//	@ResponseBody
//	public ResponseEntity<Carrier> create(@RequestBody JSONObject carrier) {
//		try {
//			if(carrierService.isJsonValid(carrier.toString())) {				
//				Carrier carrierCreated = carrierService.create(carrier); 
//				var uri = ServletUriComponentsBuilder.fromCurrentRequest().path(carrierCreated.getOrderId()).build().toUri();
//								
//				carrierService.add(carrierCreated);
//				return ResponseEntity.created(uri).body(null);							
//			}
//			else {
//				return ResponseEntity.badRequest().body(null);
//			}
//			
//		}catch (Exception e) {
//			logger.error("Json fields are not parsable."+e);
//			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
//		}
//	}
}
