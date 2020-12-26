package cs.spring.entity.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@Data
@EqualsAndHashCode
public class AuthoritiesPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2007874081728624173L;

	@Column(name="username", insertable = false, updatable = false, nullable = false)
	private String username;
	
	@Column(name="authority")
	private String authority;
	
}
