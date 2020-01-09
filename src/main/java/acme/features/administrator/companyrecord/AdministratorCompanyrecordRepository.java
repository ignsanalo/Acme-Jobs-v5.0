
package acme.features.administrator.companyrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.companyrecords.Companyrecord;
import acme.entities.configuration.Configuration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorCompanyrecordRepository extends AbstractRepository {

	@Query("select a from Companyrecord a where a.id = ?1")
	Companyrecord findOneById(int id);

	@Query("select a from Companyrecord a")
	Collection<Companyrecord> findManyAll();

	@Query("select c from Configuration c")
	Collection<Configuration> findManyConfiguration();
}
