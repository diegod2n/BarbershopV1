package com.barber.shop.service.UserServices;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.barber.shop.model.User;

@Service
public interface UserService {
	User findByMobile(String mobile) throws Exception;
	User getUserDetailById(long userId) throws Exception;
	User signUpUser(HashMap<String,String> signupRequest) throws Exception;
	User findByEmail(String email) throws Exception;;
	
}
