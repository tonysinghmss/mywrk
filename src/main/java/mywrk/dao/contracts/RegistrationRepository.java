package mywrk.dao.contracts;

import mywrk.dao.model.Users;
import mywrk.domain.Login;
import mywrk.domain.User;

public interface RegistrationRepository {
	Users registerNewUser(User usr, Login login);
}
