package lecom.desafio.service;

import lecom.desafio.model.Carrier;
import lecom.desafio.repository.CarrierRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CarrierService{
	
	@Autowired
	private CarrierRepository carrierRepository;	
	
	public List<Carrier> findAll(){
		return carrierRepository.findAll();		
	}
	
	public Carrier save(Carrier carrier) {
		return carrierRepository.save(carrier);
	}
	
	public ResponseEntity<Carrier> findByRasterCode(int rasterCode){
		Optional<Carrier> carrier = carrierRepository.findByRasterCode(rasterCode);
		if (carrier.isPresent()) 
			return new ResponseEntity<Carrier>(carrier.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);				
	}
	
}
