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
	<acme:form-textbox code="worker.application.form.label.reference" path="reference" />
	<acme:form-textbox code="worker.application.form.label.statement" path="statement" />
	<acme:form-textbox code="worker.application.form.label.skills" path="skills" />
	<acme:form-textbox code="worker.application.form.label.qualifications" path="qualifications" />
	<acme:form-textarea readonly="true" code="worker.application.form.label.mandatoryJustification" path="mandatoryJustification" />
	<acme:form-textbox code="worker.application.form.label.answer" path="answer" />
	
	<jstl:if test="${command == 'create'}">
		<acme:form-textbox code="worker.application.form.label.password" path="password" />
		<acme:form-textbox code="worker.application.form.label.protegido" path="protegido" />
	</jstl:if>
	
	<jstl:if test="${command != 'create'}">
		<jstl:if test="${password ==''}">
			<acme:form-textbox code="worker.application.form.label.protegido" path="protegido" />
		</jstl:if>
		<jstl:if test="${password!=''}">
			<acme:form-password code="worker.application.form.label.password" path="password" />
			<acme:form-password code="worker.application.form.label.protegido" path="protegido" />
		</jstl:if>
	</jstl:if>
	
	<acme:form-submit test="${command =='create' }" code="worker.application.form.button.create" action="/worker/application/create?id=${id}" />
	
     	
	<acme:form-return code="worker.application.form.button.return" />
</acme:form>