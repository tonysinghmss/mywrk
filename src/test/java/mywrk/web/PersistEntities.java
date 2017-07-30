package mywrk.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import mywrk.config.PersistenceConfig;
import mywrk.config.WebAppConfig;
import mywrk.dao.contracts.PrivilegesRepository;
import mywrk.dao.contracts.RolesRepository;
import mywrk.dao.contracts.UsersRepository;
import mywrk.dao.model.Privileges;
import mywrk.dao.model.Roles;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={WebAppConfig.class, PersistenceConfig.class})
public class PersistEntities {
	/*@Autowired private UsersRepository usersRepository;
	@Autowired private RolesRepository rolesRepository;*/
	@Autowired private PrivilegesRepository privilegesRepository;
	
	@Test
	@Transactional
	public void savePrivileges(){
		Privileges readPrivileges = new Privileges();
		readPrivileges.setPrivilegeName("ROLE_READ");
		Privileges writePrivileges = new Privileges();
		writePrivileges.setPrivilegeName("ROLE_WRITE");
		privilegesRepository.save(readPrivileges);
		privilegesRepository.save(writePrivileges);
		/*Roles roles = new Roles();
		roles.setRoleName("ADMIN");*/
	}
}
