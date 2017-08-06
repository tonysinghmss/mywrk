package mywrk.web;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mywrk.dao.contracts.PrivilegesRepository;
import mywrk.dao.contracts.RolesRepository;
import mywrk.dao.contracts.UsersRepository;
import mywrk.dao.model.Logins;
import mywrk.dao.model.Memberships;
import mywrk.dao.model.Privileges;
import mywrk.dao.model.Roles;
import mywrk.dao.model.RolesPrivileges;
import mywrk.dao.model.Users;

@Component
public class InitialDataLoader implements
  ApplicationListener<ContextRefreshedEvent> {
 
    boolean alreadySetup = false;
 
    @Autowired
    private UsersRepository usersRepository;
  
    @Autowired
    private RolesRepository rolesRepository;
  
    @Autowired
    private PrivilegesRepository privilegesRepository;
  
    @Autowired
    private PasswordEncoder passwordEncoder;
  
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
  
        if (alreadySetup)
            return;
        Privileges readPrivilege
          = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privileges writePrivilege
          = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
  
        List<Privileges> adminPrivileges = Arrays.asList(
          readPrivilege, writePrivilege);        
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
 
        Roles adminRole = rolesRepository.findByRoleName("ROLE_ADMIN");
        Users user = new Users();
        Logins login = new Logins();
		Memberships membership = new Memberships();
        user.setFirstName("Admin");
        user.setLastName("User");
        user.setEnabled(true);
        login.setUserName("admin");
        login.setPasswordHash(passwordEncoder.encode("admin"));
        login.setUsers(user);
        membership.setEmailAddrs("admin@mywrk.com");        
        membership.setRoles(adminRole);
        usersRepository.save(user);
        alreadySetup = true;
    }
 
    @Transactional
    private Privileges createPrivilegeIfNotFound(String name) {
  
        Privileges privilege = privilegesRepository.findByPrivilegeName(name);
        if (privilege == null) {
            privilege = new Privileges(name);
            privilegesRepository.save(privilege);
        }
        return privilege;
    }
 
    @Transactional
    private Roles createRoleIfNotFound(
      String name, Collection<Privileges> privileges) {
        Roles role = rolesRepository.findByRoleName(name);        
        if (role == null) {
            role = new Roles(name);
            Set<RolesPrivileges> rlsprivSet = new HashSet<>(0);            
            for(Privileges prv : privileges){        		
            		RolesPrivileges rlsPriv = new RolesPrivileges();
            		rlsPriv.setRoles(role);
            		rlsPriv.setPrivileges(prv);
            		rlsprivSet.add(rlsPriv);
            }
            role.setRolesprivilegeses(rlsprivSet);
            rolesRepository.save(role);
        }
        return role;
    }
}
