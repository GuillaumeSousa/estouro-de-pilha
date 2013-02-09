<%@ page import="fr.isima.estouroDePilha.Badge" %>



<div class="fieldcontain ${hasErrors(bean: badgeInstance, field: 'badgeName', 'error')} ">
	<label for="badgeName">
		<g:message code="badge.badgeName.label" default="Badge Name" />
		
	</label>
	<g:textField name="badgeName" value="${badgeInstance?.badgeName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: badgeInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="badge.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${badgeInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: badgeInstance, field: 'users', 'error')} ">
	<label for="users">
		<g:message code="badge.users.label" default="Users" />
		
	</label>
	
</div>

