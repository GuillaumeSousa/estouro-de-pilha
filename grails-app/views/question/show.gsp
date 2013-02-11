
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

		<div id="show-question" class="content scaffold-show" role="main">
			<h1>
				<g:if test="${questionInstance?.subject}">
					<span class="property-value" aria-labelledby="subject-label"><g:fieldValue bean="${questionInstance}" field="subject"/></span>		
				</g:if>	
			</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list question">
			
			<table>
				<tr>
					<td>
						<div>
							<g:remoteLink action="incrVotes" id="${questionInstance.id}" update="nbVotes">
						        <g:img dir="images" file="arrow-up.png" width="40px" height="40px"/>
						      </g:remoteLink>
						        <div class="property-value" style="margin-left: 10px;" id="nbVotes">
						          ${questionInstance.nbVotes}
						        </div> 
						      <g:remoteLink action="decrVotes" id="${questionInstance.id}" update="nbVotes">
						        <g:img dir="images" file="arrow-down.png" width="40px" height="40px"/>
						     </g:remoteLink>
					    </div>
					</td>
					<td>
						<g:if test="${questionInstance?.message}">	
							<span class="property-value" aria-labelledby="message-label"><g:fieldValue bean="${questionInstance}" field="message"/></span>
						</g:if>
						
						<div class="post-signature owner">
							<g:if test="${questionInstance?.postedDate}">
							<li class="fieldcontain">
									<span class="property-value" aria-labelledby="postedDate-label"><g:formatDate date="${questionInstance?.postedDate}" format="dd/MM/yyyy - HH:mm" /></span>					
							</li>
							</g:if>
							<g:if test="${questionInstance?.author}">
							<li class="fieldcontain">
								<g:link controller="User" action="show" id="${questionInstance.author.id}"><span class="property-value" aria-labelledby="author-label"><g:fieldValue bean="${questionInstance}" field="author.pseudo"/></span></g:link>
							</li>
						</g:if>
						</div>
						<li class="fieldcontain">
							<span id="nbViews-label" class="property-label"><g:message code="question.nbViews.label" default="viewed" /></span>	
							<span class="property-value" aria-labelledby="nbViews-label"><g:fieldValue bean="${questionInstance}" field="nbViews"/></span>
						</li>
					</td>
				</tr>
				<tr>
					<td>
						<g:if test="${questionInstance?.tags}">
						<li class="fieldcontain">				
							<g:each in="${questionInstance.tags}" var="t">
							<!-- <span class="property-value" aria-labelledby="tags-label"><g:link controller="tag" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
							-->
							<g:link class="post-tag" controller="Tag" action="taggedQuestions" id="${t.id}">${fieldValue(bean: t, field: "tagname")}</g:link>
							</g:each>
						</li>
						</g:if>
					</td>
				</tr>
			</table>
							
			<g:if test="${questionInstance?.comments}">
			<li class="fieldcontain">
				<span id="comments-label" class="property-label"><g:message code="question.comments.label" default="Comments" /></span>
				
					<g:each in="${questionInstance.comments}" var="c">
					<span class="property-value" aria-labelledby="comments-label"><g:link controller="comment" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
					</g:each>
				
			</li>
			</g:if>
				
			<g:if test="${questionInstance?.answers}">
			<li class="fieldcontain">
				<table>
					<g:each in="${questionInstance.answers}" var="a">
						<tr>
							<td>
								${fieldValue(bean: a, field: "message")}
							</td>
						</tr>
					</g:each>
				</table>
			</li>
			</g:if>				
			
			<h1>
				<span class="property-value" aria-labelledby="subject-label">Your Answer</span>		
			</h1>
			
			<g:form controller="question" action="addAnswer" id="${questionInstance.id}">	
		        <g:textArea class="property-value" style="width:90%; height:200px;" name="messageAnswer" id="messageAnswer"/>
		        <g:submitButton name="postAnswer" style="background-color: #4a6b82; color:white;" value="Post Your Answer" />
		    </g:form>	
		    
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
