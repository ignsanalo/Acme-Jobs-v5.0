
package acme.features.employer.auditrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.auditrecords.Auditrecord;
import acme.entities.roles.Auditor;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/auditrecord/")

public class EmployerAuditrecordController extends AbstractController<Employer, Auditrecord> {

	@Autowired
	private EmployerAuditrecordShowService		showService;

	@Autowired
	private EmployerAuditrecordListByJobService	listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

		super.addCustomCommand(CustomCommand.LIST_BY_JOB, BasicCommand.LIST, this.listService);

	}

}
