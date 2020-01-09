<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textbox code="employer.job.form.label.reference" path="reference" />
	<acme:form-textbox code="employer.job.form.label.title" path="title" />
	<acme:form-moment code="employer.job.form.label.deadline" path="deadline" />
	<acme:form-money code="employer.job.form.label.salary" path="salary" />
	<acme:form-url code="employer.job.form.label.moreInfo" path="moreInfo" />
	
	<acme:form-textarea code="employer.job.form.label.description" path="description" />
	
	<jstl:if test="${command == 'show'}">
	<acme:form-textbox  code="employer.job.form.label.finalMode" path="finalMode" />
	</jstl:if>
	

	<acme:form-submit test="${command == 'show'}" code="employer.application.button.list" method="get" 
		action="/employer/application/list-jobs-app?id=${id}"/>
		
	<acme:form-submit test="${command == 'show'}" code="employer.job.form.button.duty-list" method="get" 
		action="/employer/duty/list-by-job?id=${id}"/>

	<acme:form-submit test="${command == 'show'}" code="employer.job.form.label.auditRecord" method="get" 
	action="/employer/auditrecord/list-by-job?id=${id}"/>
	
	<%-- <acme:form-submit test="${command == 'show'}" code="employer.xxxx1.form.button.create" method="get"
	action="/employer/xxxx1/create?id=${id}"/> --%>
	
	<acme:form-submit test="${command == 'show'}" code="employer.job.form.button.requisito-list" method="get" 
		action="/employer/requisito/list-by-job?id=${id}"/>
		
	<acme:form-submit test="${command == 'show'}" code="employer.job.form.button.requisito-create" method="get" 
		action="/employer/requisito/create?id=${id}"/>
	
	<acme:form-submit test="${command == 'show' && !finalMode}" code="employer.job.form.button.update"
		action="/employer/job/update" />
	<acme:form-submit test="${command == 'show'}" code="employer.job.form.button.delete"
		action="/employer/job/delete" />
	<acme:form-submit test="${command == 'create'}" code="employer.job.form.button.create"
		action="/employer/job/create" />
	<acme:form-submit test="${command == 'update' && !finalMode}" code="employer.job.form.button.update"
		action="/employer/job/update" />
	<acme:form-submit test="${command == 'delete'}" code="employer.job.form.button.delete"
		action="/employer/job/delete" />
	
	<acme:form-return code="employer.job.form.button.return" />
	
</acme:form>
