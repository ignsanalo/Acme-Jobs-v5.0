
package acme.features.administrator.investorrecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Configuration;
import acme.entities.investorrecords.Investorrecords;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorInvestorrecordsCreateService implements AbstractCreateService<Administrator, Investorrecords> {

	@Autowired
	private AdministratorInvestorrecordsRepository repository;


	@Override
	public boolean authorise(final Request<Investorrecords> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Investorrecords> request, final Investorrecords entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Investorrecords> request, final Investorrecords entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "statement", "stars");

	}

	@Override
	public Investorrecords instantiate(final Request<Investorrecords> request) {
		Investorrecords result;

		result = new Investorrecords();

		return result;
	}

	@Override
	public void validate(final Request<Investorrecords> request, final Investorrecords entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Configuration config;
		config = this.repository.findManyConfiguration().stream().findFirst().get();

		if (!errors.hasErrors("statment")) {
			boolean isSpam = !config.isSpam(entity.getStatement());
			errors.state(request, isSpam, "statement", "administrator.investorRecords.error.spam");
		}

	}

	@Override
	public void create(final Request<Investorrecords> request, final Investorrecords entity) {

		this.repository.save(entity);

	}

}
