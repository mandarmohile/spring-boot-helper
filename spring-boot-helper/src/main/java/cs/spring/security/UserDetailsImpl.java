package cs.spring.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4345525453306698679L;
	
	private String username;
	private String password;
	private boolean enabled;
	private Collection<? extends GrantedAuthority> authoritiesList;

	public UserDetailsImpl(String pUserName, String pPassword, 
			boolean pEnabled, Collection<? extends GrantedAuthority> authorities) {
		username = pUserName;
		password = pPassword;
		enabled = pEnabled;
		authoritiesList = authorities;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authoritiesList;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
