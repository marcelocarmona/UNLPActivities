package ttps.model;

import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {
	ADMIN,MODERATOR,STUDENT,GUEST;

	@Override
	public String getAuthority() {
		return name();
	}

}
