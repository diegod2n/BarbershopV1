package com.barber.shop.service.ApponintService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barber.shop.Repository.AddtoAppointmentRepo;
import com.barber.shop.Repository.ClientRepo;
import com.barber.shop.model.AddtoAppointment;
import com.barber.shop.model.Client;

@Service
public class AppointmentServiceImpl implements AppointmentService {
   
	@Autowired
	AddtoAppointmentRepo addtoApprepo;
	
    @Autowired
    ClientRepo clientrepo;
	
    private static final Logger logger = LoggerFactory.getLogger(AppointmentServiceImpl.class);
  
	@Override
	public List<AddtoAppointment> addAppointmentbyUserId(long userId, long clientId, String date_App, String hour)
			throws Exception {
		try {
		 AddtoAppointment appointment= new AddtoAppointment();
		 Client client = new Client();/*clientrepo.finbyIdClient(clientId);*/
		 appointment.setClient(client);
		 appointment.setUser_id(userId);
		 appointment.setDate_App(date_App);
		 appointment.setHour(hour);
		 addtoApprepo.save(appointment);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(""+e.getMessage());
			throw new Exception(e.getMessage());
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public AddtoAppointment save(AddtoAppointment addtoAppointment) {
		
		return addtoApprepo.save(addtoAppointment);
	}

	@Override
	public List<AddtoAppointment> findAll() {
		return addtoApprepo.findAll();
	}


}
