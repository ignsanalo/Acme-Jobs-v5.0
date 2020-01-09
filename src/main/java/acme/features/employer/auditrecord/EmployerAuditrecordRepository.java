
package acme.features.employer.auditrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditrecords.Auditrecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerAuditrecordRepository extends AbstractRepository {

	@Query("select a from Auditrecord a where a.id = ?1")
	Auditrecord findOneAuditById(int id);

	@Query("select a from Auditrecord a where a.job.id = ?1")
	Collection<Auditrecord> findManyByJobId(int JobID);

	@Query("select a from Auditrecord a where a.finalMode <= ?1")   //pilla los que no esten en final mode
	Collection<Auditrecord> findManyAuditByActive(Boolean res);

}
