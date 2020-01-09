
package acme.features.authenticated.investorrecords;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorrecords.Investorrecords;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedInvestorrecordsListService implements AbstractListService<Authenticated, Investorrecords> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedInvestorrecordsRepository repository;


	// AbstractUpdateService<Authenticated, Announcement> interface -----------------

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

		request.unbind(entity, model, "name", "sector");
	}

	@Override
	public Collection<Investorrecords> findMany(final Request<Investorrecords> request) {

		assert request != null;

		Collection<Investorrecords> result;

		result = this.repository.findManyAll();

		return result;

	}
}
