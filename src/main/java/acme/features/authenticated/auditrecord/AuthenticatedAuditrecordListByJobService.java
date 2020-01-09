
package acme.features.authenticated.auditrecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditrecords.Auditrecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedAuditrecordListByJobService implements AbstractListService<Authenticated, Auditrecord> {

	@Autowired
	AuthenticatedAuditrecordRepository repository;


	@Override
	public boolean authorise(final Request<Auditrecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Auditrecord> request, final Auditrecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title");
	}

	@Override
	public Collection<Auditrecord> findMany(final Request<Auditrecord> request) {

		assert request != null;

		Collection<Auditrecord> result;
		int JobID;

		JobID = request.getModel().getInteger("id");

		result = this.repository.findManyByJobId(JobID);
		result.removeAll(this.repository.findManyAuditByActive(false));

		return result;

	}

}
