
package acme.features.authenticated.auditrecord;

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
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/auditrecord/")

public class AuthenticatedAuditrecordController extends AbstractController<Authenticated, Auditrecord> {

	@Autowired
	private AuthenticatedAuditrecordShowService		showService;

	@Autowired
	private AuthenticatedAuditrecordListByJobService	listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

		super.addCustomCommand(CustomCommand.LIST_BY_JOB, BasicCommand.LIST, this.listService);

	}

}
