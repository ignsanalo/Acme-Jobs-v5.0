
package acme.features.employer.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.configuration.Configuration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerApplicationRepository extends AbstractRepository {

	@Query("select a from Application a where a.job.id = ?1")
	Collection<Application> findManyByJobId(int id);

	@Query("select a from Application a where a.id=?1")
	Application findOneApplicationById(int id);

	@Query("select c from Configuration c")
	Collection<Configuration> findManyConfiguration();

}
