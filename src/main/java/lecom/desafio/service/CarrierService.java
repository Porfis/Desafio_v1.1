package lecom.desafio.service;

import lecom.desafio.factory.CarrierFactory;
import lecom.desafio.factory.Impl.CarrierFactoryImpl;
import lecom.desafio.model.Carrier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CarrierService{
	
	private CarrierFactory factory;
	private List<Carrier> carriers;
	
	private String parseId(JSONObject carrier) {
		return carrier.get("orderId").toString();
	}
	
	private String parseSenderAddress(JSONObject carrier) {
		return carrier.get("senderAddress").toString();
	}
	
	private String parseDeliveryAddress(JSONObject carrier) {
		return carrier.get("deliveryAddress").toString();
	}	
	
	private String parseRasterCode(JSONObject carrier) {
		return carrier.get("rasterCode").toString();
	}
	
	private String parseStatus(JSONObject carrier) {
		return carrier.get("status").toString();		
	}	
	
	private void setCarrierValues(JSONObject jsonCarrier, Carrier carrier) {
//		carrier.setOrderId(jsonCarrier.get("orderId") != null ? parseId(jsonCarrier) : carrier.getOrderId());
		carrier.setSenderAddress(jsonCarrier.get("senderAddress") != null ? parseSenderAddress(jsonCarrier) : carrier.getSenderAddress());
		carrier.setDeliveryAddress(jsonCarrier.get("deliveryAddress") != null ? parseDeliveryAddress(jsonCarrier) : carrier.getDeliveryAddress());
//		carrier.setRasterCode(jsonCarrier.get("rasterCode") != null ? parseRasterCode(jsonCarrier) : carrier.getRasterCode());
		carrier.setStatus(jsonCarrier.get("status") != null ? parseStatus(jsonCarrier) : carrier.getStatus());		
	}
	
	public void createFactory() {
		if (factory == null) {
			factory = new CarrierFactoryImpl();
		}
	}
	
	public void createCarrierList() {
		if (carriers == null) {
			carriers = new ArrayList<>();			
		}
	}	
	
	public boolean isJsonValid(String jsonInString) {
		try {			
			return (new ObjectMapper().readTree(jsonInString) != null);
		} catch (IOException e) {			
			return false;
		}		
	}
	
	public void add(Carrier carrier) {
		createCarrierList();
		carriers.add(carrier);
	}
		
	public Carrier create(JSONObject jsonCarrier) {		
		createFactory();		
		Carrier carrier = factory.createCarrier((String) jsonCarrier.get("type"));
//		carrier.setOrderId(parseId(jsonCarrier));		
		setCarrierValues(jsonCarrier, carrier);		
		return carrier;				
	}
	
}
