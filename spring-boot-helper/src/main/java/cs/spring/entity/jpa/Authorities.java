package cs.spring.entity.jpa;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="Authorities")
@Data
public class Authorities implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6739637500116286757L;
	
	@EmbeddedId
	private AuthoritiesPK id;
	
	@ManyToOne
	@MapsId("username")
	@JoinColumn(name="username", nullable=false, insertable=false, updatable=false)
	@JsonManagedReference
	private Users users;
}
