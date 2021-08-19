package com.barber.shop.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber.shop.JWTConfiguration.ShoppingConfiguration;
import com.barber.shop.controller.RequestPojo.ApiResponse;
import com.barber.shop.model.AddtoAppointment;
import com.barber.shop.model.Client;
import com.barber.shop.service.ApponintService.AppointmentService;

@RestController
@RequestMapping("api/addtoappointment")
public class AddtoAppointmentController {
	
	@Autowired
	AppointmentService  appointmentService;
	@RequestMapping("addAppointment")
  	public ResponseEntity<?> addCartwithProduct(@RequestBody HashMap<String,String> addappointmentRequest) {
		try {
			String keys[] = {"user_id","clientId","date_App","hour"};
			if(ShoppingConfiguration.validationWithHashMap(keys, addappointmentRequest)) {
				
			}
			long clientId = Long.parseLong(addappointmentRequest.get("clientId")); 
			long userId =  Long.parseLong(addappointmentRequest.get("user_id")); 
			String date_App =addappointmentRequest.get("date_App"); 
			String hour = addappointmentRequest.get("hour");
		    Client client =new Client();
		    client.setId(clientId);
			AddtoAppointment addtoAppointment= new AddtoAppointment();
			addtoAppointment.setUser_id(userId);
			addtoAppointment.setClient(client);
			addtoAppointment.setDate_App(date_App);
			addtoAppointment.setHour(hour);
			
			 AddtoAppointment addappointmentRequest1 = appointmentService.save(addtoAppointment);
			//List<AddtoCart> obj = cartService.addCartbyUserIdAndProductId(productId,userId,qty,price);
			//List<com.barber.shop.model.AddtoAppointment> appointments = addtoapp.save(addappointmentRequest);
			return ResponseEntity.ok(addappointmentRequest1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
		
   }
	
	
	@RequestMapping("getAll")
	public List<AddtoAppointment> getAllApps(){
		return appointmentService.findAll();
	}
	
	
/*	
	@RequestMapping("updateApp")
	public ResponseEntity<AddtoAppointment> updateApp(@RequestBody AddtoAppointment addtoAppointment) {
		AddtoAppointment appointment= appointmentService.updateApponintment(addtoAppointment);
		return new ResponseEntity<>(appointment,HttpStatus.CREATED);
	}
	
	*/
}
