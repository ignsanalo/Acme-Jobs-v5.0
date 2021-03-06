
package acme.features.worker.requisito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requisito.Requisito;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerRequisitoShowService implements AbstractShowService<Worker, Requisito> {

	@Autowired
	private WorkerRequisitoRepository repository;


	@Override
	public boolean authorise(final Request<Requisito> request) {
		assert request != null;
		boolean result;

		return true;
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
