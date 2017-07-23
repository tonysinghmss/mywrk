package mywrk.service;

import mywrk.dao.model.Users;
import mywrk.domain.User;
import mywrk.exception.EmailExistsException;

public interface Registration {
	Users registerNewUser(User usr) throws EmailExistsException;
}
