/*
 * AuthenticatedAuditorRequestCreateService.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.auditor_request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditor.AuditorRequest;
import acme.entities.auditor.Status;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.entities.UserAccount;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedAuditorRequestCreateService implements AbstractCreateService<Authenticated, AuditorRequest> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedAuditorRequestRepository repository;


	// AbstractCreateService<Authenticated, AuditorRequest> interface ---------------

	@Override
	public boolean authorise(final Request<AuditorRequest> request) {
		assert request != null;

		boolean result;

		Principal principal;

		int accountId;

		principal = request.getPrincipal();

		accountId = principal.getAccountId();

		if (this.repository.findAuditorRequestById(accountId) != null) {
			result = false;
		} else {
			result = true;
		}

		return result;
	}

	@Override
	public void validate(final Request<AuditorRequest> request, final AuditorRequest entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void bind(final Request<AuditorRequest> request, final AuditorRequest entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<AuditorRequest> request, final AuditorRequest entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "firm", "statement", "status");

	}

	@Override
	public AuditorRequest instantiate(final Request<AuditorRequest> request) {
		assert request != null;

		AuditorRequest result;

		Principal principal;

		int accountId;

		principal = request.getPrincipal();

		accountId = principal.getAccountId();

		UserAccount userAccount = this.repository.findOneUserAccountById(accountId);

		result = new AuditorRequest();

		result.setStatus(Status.PENDING);

		result.setUser(userAccount);

		return result;
	}

	@Override
	public void create(final Request<AuditorRequest> request, final AuditorRequest entity) {
		assert request != null;
		assert entity != null;

		/*
		 * Authenticated user;
		 *
		 * Principal principal = request.getPrincipal();
		 * int userAccountId = principal.getAccountId();
		 * UserAccount userAccount = this.repository.findOneUserAccountById(userAccountId);
		 *
		 * user = new Authenticated();
		 * user.setUserAccount(userAccount);
		 *
		 * entity.setUser(user);
		 */

		this.repository.save(entity);
	}

	@Override
	public void onSuccess(final Request<AuditorRequest> request, final Response<AuditorRequest> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
