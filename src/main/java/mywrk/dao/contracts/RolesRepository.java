package mywrk.dao.contracts;

import mywrk.dao.model.Roles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
	Roles findByRoleName(String roleName);
}
