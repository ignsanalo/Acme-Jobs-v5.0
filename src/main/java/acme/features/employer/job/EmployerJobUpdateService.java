
package acme.features.employer.job;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Configuration;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerJobUpdateService implements AbstractUpdateService<Employer, Job> {

	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		boolean result = false;
		Principal principal = request.getPrincipal();

		int jobId = request.getModel().getInteger("id");
		Job job = this.repository.findOneJobById(jobId);

		result = !job.isFinalMode() && job.getEmployer().getId() == principal.getActiveRoleId();

		return result;
	}

	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "deadline", "salary", "description", "moreInfo", "finalMode");

	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		Job result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneJobById(id);

		return result;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Configuration config;
		config = this.repository.findManyConfiguration().stream().findFirst().get();

		if (entity.isFinalMode() == true) {

			if (!errors.hasErrors("description")) {
				boolean isSpam = config.isSpam(entity.getDescription());
				errors.state(request, !isSpam, "description", "authenticated.message.error.spam");
			}

			if (!errors.hasErrors("title")) {
				boolean isSpam = config.isSpam(entity.getTitle());
				errors.state(request, !isSpam, "title", "authenticated.message.error.spam");
			}

			if (!errors.hasErrors("deadline")) {
				Boolean deadlineFuture = entity.getDeadline().after(new Date());
				errors.state(request, deadlineFuture, "deadline", "employer.job.error.deadline-not-future", entity.getDeadline());
			}
			if (!errors.hasErrors("deadline")) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				calendar.add(Calendar.DAY_OF_YEAR, 7);
				Boolean deadlineBefore = entity.getDeadline().after(calendar.getTime());
				errors.state(request, deadlineBefore, "deadline", "employer.job.error.deadline-before-7", entity.getDeadline());
			}
			if (!errors.hasErrors("salary")) {
				Boolean isEur = entity.getSalary().getCurrency().matches("EUR|€|EUROS|Euros|euros|eur");
				errors.state(request, isEur, "salary", "employer.job.error.must-be-eur");
			}

		}

	}

	@Override
	public void update(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;
		Double porcentaje = this.repository.sumOfPercentagesDuty(entity.getId());

		if (porcentaje == null || porcentaje > 100.00) {

			entity.setFinalMode(false);

		}

		this.repository.save(entity);

	}
}
