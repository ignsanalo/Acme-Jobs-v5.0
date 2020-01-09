
package acme.features.auditor.auditrecord;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditrecords.Auditrecord;
import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Principal;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;

@Service
public class AuditorAuditrecordCreateService implements AbstractCreateService<Auditor, Auditrecord> {

	@Autowired
	AuditorAuditrecordRepository repository;


	@Override
	public boolean authorise(final Request<Auditrecord> request) {
		assert request != null;

		return true;
	}
	@Override
	public void bind(final Request<Auditrecord> request, final Auditrecord entity, final Errors error) {
		assert request != null;
		assert entity != null;
		assert error != null;

		request.bind(entity, error, "moment");

	}

	@Override
	public void unbind(final Request<Auditrecord> request, final Auditrecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "body", "finalMode");
		model.setAttribute("id", entity.getJob().getId());
	}

	@Override
	public Auditrecord instantiate(final Request<Auditrecord> request) {
		assert request != null;

		Auditrecord result;
		Principal principal;
		int auditorId;
		Auditor auditor;
		result = new Auditrecord();

		principal = request.getPrincipal();
		auditorId = principal.getActiveRoleId();

		auditor = this.repository.findOneAuditorById(auditorId);   //pilla auditor

		int jobId = request.getModel().getInteger("id");
		Job job = this.repository.findOneJobById(jobId);

		result.setAuditor(auditor);
		result.setJob(job);

		return result;
	}

	@Override
	public void validate(final Request<Auditrecord> request, final Auditrecord entity, final Errors error) {
		assert request != null;
		assert entity != null;
		assert error != null;
	}

	@Override
	public void create(final Request<Auditrecord> request, final Auditrecord entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

	@Override
	public void onSuccess(final Request<Auditrecord> request, final Response<Auditrecord> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}

	}

}
