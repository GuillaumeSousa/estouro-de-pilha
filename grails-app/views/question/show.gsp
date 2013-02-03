
<%@ page import="fr.isima.estouroDePilha.Question" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-question" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list question">
			
			
				<g:if test="${questionInstance?.answers}">
				<li class="fieldcontain">
					<span id="answers-label" class="property-label"><g:message code="question.answers.label" default="Answers" /></span>
					
						<g:each in="${questionInstance.answers}" var="a">
						<span class="property-value" aria-labelledby="answers-label"><g:link controller="answer" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${questionInstance?.author}">
				<li class="fieldcontain">
					<span id="author-label" class="property-label"><g:message code="question.author.label" default="Author" /></span>
					
						<span class="property-value" aria-labelledby="author-label"><g:fieldValue bean="${questionInstance}" field="author"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionInstance?.comments}">
				<li class="fieldcontain">
					<span id="comments-label" class="property-label"><g:message code="question.comments.label" default="Comments" /></span>
					
						<g:each in="${questionInstance.comments}" var="c">
						<span class="property-value" aria-labelledby="comments-label"><g:link controller="comment" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${questionInstance?.message}">
				<li class="fieldcontain">
					<span id="message-label" class="property-label"><g:message code="question.message.label" default="Message" /></span>
					
						<span class="property-value" aria-labelledby="message-label"><g:fieldValue bean="${questionInstance}" field="message"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionInstance?.nbViews}">
				<li class="fieldcontain">
					<span id="nbViews-label" class="property-label"><g:message code="question.nbViews.label" default="Nb Views" /></span>
					
						<span class="property-value" aria-labelledby="nbViews-label"><g:fieldValue bean="${questionInstance}" field="nbViews"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionInstance?.nbVotes}">
				<li class="fieldcontain">
					<span id="nbVotes-label" class="property-label"><g:message code="question.nbVotes.label" default="Nb Votes" /></span>
					
						<span class="property-value" aria-labelledby="nbVotes-label"><g:fieldValue bean="${questionInstance}" field="nbVotes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionInstance?.postedDate}">
				<li class="fieldcontain">
					<span id="postedDate-label" class="property-label"><g:message code="question.postedDate.label" default="Posted Date" /></span>
					
						<span class="property-value" aria-labelledby="postedDate-label"><g:formatDate date="${questionInstance?.postedDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionInstance?.subject}">
				<li class="fieldcontain">
					<span id="subject-label" class="property-label"><g:message code="question.subject.label" default="Subject" /></span>
					
						<span class="property-value" aria-labelledby="subject-label"><g:fieldValue bean="${questionInstance}" field="subject"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionInstance?.tags}">
				<li class="fieldcontain">
					<span id="tags-label" class="property-label"><g:message code="question.tags.label" default="Tags" /></span>
					
						<g:each in="${questionInstance.tags}" var="t">
						<span class="property-value" aria-labelledby="tags-label"><g:link controller="tag" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${questionInstance?.id}" />
					<g:link class="edit" action="edit" id="${questionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
