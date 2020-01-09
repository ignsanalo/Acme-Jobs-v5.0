
package acme.features.anonymous.investorrecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.investorrecords.Investorrecords;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/investorrecords/")
public class AnonymousInvestorrecordsController extends AbstractController<Anonymous, Investorrecords> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousInvestorrecordsListService	listService;

	@Autowired
	private AnonymousInvestorrecordsShowService	showService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
