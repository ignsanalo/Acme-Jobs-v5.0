
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.configuration.Configuration;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select j from Job j where j.employer.id = ?1")
	Collection<Job> findManyByEmployerId(int employerId);

	@Query("select sum(d.percentage) from Duty d where d.job.id = ?1")
	Double sumOfPercentagesDuty(int id);

	@Query("select sum(a) from Application a where a.job.id = ?1")
	Double sumOfApplication(int id);

	@Query("select e from Employer e where e.id = ?1")
	Employer findOneEmployerById(int employerId);

	@Query("select c from Configuration c")
	Collection<Configuration> findManyConfiguration();

}
