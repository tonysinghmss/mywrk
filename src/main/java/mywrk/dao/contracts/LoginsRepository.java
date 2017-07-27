package mywrk.dao.contracts;

import mywrk.dao.model.Logins;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginsRepository extends JpaRepository<Logins, Long> {

}
