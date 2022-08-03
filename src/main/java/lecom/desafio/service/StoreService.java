package lecom.desafio.service;

import lecom.desafio.model.Store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StoreService {
	
	private List<Store> stores;
	private Store store;
	
	public void createStoreList() {
		if (stores == null) {
			stores = new ArrayList<>();		
		}
	}
	
	public List<Store> find(){	
		createStoreList();		
		return stores; 
	}

}
