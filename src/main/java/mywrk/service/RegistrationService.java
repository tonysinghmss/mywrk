package mywrk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mywrk.dao.contracts.RegistrationRepo;
import mywrk.dao.model.Memberships;
import mywrk.dao.model.Users;
import mywrk.domain.Login;
import mywrk.domain.User;
import mywrk.exception.EmailExistsException;
import mywrk.security.SecurityUtils;
@Service
public class RegistrationService implements Registration {
	
	@Autowired private RegistrationRepo registrationRepo;
	
	@Override
	@Transactional
	public Users registerNewUser(User usr) throws EmailExistsException{
		if (emailExist(usr.getEmail())) {  
            throw new EmailExistsException(
              "There is an account with that email adress: "
              +  usr.getEmail());
        }
		String pwdHash = SecurityUtils.getPasswordHash(usr.getPassword());
		String pwdSalt = SecurityUtils.getPasswordSalt(usr.getPassword());
		Login login = Login.newinstance()
				.withUserName(usr.getUserName())
				.withPasswordSalt(pwdSalt)
				.withPasswordHash(pwdHash)
				.build();
		return registrationRepo.registerNewUser(usr, login);
	}
	
	private boolean emailExist(String email) {
        Memberships memberships = registrationRepo.findByEmail(email);
        if (memberships != null) {
            return true;
        }
        return false;
    }

}
