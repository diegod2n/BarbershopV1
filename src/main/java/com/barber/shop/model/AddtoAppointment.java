package com.barber.shop.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "add_to_appointments")
public class AddtoAppointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	Long user_id;
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "client_id")
	Client client;
	
    String date_App;
    
    String hour;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getClient() {
		return String.valueOf(client.id);
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getDate_App() {
		return date_App;
	}

	public void setDate_App(String date_App) {
		this.date_App = date_App;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}


    
    

}
