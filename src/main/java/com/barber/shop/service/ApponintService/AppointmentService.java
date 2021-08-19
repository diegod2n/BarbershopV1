package com.barber.shop.service.ApponintService;

import java.util.List;

import com.barber.shop.model.AddtoAppointment;



public interface AppointmentService {

	List<AddtoAppointment> addAppointmentbyUserId(long userId,long clientId,String date_App,String hour) throws Exception;

	AddtoAppointment save(AddtoAppointment addtoAppointment);

	List<AddtoAppointment> findAll();

	
}
