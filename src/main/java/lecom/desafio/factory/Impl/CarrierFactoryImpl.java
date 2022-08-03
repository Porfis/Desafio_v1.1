package lecom.desafio.factory.Impl;

import lecom.desafio.factory.CarrierFactory;
import lecom.desafio.model.Carrier;

public class CarrierFactoryImpl implements CarrierFactory {
	
	@Override
	public Carrier createCarrier (String type) {						
		return new Carrier();		
	}
	

}
