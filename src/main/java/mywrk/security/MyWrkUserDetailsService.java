package mywrk.security;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mywrk.dao.contracts.MembershipsRepository;
import mywrk.dao.contracts.UsersRepository;
import mywrk.dao.model.Logins;
import mywrk.dao.model.Memberships;
import mywrk.dao.model.Roles;
import mywrk.dao.model.Users;

@Service
@Transactional
public class MyWrkUserDetailsService implements UserDetailsService {
  
    @Autowired
    private UsersRepository usersRepository;
    @Autowired private MembershipsRepository membershipsRepository;
    // 
    public UserDetails loadUserByUsername(String email)
      throws UsernameNotFoundException {
        List<Memberships> membershipsList = membershipsRepository.findByEmailAddrs(email);
        Users user = membershipsList.get(0).getUsers();
    	Logins login = user.getLogins();
    	List<Roles> roles = membershipsList.stream()
    		.map(t -> t.getRoles())
    		.collect(Collectors.toList());
    			
        if (user == null) {
            throw new UsernameNotFoundException(
              "No user found with username: "+email);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return  new org.springframework.security.core.userdetails.User
          (email, 
          login.getPasswordHash(), enabled, accountNonExpired, 
          credentialsNonExpired, accountNonLocked, 
          getAuthorities(roles));
    }
    private List<GrantedAuthority> getAuthorities (List<Roles> rolesList) {
    	return getGrantedAuthorities(getPrivileges(rolesList));
    }
    private List<String> getPrivileges(List<Roles> roles){
    	//Spring's Role is equivalent to our application Privilege.
    	//By default each privilege( Spring's role) has a prefix "ROLE_".
    	return roles.stream()
    			.flatMap(rl -> rl.getRolesprivilegeses().stream())
    			.map(rp -> rp.getPrivileges().getPrivilegeName())
    			.collect(Collectors.toList());
    }
    private List<GrantedAuthority> getGrantedAuthorities (List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
