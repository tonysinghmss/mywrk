package mywrk.dao.contracts;

import org.springframework.data.jpa.repository.JpaRepository;

import mywrk.dao.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	Users findByUserName(String userName);
}
