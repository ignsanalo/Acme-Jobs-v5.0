
package acme.features.consumer.offer;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.configuration.Configuration;
import acme.entities.offers.Offer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ConsumerOfferRepository extends AbstractRepository {

	@Query("select o from Offer o where o.id = ?1")
	Offer findOneById(int id);

	@Query("select o from Offer o where (o.deadline >= CURRENT_TIMESTAMP())")
	Collection<Offer> findManyAll();

	@Query("select o from Offer o where (o.deadline >= ?1)")
	Collection<Offer> findManyAll(Date c);

	@Query("select c from Configuration c")
	Collection<Configuration> findManyConfiguration();

}
