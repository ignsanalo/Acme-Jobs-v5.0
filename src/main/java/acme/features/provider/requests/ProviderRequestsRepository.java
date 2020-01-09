/*
 * ProviderRequestsRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.provider.requests;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.configuration.Configuration;
import acme.entities.requests.Requests;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ProviderRequestsRepository extends AbstractRepository {

	@Query("select r from Requests r where r.id = ?1")
	Requests findOneById(int id);

	@Query("select r from Requests r where (r.deadline >= CURRENT_TIMESTAMP())")
	Collection<Requests> findManyAll();

	@Query("select r from Requests r where (r.deadline >= ?1)")
	Collection<Requests> findManyAll(Date c);

	@Query("select c from Configuration c")
	Collection<Configuration> findManyConfiguration();

}
