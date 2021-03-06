
package acme.features.authenticated.investorrecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorrecords.Investorrecords;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedInvestorrecordsShowService implements AbstractShowService<Authenticated, Investorrecords> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedInvestorrecordsRepository repository;

	// AbstractCreateService<Authenticated, Investorrecordss> ---------------------------


	@Override
	public boolean authorise(final Request<Investorrecords> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Investorrecords> request, final Investorrecords entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "statement", "stars");
	}

	@Override
	public Investorrecords findOne(final Request<Investorrecords> request) {
		assert request != null;

		Investorrecords result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}
}
