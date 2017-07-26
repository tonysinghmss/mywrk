package mywrk.service;

import mywrk.dao.model.Users;
import mywrk.domain.User;
import mywrk.exception.EmailExistsException;

public interface UserRegistration {
	Users registerNewUser(User usr) throws EmailExistsException;
}
