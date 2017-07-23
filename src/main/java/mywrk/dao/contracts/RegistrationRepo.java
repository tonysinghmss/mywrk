package mywrk.dao.contracts;

import mywrk.dao.model.Memberships;
import mywrk.dao.model.Users;
import mywrk.domain.Login;
import mywrk.domain.User;

public interface RegistrationRepo {
	Users registerNewUser(User usr, Login login);
	Memberships findByEmail(String email);
}
