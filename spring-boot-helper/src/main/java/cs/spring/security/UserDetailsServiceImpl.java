package cs.spring.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cs.spring.entity.jpa.Users;
import cs.spring.services.DataService;

@Service
@Qualifier("JavaBrainsUserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

	private DataService dataService;
	private PasswordEncoder passwordEncoder;

	public UserDetailsServiceImpl(DataService pDataService, PasswordEncoder passwordEncoder) {
		this.dataService = pDataService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		Users lUsersEntity = dataService.getUser(username);

		Collection<? extends GrantedAuthority> lCollection = lUsersEntity.getAuthoritiesList().stream()
				.map(authority -> new SimpleGrantedAuthority(authority.getId().getAuthority()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(lUsersEntity.getUsername(), passwordEncoder.encode(lUsersEntity.getPassword()), lUsersEntity.isEnabled(),
				lCollection);
	}

}
