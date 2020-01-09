
package acme.features.worker.requisito;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requisito.Requisito;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerRequisitoRepository extends AbstractRepository {

	@Query("select r from Requisito r where r.id = ?1")
	Requisito findOneById(int idJob);

	@Query("select r from Requisito r where r.job.id = ?1")
	Collection<Requisito> findManyByJob(int idJob);

}
