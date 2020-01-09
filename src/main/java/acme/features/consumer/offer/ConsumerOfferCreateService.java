
package acme.features.consumer.offer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Configuration;
import acme.entities.offers.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ConsumerOfferCreateService implements AbstractCreateService<Consumer, Offer> {

	@Autowired
	ConsumerOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");
	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "deadline", "text", "moneyMin", "moneyMax", "ticker");

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("accept", "false");
		} else {
			request.transfer(model, "accept");
		}

	}

	@Override
	public Offer instantiate(final Request<Offer> request) {
		Offer result;

		result = new Offer();

		return result;
	}

	@Override
	public void validate(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("moneyMin") && !errors.hasErrors("moneyMax")) {
			Boolean eurZoneMin = entity.getMoneyMin().getCurrency().matches("euros|eur|Euros|EUR|EUROS|€");
			Boolean eurZoneMax = entity.getMoneyMax().getCurrency().matches("euros|eur|Euros|EUR|EUROS|€");

			errors.state(request, eurZoneMin, "moneyMin", "consumer.offer.error.euroZone");
			errors.state(request, eurZoneMax, "moneyMax", "consumer.offer.error.euroZone");

		}
		if (!errors.hasErrors("accept")) {
			Boolean isAccepted = request.getModel().getBoolean("accept");
			errors.state(request, isAccepted, "accept", "consumer.offer.error.must-accept");
		}

		if (!errors.hasErrors("moneyMin") && !errors.hasErrors("moneyMax")) {
			Boolean minmax = entity.getMoneyMin().getAmount().compareTo(entity.getMoneyMax().getAmount()) < 0;
			errors.state(request, minmax, "moneyMin", "consumer.offer.error.moneyMin");
		}

		if (!errors.hasErrors("ticker")) {
			Boolean tickerFormat = entity.getTicker().matches("^[O]{1}[A-Z]{4}\\-[0-9]{5}$");
			errors.state(request, tickerFormat, "ticker", "consumer.offer.error.tickerFormat");
		}

		Configuration config;
		config = this.repository.findManyConfiguration().stream().findFirst().get();

		if (!errors.hasErrors("text")) {
			boolean isSpam = !config.isSpam(entity.getText());
			errors.state(request, isSpam, "text", "authenticated.consumer.error.spam");
		}

	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
