package com.barber.shop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber.shop.model.Client;
import com.barber.shop.service.ClientService.ClientService;



@RestController
@RequestMapping("api/client")
public class ClientController {

	@Autowired
	ClientService clientService;
	
	
	@RequestMapping("getAll")
	public List<Client> getAllClients(){
		return clientService.getAllClient();
	}
	@RequestMapping("getClientsBydeleted/{request}")
	public List<Client> getClientsByDeleted(@PathVariable("request") Boolean request){
		System.out.println(request);
		boolean deleted = Boolean.valueOf(request);	
		return clientService.getCliensByDeleted(deleted);
	}
	/*
	@RequestMapping("getClientsByNameorSurname")
	public List<Client> getClientsByNameorSurname(@RequestBody Boolean request){
		boolean deleted = request.booleanValue();	
		return clientService.getProductsByCategory(deleted);
	}
	
*/
	@RequestMapping("saveClient")
	public Client saveClient(@RequestBody Client client) {
		Client client2= new Client();
		client2.setName(client.getName());
		client2.setSurname(client.getSurname());
		client2.setEmail(client.getEmail());
		client2.setIs_email_verified(client.getIs_email_verified());
		client2.setMobile(client.getMobile());
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date = simpleDateFormat.format(new Date());
		client2.setCreated_at(date);
		client2.setDeleted(false);
		return clientService.saveClient(client2);
	} 
	
	@PutMapping("updateClient")
	public ResponseEntity<Client>  updateClient(@RequestBody Client client) {
		Client client2= clientService.findByClientid(client);
		System.out.println(client2.getName() +""+client2.getSurname());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date = simpleDateFormat.format(new Date());
		client2.setCreated_at(date);
		client2.setDeleted(true);
		Client updateClients= clientService.updateClients(client);
		return new ResponseEntity<>(updateClients,HttpStatus.CREATED);
	} 
	@DeleteMapping("deletedClient")
	public ResponseEntity<Client>  deletedClient(@RequestBody Client client) {
		
		 clientService.deleted(client);
		return new ResponseEntity<>(HttpStatus.OK);
	} 
}
