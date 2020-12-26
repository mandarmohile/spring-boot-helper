package cs.spring.entity.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="Users")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5275147549786082669L;

	@Id
	@Column(name="username", unique=true, nullable=false)
	@EqualsAndHashCode.Include
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="enabled", nullable=false)
	private boolean enabled;
	
	@OneToMany(mappedBy="users", fetch=FetchType.EAGER, orphanRemoval=true, cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Authorities> authoritiesList;
}
