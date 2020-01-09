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
	<acme:form-textbox code="provider.requests.form.label.title" path="title" />
	<jstl:if test="${command !='create' }">
		<acme:form-moment code="provider.requests.form.label.moment" path="moment" readonly="true" />
	</jstl:if>
	<acme:form-moment code="provider.requests.form.label.deadline" path="deadline" />
	<acme:form-textarea code="provider.requests.form.label.text" path="text" />
	<acme:form-textbox code="provider.requests.form.label.reward" path="reward" />
	<acme:form-textbox code="provider.requests.form.label.ticker" path="ticker" />
	<acme:form-checkbox code="provider.requests.label.accept" path="accept" />
	<acme:form-submit test="${command =='create' }" code="provider.requests.form.button.create" action="/provider/requests/create" />
	<acme:form-return code="provider.requests.form.button.return" />
</acme:form>
