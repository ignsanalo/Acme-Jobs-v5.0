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
	<acme:form-textbox code="administrator.companyrecord.form.label.name" path="name"/>
	<acme:form-textbox code="administrator.companyrecord.form.label.sector" path="sector"/>
	<acme:form-textbox code="administrator.companyrecord.form.label.ceo" path="ceo"/>
	<acme:form-textarea code="administrator.companyrecord.form.label.description" path="description"/>
	<acme:form-url code="administrator.companyrecord.form.label.web" path="web"/>
	<acme:form-textbox code="administrator.companyrecord.form.label.phone" path="phone"/>
	<acme:form-textbox code="administrator.companyrecord.form.label.email" path="email"/>
	<acme:form-integer code="administrator.companyrecord.form.label.stars" path="stars" placeholder="0-5"/>
	
	<acme:form-submit test="${command == 'show'}"
		code="administrator.companyrecord.form.button.update"
		action="/administrator/companyrecord/update"/>
	<acme:form-submit test="${command == 'show'}"
		code="administrator.companyrecord.form.button.delete"
		action="/administrator/companyrecord/delete"/>
	<acme:form-submit test="${command == 'create'}"
		code="administrator.companyrecord.form.button.create"
		action="/administrator/companyrecord/create"/>
	<acme:form-submit test="${command == 'update'}"
		code="administrator.companyrecord.form.button.update"
		action="/administrator/companyrecord/update"/>
	<acme:form-submit test="${command == 'delete'}"
		code="administrator.companyrecord.form.button.delete"
		action="/administrator/companyrecord/delete"/>
	<acme:form-return code="authenticated.companyrecord.form.button.return"/>
	
</acme:form>