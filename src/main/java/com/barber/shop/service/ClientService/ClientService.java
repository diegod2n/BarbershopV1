package com.barber.shop.service.ClientService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barber.shop.Repository.ClientRepo;
import com.barber.shop.model.Client;
@Service
public class ClientService {
	
	@Autowired
	ClientRepo clientRepo;
	
	
	public List<Client> getAllClient(){
		return clientRepo.findAll();
	}

	public List<Client>getCliensByDeleted(Boolean deleted){
		return clientRepo.getByDeleted(deleted);
	}
	/*
	public List<Client>getCliensByName(String nameorsurname){
		return clientRepo.getByName(nameorsurname);
	}
*/
	public Client saveClient(Client client) {
		return clientRepo.save(client);
	}
	
	public Client findEmailClient(String email) {
		return clientRepo.findByEmail(email);
	}

	public Client updateClients(Client client) {
		// TODO Auto-generated method stub
		return clientRepo.save(client);
	}
	
	public Client findByClientid(Client client) {
		return clientRepo.finbyIdClient(client.getId());
	}

	public void deleted(Client client) {
		// TODO Auto-generated method stub
		clientRepo.delete(client);
	}
  
}
