package mywrk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mywrk.dao.contracts.RegistrationRepo;
import mywrk.domain.Login;
import mywrk.domain.User;
import mywrk.security.SecurityUtils;
@Service
public class RegistrationService implements Registration {
	
	@Autowired private RegistrationRepo registrationRepo;
	
	@Override
	public boolean registerUser(User usr) {
		String pwdHash = SecurityUtils.getPasswordHash(usr.getPassword());
		String pwdSalt = SecurityUtils.getPasswordSalt(usr.getPassword());
		Login login = Login.newinstance()
				.withUserName(usr.getUserName())
				.withPasswordSalt(pwdSalt)
				.withPasswordHash(pwdHash)
				.build();
		return registrationRepo.registerUser(usr, login);
	}

}
