
package acme.features.authenticated.auditrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditrecords.Auditrecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedAuditrecordShowService implements AbstractShowService<Authenticated, Auditrecord> {

	@Autowired
	AuthenticatedAuditrecordRepository repository;


	@Override
	public boolean authorise(final Request<Auditrecord> request) {

		assert request != null;

		boolean result = false;
		int auditrecordId;
		Auditrecord currentAuditrecord;
		Principal principal;

		auditrecordId = request.getModel().getInteger("id");
		currentAuditrecord = this.repository.findOneAuditById(auditrecordId);
		principal = request.getPrincipal();

		result = currentAuditrecord.getJob().isFinalMode() == true || currentAuditrecord.getJob().isFinalMode() == false && currentAuditrecord.getJob().getEmployer().getUserAccount().getId() == principal.getAccountId();

		return result;

	}

	@Override
	public void unbind(final Request<Auditrecord> request, final Auditrecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "body", "finalMode");
	}

	@Override
	public Auditrecord findOne(final Request<Auditrecord> request) {

		assert request != null;

		Auditrecord result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneAuditById(id);

		return result;

	}

}
