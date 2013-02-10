
<%@ page import="fr.isima.estouroDePilha.Question" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="page-body" role="main">
			<table>
				<g:each in="${questionInstanceList}" status="i" var="questionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
						<td>
						<b style="color:#046380; font-size: 9"><g:link controller="Question" action="show" id="${questionInstance.id}">${fieldValue(bean: questionInstance, field: "subject")}</g:link></b><br>
						Author : ${fieldValue(bean: questionInstance, field: "author.pseudo")}<br>
						date : <g:formatDate date="${questionInstance.postedDate}" format="dd/MM/yyyy - HH:mm"/><br><br>
						${fieldValue(bean: questionInstance, field: "message")}
						</td>
											
						<td><br>
						${fieldValue(bean: questionInstance, field: "nbViews")} views<br>
						${fieldValue(bean: questionInstance, field: "nbVotes")} votes
						</td>
					</tr>
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>
							<g:if test="${questionInstance?.tags}">			
								<g:each in="${questionInstance.tags}" var="t">
								<g:link class="post-tag" controller="Tag" action="taggedQuestions" id="${t.id}">${fieldValue(bean: t, field: "tagname")}</g:link>
								</g:each>
							</g:if>
						</td>
					</tr>
				</g:each>	
			</table>				
			<div class="pagination">
				<g:paginate total="${questionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
