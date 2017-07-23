package mywrk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mywrk.dao.contracts.UsersRepository;
import mywrk.dao.model.Logins;
import mywrk.dao.model.Users;

@Service
@Transactional
public class MyWrkUserDetailsService implements UserDetailsService {
  
    @Autowired
    private UsersRepository usersRepository;
    // 
    public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
  
    	Users user = usersRepository.findByUserName(username);
    	Logins login = user.getLoginses().stream()
    			.filter(l -> l.getUserName().equalsIgnoreCase(username))
    			.findAny()
    			.orElse(null);
    	//TOOD:Fetch all role names from membership
    	List<String> roles = null;//user.getMembershipses();
    			
        if (user == null) {
            throw new UsernameNotFoundException(
              "No user found with username: "+ username);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return  new org.springframework.security.core.userdetails.User
          (username, 
          login.getPasswordHash().toLowerCase(), enabled, accountNonExpired, 
          credentialsNonExpired, accountNonLocked, 
          getAuthorities(roles));
    }
     
    private static List<GrantedAuthority> getAuthorities (List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
