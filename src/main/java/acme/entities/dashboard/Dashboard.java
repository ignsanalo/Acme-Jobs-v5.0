
package acme.entities.dashboard;

import javax.persistence.Entity;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Dashboard extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	private Float				jobsRatio;

	private Float				answerRatio;

	private Float				protectedRatio;

}
