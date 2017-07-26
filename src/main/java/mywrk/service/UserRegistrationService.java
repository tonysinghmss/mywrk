package mywrk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mywrk.dao.contracts.MembershipsRepository;
import mywrk.dao.contracts.RegistrationRepository;
import mywrk.dao.model.Memberships;
import mywrk.dao.model.Users;
import mywrk.domain.Login;
import mywrk.domain.User;
import mywrk.exception.EmailExistsException;
@Service
public class UserRegistrationService implements UserRegistration {
	
	@Autowired private RegistrationRepository registrationRepository;
	@Autowired private MembershipsRepository membershipsRepository;
	@Autowired private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public Users registerNewUser(User usr) throws EmailExistsException{
		if (emailExist(usr.getEmail())) {  
            throw new EmailExistsException(
              "There is an account with that email adress: "
              +  usr.getEmail());
        }
		String pwdHash = passwordEncoder.encode(usr.getPassword());
		//String pwdSalt = SecurityUtils.getPasswordSalt(usr.getPassword());
		Login login = Login.newinstance()
				.withUserName(usr.getUserName())
				//.withPasswordSalt(pwdSalt)
				.withPasswordHash(pwdHash)
				.build();
		
		return registrationRepository.registerNewUser(usr, login);
	}
	
	private boolean emailExist(String email) {
        List<Memberships> membershipsList = membershipsRepository.findByEmailAddrs(email);
        if (!membershipsList.isEmpty()) {
            return true;
        }
        return false;
    }

}
