<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="auditor.auditrecord.form.label.title" path="title"/>

	<acme:form-textbox code="auditor.auditrecord.form.label.body" path="body"/>
	
	<acme:form-select  code="auditor.job.form.label.finalMode" path="finalMode">
	<acme:form-option code="auditor.job.form.label.finalMode.yes" value="true"/>
					<jstl:choose>
						<jstl:when test="${!finalMode}">
							<acme:form-option code="auditor.job.form.label.finalMode.no" selected = "true" value="false"/>
						</jstl:when>
						<jstl:otherwise>
							<acme:form-option code="auditor.job.form.label.finalMode.no" value="false"/>
						</jstl:otherwise>
					</jstl:choose>
	</acme:form-select>
	
	<acme:form-submit test="${command == 'create'}" code="auditor.auditrecord.form.button.create"
		action="/auditor/auditrecord/create?id=${id}"/>
	<acme:form-submit test="${command == 'show' && !finalMode}" code="auditor.auditrecord.form.button.update"
		action="/auditor/auditrecord/update"/>
	<acme:form-submit test="${command == 'update'}" code="auditor.auditrecord.form.button.update"
		action="/auditor/auditrecord/update"/>		
		
	
	<acme:form-return code="auditor.job.form.button.return"/>
</acme:form>