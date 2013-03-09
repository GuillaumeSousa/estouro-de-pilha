
<%@ page import="fr.isima.estouroDePilha.Question" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
		<title><g:message code="question.list.title" /></title>
	</head>
	<body>
		<a href="#list-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="page-body" class="content scaffold-list" role="main">
			<h1><g:message code="question.list.title" /></h1>
			<!-- List questions -->
		    <div id="questions">
    				<g:render template="/question/listQuestions" var="question" collection="${questionInstanceList}"/>
			</div>
						
			<div class="pagination">
				<g:paginate total="${questionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
