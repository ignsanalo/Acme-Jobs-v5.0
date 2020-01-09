
package acme.features.auditor.job;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select j from Auditrecord a join a.job j where a.job.id = j.id and a.auditor.id= ?1")
	Collection<Job> findManyByAuditorId(int auditorId);

	@Query("select e from Job e where not e.id in (select j from Auditrecord a join a.job j where a.job.id = j.id and a.auditor.id= ?1)")
	Collection<Job> findNotManyByAuditorId(int auditorId);

	@Query("select j from Job j where j.finalMode <= ?1")   //pilla los que no esten en final mode
	Collection<Job> findManyJobByActive(Boolean res);

	@Query("select j from Job j where (j.deadline >= ?1)")
	Collection<Job> findManyJob(Date c);
}
