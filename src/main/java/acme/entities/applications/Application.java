
package acme.entities.applications;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "reference")
})
public class Application extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long serialVersionUID = 1L;

	// Attributes -------------------------------------------------------------


	public enum ApplicationStatus {
		PEDING, ACCEPTED, REJECTED
	}


	@Column(unique = true)
	@NotBlank
	@Length(min = 5, max = 15)
	private String	reference;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date	moment;

	@NotBlank
	private String	status;

	@NotBlank
	private String	statement;

	@NotBlank
	private String	skills;

	@NotBlank
	private String	qualifications;

	private String	mandatoryJustification;

	private String	answer;

	@Pattern(regexp = "(^$|^(?=(.*[a-zA-Z].*){2,})(?=(.*\\d.*){2,})(?=(.*\\W.*){2,})[a-zA-Z0-9\\S]{8,}$)") //{2,} = XXXX6 letters, XXXX7 digits, XXXX8 symbols
	private String	password;																		  		//{8,} = XXXX5 characters

	private String	protegido;

	// Relationships ----------------------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Worker	worker;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Job		job;

}
