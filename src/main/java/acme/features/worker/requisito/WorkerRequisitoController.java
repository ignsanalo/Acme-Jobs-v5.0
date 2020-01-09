
package acme.features.worker.requisito;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.requisito.Requisito;
import acme.entities.roles.Worker;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/worker/requisito/")
public class WorkerRequisitoController extends AbstractController<Worker, Requisito> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private WorkerRequisitoShowService		showService;

	@Autowired
	private WorkerRequisitoListByJobService	listService;


	// Constructors -----------------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_BY_JOB, BasicCommand.LIST, this.listService);
	}

}
