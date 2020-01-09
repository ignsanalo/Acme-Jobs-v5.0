<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">

			<acme:menu-suboption code="master.menu.anonymous.favourite-link" action="http://www.example.com/" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.announcement.list" action="/anonymous/announcement/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.companyrecord.list" action="/anonymous/companyrecord/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.investorrecords.list" action="/anonymous/investorrecords/list" />


		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.dashboard" action="/administrator/dashboard/show" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.announcement.list" action="/administrator/announcement/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.challenge.list" action="/administrator/challenge/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.companyrecord.list" action="/administrator/companyrecord/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.investorrecords.list" action="/administrator/investorrecords/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.announcement.create" action="/administrator/announcement/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.challenge.create" action="/administrator/challenge/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.companyrecord.create" action="/administrator/companyrecord/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.investorrecords.create" action="/administrator/investorrecords/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.configuration" action="/administrator/configuration/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.auditor-request.list" action="/administrator/auditor-request/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.provider.requests.create" action="/provider/requests/create/" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.consumer.offers.create" action="/consumer/offer/create/" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.auditor" access="hasRole('Auditor')">
			<acme:menu-suboption code="master.menu.auditor.job.list" action="/auditor/job/list-mine" />
			<acme:menu-suboption code="master.menu.auditor.job.list2" action="/auditor/job/list-not-mine" />
			<acme:menu-suboption code="master.menu.auditor.job.list3" action="/auditor/job/list" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.announcement.list" action="/authenticated/announcement/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.user-account.companyrecord.list" action="/authenticated/companyrecord/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.user-account.investorrecords.list" action="/authenticated/investorrecords/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.user-account.offer.list" action="/authenticated/offer/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.user-account.requests.list" action="/authenticated/requests/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.user-account.job.list" action="/authenticated/job/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.user-account.message-thread.list-mine" action="/authenticated/message-thread/list-mine" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.user-account.message-thread.list" action="/authenticated/message-thread/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.user-account.message-thread.create" action="/authenticated/message-thread/create" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.worker" access="hasRole('Worker')">
			<acme:menu-suboption code="master.menu.worker.application.list" action="/worker/application/list-mine" />
			<acme:menu-suboption code="master.menu.worker.job.list" action="/worker/job/list" />

		</acme:menu-option>

		<acme:menu-option code="master.menu.employer" access="hasRole('Employer')">
		<acme:menu-suboption code="master.menu.employer.job.list" action="/employer/job/list-mine" />
		<acme:menu-separator />
		<acme:menu-suboption code="master.menu.employer.job.create" action="/employer/job/create" />

		</acme:menu-option>

	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()" />
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()" />

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update" />
			<acme:menu-suboption code="master.menu.user-account.become-employer" action="/authenticated/employer/create" />
			<acme:menu-suboption code="master.menu.user-account.update-employer" action="/authenticated/employer/update" />
			<acme:menu-suboption code="master.menu.user-account.become-worker" action="/authenticated/worker/create" />
			<acme:menu-suboption code="master.menu.user-account.update-worker" action="/authenticated/worker/update"
				access="hasRole('Worker')" />
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create"
				access="!hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update"
				access="hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create"
				access="!hasRole('Consumer')" />
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update"
				access="hasRole('Consumer')" />
			<acme:menu-suboption code="master.menu.user-account.become-worker" action="/authenticated/worker/create"
				access="!hasRole('Worker')" />
			<acme:menu-suboption code="master.menu.user-account.worker" action="/authenticated/worker/update"
				access="hasRole('Worker')" />
			<acme:menu-suboption code="master.menu.user-account.become-auditor" action="/authenticated/auditor-request/create" />
				
				
		</acme:menu-option>


		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()" />
	</acme:menu-right>
</acme:menu-bar>