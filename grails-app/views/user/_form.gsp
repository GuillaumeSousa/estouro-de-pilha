<%@ page import="fr.isima.estouroDePilha.User" %>

<g:link controller="user" action="choose_avatar" id="${userInstance?.id}">
	<g:message code="user.editAvatar" default="Change avatar" />
</g:link>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'login', 'error')} required">
	<label for="login">
		<g:message code="user.login.label" default="Login (email address)" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="login" required="" value="${userInstance?.login}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:passwordField name="password" required="" value="${userInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'pseudo', 'error')} ">
	<label for="pseudo">
		<g:message code="user.pseudo.label" default="Pseudo" />
		
	</label>
	<g:textField name="pseudo" value="${userInstance?.pseudo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'realName', 'error')} ">
	<label for="realName">
		<g:message code="user.realName.label" default="Real Name" />
		
	</label>
	<g:textField name="realName" value="${userInstance?.realName}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'birthDate', 'error')} required">
	<label for="birthDate">
		<g:message code="user.birthDate.label" default="Birth Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="birthDate" precision="day"  value="${userInstance?.birthDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'website', 'error')} ">
	<label for="website">
		<g:message code="user.website.label" default="Website" />
		
	</label>
	<g:textField name="website" value="${userInstance?.website}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'location', 'error')} ">
	<label for="location">
		<g:message code="user.location.label" default="Location" />
		
	</label>
	<g:textField name="location" value="${userInstance?.location}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'aboutMe', 'error')} ">
	<label for="aboutMe">
		<g:message code="user.aboutMe.label" default="About Me" />
		
	</label>
	<g:textArea name="aboutMe" value="${userInstance?.aboutMe}"/>
</div>


