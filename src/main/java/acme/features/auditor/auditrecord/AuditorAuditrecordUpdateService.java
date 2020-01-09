
package acme.features.auditor.auditrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditrecords.Auditrecord;
import acme.entities.roles.Auditor;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractUpdateService;

@Service
public class AuditorAuditrecordUpdateService implements AbstractUpdateService<Auditor, Auditrecord> {

	@Autowired
	AuditorAuditrecordRepository repository;


	@Override
	public boolean authorise(final Request<Auditrecord> request) {
		assert request != null;

		return true;
	}
	@Override
	public void validate(final Request<Auditrecord> request, final Auditrecord entity, final Errors error) {
		assert request != null;
		assert entity != null;
		assert error != null;
	}

	@Override
	public void bind(final Request<Auditrecord> request, final Auditrecord entity, final Errors error) {
		assert request != null;
		assert entity != null;
		assert error != null;

		request.bind(entity, error);

	}
	@Override
	public void unbind(final Request<Auditrecord> request, final Auditrecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "body", "finalMode");
	}
	@Override

	public Auditrecord findOne(final Request<Auditrecord> request) {
		assert request != null;

		Auditrecord result;
		int id = request.getModel().getInteger("id");

		result = this.repository.findOneAuditrecordById(id);

		return result;
	}
	@Override
	public void update(final Request<Auditrecord> request, final Auditrecord entity) {
		assert request != null;
		assert entity != null;

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
