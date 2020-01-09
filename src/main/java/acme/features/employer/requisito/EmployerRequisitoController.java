
package acme.features.employer.requisito;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.requisito.Requisito;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/requisito/")
public class EmployerRequisitoController extends AbstractController<Employer, Requisito> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EmployerRequisitoShowService		showService;

	@Autowired
	private EmployerRequisitoListByJobService	listService;

	@Autowired
	private EmployerRequisitoCreateService		createService;


	// Constructors -----------------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_BY_JOB, BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
