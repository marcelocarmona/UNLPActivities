package ttps.model;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority{
	ADMIN,MODERATOR,STUDENT,;

	@Override
	public String getAuthority() {
		return toString();
	}
}
