
<%@ page import="fr.isima.estouroDePilha.Comment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'comment.label', default: 'Comment')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-comment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-comment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list comment">
			
				<g:if test="${commentInstance?.message}">
				<li class="fieldcontain">
					<span id="message-label" class="property-label"><g:message code="comment.message.label" default="Message" /></span>
					
						<span class="property-value" aria-labelledby="message-label"><g:fieldValue bean="${commentInstance}" field="message"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${commentInstance?.author}">
				<li class="fieldcontain">
					<span id="author-label" class="property-label"><g:message code="comment.author.label" default="Author" /></span>
					
						<span class="property-value" aria-labelledby="author-label"><g:link controller="user" action="show" id="${commentInstance?.author?.id}">${commentInstance?.author?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${commentInstance?.nbVotes}">
				<li class="fieldcontain">
					<span id="nbVotes-label" class="property-label"><g:message code="comment.nbVotes.label" default="Nb Votes" /></span>
					
						<span class="property-value" aria-labelledby="nbVotes-label"><g:fieldValue bean="${commentInstance}" field="nbVotes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${commentInstance?.post}">
				<li class="fieldcontain">
					<span id="post-label" class="property-label"><g:message code="comment.post.label" default="Post" /></span>
					
						<span class="property-value" aria-labelledby="post-label"><g:link controller="post" action="show" id="${commentInstance?.post?.id}">${commentInstance?.post?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${commentInstance?.postedDate}">
				<li class="fieldcontain">
					<span id="postedDate-label" class="property-label"><g:message code="comment.postedDate.label" default="Posted Date" /></span>
					
						<span class="property-value" aria-labelledby="postedDate-label"><g:formatDate date="${commentInstance?.postedDate}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${commentInstance?.id}" />
					<g:link class="edit" action="edit" id="${commentInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
