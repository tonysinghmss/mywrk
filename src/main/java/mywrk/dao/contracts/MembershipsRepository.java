package mywrk.dao.contracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mywrk.dao.model.Memberships;


public interface MembershipsRepository extends JpaRepository<Memberships, Long> {

	List<Memberships> findByEmailAddrs(String email);

}
