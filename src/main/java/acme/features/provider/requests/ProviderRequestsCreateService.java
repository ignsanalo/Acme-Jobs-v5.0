
package acme.features.provider.requests;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Configuration;
import acme.entities.requests.Requests;
import acme.entities.roles.Provider;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ProviderRequestsCreateService implements AbstractCreateService<Provider, Requests> {

	@Autowired
	ProviderRequestsRepository repository;


	@Override
	public boolean authorise(final Request<Requests> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Requests> request, final Requests entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");
	}

	@Override
	public void unbind(final Request<Requests> request, final Requests entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "deadline", "text", "reward", "ticker");

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("accept", "false");
		} else {
			request.transfer(model, "accept");
		}
	}

	@Override
	public Requests instantiate(final Request<Requests> request) {
		Requests result;

		result = new Requests();

		return result;
	}

	@Override
	public void validate(final Request<Requests> request, final Requests entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("deadline")) {
			Boolean notPast = entity.getDeadline().after(new Date());
			errors.state(request, notPast, "deadline", "provider.requests.error.deadline");
		}
		if (!errors.hasErrors("reward")) {
			Boolean eurZone = entity.getReward().getCurrency().matches("euros|eur|Euros|EUR|EUROS|€");
			errors.state(request, eurZone, "reward", "provider.requests.error.euro_zone");
		}

		if (!errors.hasErrors("accept")) {
			Boolean isAccepted = request.getModel().getBoolean("accept");
			errors.state(request, isAccepted, "accept", "provider.requests.error.must-accept");
		}

		if (!errors.hasErrors("ticker")) {
			Boolean tickerFormat = entity.getTicker().matches("^[R]{1}[A-Z]{4}\\-[0-9]{5}$");
			errors.state(request, tickerFormat, "ticker", "provider.requests.error.tickerFormat");
		}

		Configuration config;
		config = this.repository.findManyConfiguration().stream().findFirst().get();

		if (!errors.hasErrors("text")) {
			boolean isSpam = config.isSpam(entity.getText());
			errors.state(request, !isSpam, "text", "provider.request.error.spam");
		}

	}

	@Override
	public void create(final Request<Requests> request, final Requests entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
