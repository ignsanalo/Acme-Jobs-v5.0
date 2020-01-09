
package acme.features.worker.requisito;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requisito.Requisito;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class WorkerRequisitoListByJobService implements AbstractListService<Worker, Requisito> {

	@Autowired
	WorkerRequisitoRepository repository;


	@Override
	public boolean authorise(final Request<Requisito> request) {
		assert request != null;
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
	public Collection<Requisito> findMany(final Request<Requisito> request) {

		assert request != null;

		Collection<Requisito> result;
		Integer idJob;

		idJob = request.getModel().getInteger("id");
		result = this.repository.findManyByJob(idJob);

		return result;

	}

}
