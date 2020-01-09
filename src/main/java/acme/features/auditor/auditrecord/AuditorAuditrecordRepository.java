
package acme.features.auditor.auditrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditrecords.Auditrecord;
import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditrecordRepository extends AbstractRepository {

	@Query("select a from Auditrecord a where a.id = ?1")  //encuentra 1 auditRecord segun un id
	Auditrecord findOneAuditrecordById(int id);

	@Query("select a from Auditrecord a where a.job.id = ?1")  //encuentra auditRecords segun un job
	Collection<Auditrecord> findManyByJobId(int jobID);

	@Query("select a from Auditrecord a where a.auditor.id = ?1")  //encuentra  1 auditRecords segun un auditor
	Auditrecord findOneByAuditorId(int auditorId);

	@Query("select a from Auditor a where a.id =?1")    //encuentra un auditor segun su id
	Auditor findOneAuditorById(int auditorId);

	@Query("select a from Auditrecord a where a.finalMode <= ?1")   //pilla los auditRecord que no esten en final mode
	Collection<Auditrecord> findManyAuditByActive(Boolean res);

	@Query("select j from Job j where j.id = ?1")            //pilla job segun su id
	Job findOneJobById(int id);

}
