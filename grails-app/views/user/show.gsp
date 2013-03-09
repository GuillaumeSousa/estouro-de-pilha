
<%@ page import="fr.isima.estouroDePilha.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="show-user" class="user-header" role="main">
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${userInstance?.id}" />
					<g:editUserControl shownUserId="${userInstance?.id}" />
				</fieldset>
			</g:form>
			<h1>
				<g:if test="${userInstance?.pseudo}">
					<span class="property-value" aria-labelledby="subject-label"><g:fieldValue bean="${userInstance}" field="pseudo"/></span>		
				</g:if>	
			</h1>
			
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<!--  User Description -->
			<div class="user-header-left">
			
			  <div class="gravatar">
			  	<g:if test="${userInstance.avatar}">
			  		<img class="avatar" src="${createLink(controller:'user', action:'avatar_image', id:userInstance.id)}" />
			  	</g:if>
			  	<div class="reputation">
					<h1>
						<a>
						${message(code: 'user.show.reputation', default: 'Reputation')}
						</a>
					</h1>
					<span>
						<g:fieldValue bean="${userInstance}" field="reputation"/>
					</span>
				</div>
			  </div>

				
				<div class="data">
		            <table>
		                <tbody>
		                    <tr>
		                        <th>${message(code: 'user.show.bio', default: 'bio')}</th>
		                        <td>${message(code: 'user.show.website', default: 'website')}</td>
		                        <td><g:fieldValue bean="${userInstance}" field="website"/></td>
		                    </tr>
		                    <tr>
		                        <th></th>
		                        <td>${message(code: 'user.show.location', default: 'location')}</td>
		                        <td class="label adr"><g:fieldValue bean="${userInstance}" field="location"/></td>
		                    </tr>
		                    <tr>
		                        <th></th>
		                        <td>${message(code: 'user.show.email', default: 'email')}</td>
		                        <td><g:fieldValue bean="${userInstance}" field="login"/></td>
		                    </tr>
		                    <tr>
		                        <th></th>
		                        <td>${message(code: 'user.show.realName', default: 'real name')}</td>
		                        <td><g:fieldValue bean="${userInstance}" field="realName"/></td>
		                    </tr>
		                    <tr>
		                        <th></th>
		                        <td>${message(code: 'user.show.birthDate', default: 'birth date')}</td>
		                        <td><g:formatDate date="${userInstance?.birthDate}" format="dd/MM/yyyy" /></td>
		                    </tr>
		                </tbody>
		                <tbody>
		                    <tr>
		                        <th>${message(code: 'user.show.visits', default: 'visits')}</th>
		                        <td>${message(code: 'user.show.registerDate', default: 'register date')}</td>
		                        <td><g:formatDate date="${userInstance?.registerDate}" format="dd/MM/yyyy"/></td>
		                    </tr>
		                </tbody>
		            </table>
            	</div>
			</div>
			
			<!-- About me -->
			<div class="user-about-me">
				<p><b>${message(code: 'user.show.aboutMe', default: 'About me:')}</b></p>
                <p><g:fieldValue bean="${userInstance}" field="aboutMe"/></p>
	        </div>
	        <br>
	        
	        
		</div>
		   
    	
		<div>
			<!-- Answers -->
			<div id="user-panel-answers" class="user-panel user-panel-left">
			    <div class="subheader">
			        <h1>
			        	<a>
			   				<g:link action="listUserAnswers" params="[id:userInstance.id]"><span class='count'>${userInstance?.answers.size()}</span> ${message(code: 'user.show.answers', default: 'Answer(s)')}</g:link>
						</a>
					</h1>
			    </div>
			</div>
			
			<!-- Questions -->
			<div id="user-panel-questions" class="user-panel">
			    <div class="subheader">
			        <h1>
			        	<a>
			    			<g:link action="listUserQuestions" params="[id:userInstance.id]"><span class='count'>${userInstance?.questions.size()}</span> ${message(code: 'user.show.questions', default: 'Question(s)')}</g:link>
						</a>
					</h1>
			    </div>
			</div>
			
			<!-- Badges -->
			<div id="user-panel-badges" class="user-panel">
			    <div class="subheader">
			        <h1>
			        	<a>
			    			<span class='count'>${userInstance?.badges.size()}</span> ${message(code: 'user.show.badges', default: 'Badge(s)')}
						</a>
					</h1>
				</div>
				<div class="user-panel-content">
				
				<table>
					<tbody>
						<g:each in="${userInstance?.badges}" status="i" var="badgeInstance">
								<td>
									<g:link controller="badge" action="show" id="${badgeInstance.id}">${fieldValue(bean: badgeInstance, field: "badgeName")}</g:link>
									<div class="excerpt">
									${message(code: 'user.show.badges.owners', default: 'Owners:')} ${badgeInstance.users.size()}<br>
									${badgeInstance.description}<br>	
									</div>
								</td>
							<%if((i+1)%4 == 0) { %>
							<tr></tr>
							<%} %>
						</g:each>
					</tbody>
				</table>
				</div>
			</div>
			
			
		</div>	
	</body>
</html>
