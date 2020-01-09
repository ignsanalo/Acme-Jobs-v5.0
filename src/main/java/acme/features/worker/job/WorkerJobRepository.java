
package acme.features.worker.job;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select j from Job j where (j.deadline >= CURRENT_TIMESTAMP)")
	Collection<Job> findManyJob();

	@Query("select j from Job j where (j.deadline >= ?1)")
	Collection<Job> findManyJob(Date c);

	@Query("select j from Job j where j.finalMode = true and j.deadline >= ?1")
	Collection<Job> findManyAllActive(Date d);
}
