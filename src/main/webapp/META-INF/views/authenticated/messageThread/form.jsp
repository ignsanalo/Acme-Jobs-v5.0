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

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.messageThread.form.label.title" path="title" />
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="authenticated.messageThread.form.label.moment" path="moment" />
	</jstl:if>
	<acme:form-submit test="${command == 'show'}" code="authenticated.message.form.label.create" method="get"
		action="/authenticated/message/create?id=${id}" />
		
	<acme:form-submit test="${command == 'show'}" code="authenticated.messageThread.form.label.show-messages" method="get"
		action="/authenticated/message/list-by-thread?id=${id}" />
		
	<acme:form-submit test="${command != 'create'}" code="authenticated.message-thread.form.button.list-participants" method="get" 
		action="/authenticated/participates-in/list-participants?threadId=${id}"/>
		
	<acme:form-submit test="${command != create && isOwner}" code="authenticated.participates-in.form.button.add-participant" method="get"
		action="/authenticated/participates-in/add-participant?threadId=${id}"/>
		
	<acme:form-submit test="${command == 'create'}" code="authenticated.messageThread.form.button.create"
		action="/authenticated/message-thread/create?id=${id}" />


	<acme:form-return code="authenticated.messageThread.form.button.return" />

</acme:form>
