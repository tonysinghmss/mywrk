package mywrk.dao.contracts;

import org.springframework.data.jpa.repository.JpaRepository;

import mywrk.dao.model.Memberships;


public interface MembershipsRepository extends JpaRepository<Memberships, Long> {

	Memberships findByEmailAddrs(String email);

}
