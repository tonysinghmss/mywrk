package mywrk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mywrk.domain.User;
@Service
public class RegistrationService implements Registration {
	
	
	@Override
	public boolean registerUser(User usr) {
		// TODO Generate Login object, Users object
		// TODO Login should have password hash and salt
		return false;
	}

}
