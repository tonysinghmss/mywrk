package mywrk.dao.contracts;

import mywrk.domain.Login;
import mywrk.domain.User;

public interface RegistrationRepo {
	boolean registerUser(User usr, Login login);
}
