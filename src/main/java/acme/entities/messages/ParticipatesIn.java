
package acme.entities.messages;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import acme.framework.entities.Authenticated;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ParticipatesIn extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	@Valid
	@ManyToOne(optional = false)
	private Authenticated		participant;

	@Valid
	@ManyToOne(optional = false)
	private MessageThread		thread;

}
