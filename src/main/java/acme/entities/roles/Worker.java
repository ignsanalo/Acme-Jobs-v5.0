
package acme.entities.roles;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "qualifications")
})
public class Worker extends UserRole {

	//Serialization identifier --------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes ----------------------------------------------------------------------

	@NotBlank
	private String				qualifications;

	@NotBlank
	private String				skills;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
