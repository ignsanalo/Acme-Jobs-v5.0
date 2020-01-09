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
	<acme:form-textbox code="authenticated.message.form.label.title" path="title" />
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="authenticated.message.form.label.moment" path="moment" />
	</jstl:if>
	<acme:form-textbox code="authenticated.message.form.label.tags" path="tags" />
	<acme:form-textbox code="authenticated.message.form.label.body" path="body" />

	<jstl:if test="${command == 'create'}">
		<acme:form-checkbox code="authenticated.message.label.accept" path="accept" />
		<%-- <acme:form-checkbox code="authenticated.message.form.label.accept" path="accept"/> --%>
	</jstl:if>

	<acme:form-submit test="${command == 'create'}" code="authenticated.message.form.button.create"
		action="/authenticated/message/create?id=${id}" />

	<acme:form-return code="authenticated.message.form.button.return" />

</acme:form>
