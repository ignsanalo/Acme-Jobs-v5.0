
package acme.features.authenticated.messageThread;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.MessageThread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMessageThreadListService implements AbstractListService<Authenticated, MessageThread> {

	@Autowired
	private AuthenticatedMessageThreadRepository repository;


	@Override
	public boolean authorise(final Request<MessageThread> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<MessageThread> request, final MessageThread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment");

	}

	@Override
	public Collection<MessageThread> findMany(final Request<MessageThread> request) {

		assert request != null;

		Collection<MessageThread> owned;
		Collection<MessageThread> participated;
		Principal principal = request.getPrincipal();

		participated = this.repository.findManyByAuthenticatedId(principal.getActiveRoleId());
		owned = this.repository.findManyByOwnerId(principal.getActiveRoleId());

		participated.addAll(owned);

		return participated;
	}

}
