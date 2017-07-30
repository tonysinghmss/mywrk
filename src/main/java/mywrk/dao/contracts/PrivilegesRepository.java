package mywrk.dao.contracts;

import org.springframework.data.jpa.repository.JpaRepository;

import mywrk.dao.model.Privileges;

public interface PrivilegesRepository extends JpaRepository<Privileges, Long> {
	
}
