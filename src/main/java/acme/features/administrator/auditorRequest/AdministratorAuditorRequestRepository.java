/*
 * AuthenticatedAuditorRequestRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and reseach, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this softwae. It has been tested caefully, but it is not guaanteed for any paticula
 * purposes. The copyright owner does not offer any waranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.administrator.auditorRequest;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditor.AuditorRequest;
import acme.entities.configuration.Configuration;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorAuditorRequestRepository extends AbstractRepository {

	@Query("select a from AuditorRequest a where a.user.id = ?1")
	AuditorRequest findAuditorRequestAccount(int id);

	@Query("select a from AuditorRequest a ")
	Collection<AuditorRequest> findManyAll();

	@Query("select ua from UserAccount ua where ua.id = ?1")
	UserAccount findOneUserAccountById(int id);

	@Query("select a from AuditorRequest a where a.id=?1")
	AuditorRequest findOneById(int id);

	@Query("select c from Configuration c")
	Collection<Configuration> findManyConfiguration();

}
