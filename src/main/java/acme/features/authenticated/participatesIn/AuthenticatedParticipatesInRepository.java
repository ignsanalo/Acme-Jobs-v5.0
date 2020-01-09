
package acme.features.authenticated.participatesIn;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messages.MessageThread;
import acme.entities.messages.ParticipatesIn;
import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedParticipatesInRepository extends AbstractRepository {

	@Query("select a from Authenticated a where a.id = ?1")
	Authenticated findOneAuthenticatedById(int authId);

	@Query("select pi from ParticipatesIn pi where pi.id = ?1")
	ParticipatesIn findOneById(int id);

	@Query("select pi from ParticipatesIn pi where pi.thread.id = ?1")
	Collection<ParticipatesIn> findManyByThreadId(int threadId);

	@Query("select mt from MessageThread mt where mt.id = ?1")
	MessageThread findMessageThreadById(int threadId);

	@Query("select a from Authenticated a where NOT EXISTS(select pi from ParticipatesIn pi where (pi.participant.id = a.id AND pi.thread.id = ?1) OR pi.thread.owner.id = a.id)")
	Collection<Authenticated> findAllAuthenticated(int threadId);

}
