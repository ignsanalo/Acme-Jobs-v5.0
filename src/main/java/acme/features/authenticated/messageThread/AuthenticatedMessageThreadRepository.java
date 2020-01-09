/*
 * AuthenticatedMessageThreadRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.messageThread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.configuration.Configuration;
import acme.entities.messages.MessageThread;
import acme.entities.messages.ParticipatesIn;
import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageThreadRepository extends AbstractRepository {

	@Query("select m from MessageThread m where m.id = ?1 ")
	MessageThread findOneById(int id);

	@Query("select m from MessageThread m where m.owner.id = ?1")
	Collection<MessageThread> findManyByAuthId(int id);

	@Query("select a from Authenticated a where a.id = ?1")
	Authenticated findOneAuthenticatedById(int id);

	@Query("select m from MessageThread m")
	Collection<MessageThread> findManyAll();

	@Query("select c from Configuration c")
	Collection<Configuration> findManyConfiguration();
  
	@Query("select pi from ParticipatesIn pi where pi.thread.id = ?1")
	Collection<ParticipatesIn> findManyParticipatesInByThreadId(int id);

}
