
package acme.features.employer.requisito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requisito.Requisito;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerRequisitoShowService implements AbstractShowService<Employer, Requisito> {

	@Autowired
	private EmployerRequisitoRepository repository;


	@Override
	public boolean authorise(final Request<Requisito> request) {
		assert request != null;
		boolean result;

		int requisitoId;
		Requisito requisito;
		Employer employer;
		Principal principal;

		requisitoId = request.getModel().getInteger("id");
		requisito = this.repository.findOneById(requisitoId);

		employer = requisito.getJob().getEmployer();
		principal = request.getPrincipal();
		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Requisito> request, final Requisito entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "moreInfo");
	}

	@Override
	public Requisito findOne(final Request<Requisito> request) {
		assert request != null;

		Requisito result;
		int idJob;

		idJob = request.getModel().getInteger("id");
		result = this.repository.findOneById(idJob);

		return result;
	}

}
