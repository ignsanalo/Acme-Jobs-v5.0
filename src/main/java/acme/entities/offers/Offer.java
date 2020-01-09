
package acme.entities.offers;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "deadline")
})
public class Offer extends DomainEntity {

	//Attributes ------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				deadline;

	@NotBlank
	private String				text;

	@NotNull
	@Valid
	private Money				moneyMin;

	@NotNull
	@Valid
	private Money				moneyMax;

	@Pattern(regexp = "^[O]{1}[A-Z]{4}\\-[0-9]{5}$")
	@NotBlank
	@Valid
	private String				ticker;

	// Derived attributes -----------------------------------------------------------------

	// Relationships ----------------------------------------------------------------------

}
