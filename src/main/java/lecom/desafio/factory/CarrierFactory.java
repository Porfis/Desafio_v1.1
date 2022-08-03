package lecom.desafio.factory;

import lecom.desafio.model.Carrier;

public interface CarrierFactory {
	
	Carrier createCarrier (String type);

}
