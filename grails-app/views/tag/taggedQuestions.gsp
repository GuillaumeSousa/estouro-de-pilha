<%@ page import="fr.isima.estouroDePilha.Tag" %>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tag.label', default: 'Tag')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	
	<body>
	  <div>
	  
	  	  <div style="clear:both">
		  	  <div class="tag-shortdesc" style="margin-top: 10px;">
			    <div>
			    	<p>${fieldValue(bean: tagInstance, field: "description")}</p>
				    <p style="margin-bottom: 0;">
				    <g:link action="show" id="${tagInstance.id}">Learn more...</g:link>
				    </p>
			    </div>
			  </div>
		  </div>
		
		  <div >
		  	<table>
				<g:each in="${taggedQuestionsList}" status="i" var="questionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
						<td>
						<b style="color:#046380; font-size: 9"><g:link controller="Question" action="show" id="${questionInstance.id}">${questionInstance.subject}</g:link></b><br>
						Author : <g:link controller="User" action="show" id="${questionInstance.author.id}"><span class="property-value" aria-labelledby="author-label"><g:fieldValue bean="${questionInstance}" field="author.pseudo"/></span></g:link><br>
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