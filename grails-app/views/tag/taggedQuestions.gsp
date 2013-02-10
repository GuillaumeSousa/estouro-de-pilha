<%@ page import="fr.isima.estouroDePilha.Tag" %>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tag.label', default: 'Tag')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	
	<body>
	  <div class="body">
		  <div class="excerpt">${fieldValue(bean: tagInstance, field: "description")}
		  </div>
		  <div >
		  	<table>
				<g:each in="${taggedQuestionsList}" status="i" var="questionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
						<td>
						<b style="color:#046380; font-size: 9">${fieldValue(bean: questionInstance, field: "subject")}</b><br>
						Author : ${fieldValue(bean: questionInstance, field: "author")}<br>
						date : <g:formatDate date="${questionInstance.postedDate}" format="dd/MM/yyyy - HH:mm"/><br><br>
						${fieldValue(bean: questionInstance, field: "message")}
						</td>
											
						<td><br>
						${fieldValue(bean: questionInstance, field: "nbViews")} views<br>
						${fieldValue(bean: questionInstance, field: "nbVotes")} votes
						</td>
					</tr>
				</g:each>	
			</table>				
			
		  </div>
	  </div>
	  
	</body>
</html>