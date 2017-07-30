package mywrk.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mywrk.dao.contracts.LoginsRepository;
import mywrk.dao.contracts.MembershipsRepository;
import mywrk.dao.contracts.RegistrationRepository;
import mywrk.dao.contracts.RolesRepository;
import mywrk.dao.contracts.UsersRepository;
import mywrk.dao.model.Logins;
import mywrk.dao.model.Memberships;
import mywrk.dao.model.Users;
import mywrk.domain.Login;
import mywrk.domain.User;

@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository {
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private LoginsRepository loginsRepository;
	@Autowired
	private MembershipsRepository membershipsRepository;
	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public Users registerNewUser(User usr, Login login) {
		Users users = new Users();
		Logins logins = new Logins();
		Memberships memberships = new Memberships();
		users.setFirstName(usr.getFirstName());
		String lastName = usr.getLastName();
		if (lastName != null && !lastName.isEmpty()) {
			users.setLastName(lastName);
		}
		String usrName = login.getUserName();
		String email = usr.getEmail();
		if (usrName != null && !usrName.isEmpty()) {
			users.setUserName(usrName);
			logins.setUserName(usrName);
		} else if (email != null && !email.isEmpty()) {
			users.setUserName(email);
			logins.setUserName(email);
		}
		logins.setPasswordHash(login.getPasswordHash());
		//loginsRepository.save(logins);
		users.setLogins(logins);
		//usersRepository.save(users);
		logins.setUsers(users);
		memberships.setEmailAddrs(email);
		memberships.setUsers(users);
		memberships.setRoles(rolesRepository.findByRoleName("ROLE_USER"));
		//membershipsRepository.save(memberships);
		return users;
	}

}
