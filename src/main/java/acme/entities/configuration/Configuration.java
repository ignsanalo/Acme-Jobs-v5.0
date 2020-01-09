
package acme.entities.configuration;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "spamWords")
})
public class Configuration extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				spamWords;

	@Range(min = 0, max = 1)
	@Digits(integer = 1, fraction = 2)
	private Double				spamThreshold;


	public Boolean isSpam(final String s) {
		Boolean res = false;
		
		Double contador=0.00;

		String[] palabrasMalas = this.spamWords.split(",");
		for(int i=0;i<palabrasMalas.length; i++) {
			if(s.contains(palabrasMalas[i])) {
				contador++;
			}
		}
		
		 int tam = s.length();
		 
		 Double porcen = contador/tam*100;
		 
		 if(porcen > this.spamThreshold) {
			 res = true;
		 }
		
			
		
		return res;
	}

}
