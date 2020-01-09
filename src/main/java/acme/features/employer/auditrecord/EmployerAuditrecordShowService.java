
package acme.features.employer.auditrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditrecords.Auditrecord;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerAuditrecordShowService implements AbstractShowService<Employer, Auditrecord> {

	@Autowired
	EmployerAuditrecordRepository repository;


	@Override
	public boolean authorise(final Request<Auditrecord> request) {

		assert request != null;

		boolean result;

		int auditrecordID;
		Auditrecord auditrecord;
		Employer employer;
		Principal principal;

		auditrecordID = request.getModel().getInteger("id");
		auditrecord = this.repository.findOneAuditById(auditrecordID);

		employer = auditrecord.getJob().getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();

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
