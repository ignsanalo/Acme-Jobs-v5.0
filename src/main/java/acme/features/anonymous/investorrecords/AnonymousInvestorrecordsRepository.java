
package acme.features.anonymous.investorrecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investorrecords.Investorrecords;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousInvestorrecordsRepository extends AbstractRepository {

	@Query("select a from Investorrecords a where a.id = ?1")
	Investorrecords findOneById(int id);

	@Query("select a from Investorrecords a")
	Collection<Investorrecords> findManyAll();

}
