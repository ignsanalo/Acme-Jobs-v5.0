
package acme.features.employer.job;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Configuration;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Principal;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerJobCreateService implements AbstractCreateService<Employer, Job> {

	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}
	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors error) {
		assert request != null;
		assert entity != null;
		assert error != null;

		request.bind(entity, error);

	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "reference", "title", "deadline", "salary", "description", "moreInfo", "finalMode");
	}

	@Override
	public Job instantiate(final Request<Job> request) {
		assert request != null;

		Job result;
		Principal principal;
		int employerId;
		Employer employer;
		result = new Job();

		principal = request.getPrincipal();
		employerId = principal.getActiveRoleId();

		employer = this.repository.findOneEmployerById(employerId);   //pilla employer

		result.setEmployer(employer);
		result.setFinalMode(false);

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
	public void create(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

	@Override
	public void onSuccess(final Request<Job> request, final Response<Job> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}

	}

}
