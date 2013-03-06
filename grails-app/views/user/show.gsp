
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
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<div class="user-header-left">
			
			  <div class="gravatar">
			  	<g:if test="${userInstance.avatar}">
			  		<img class="avatar" src="${createLink(controller:'user', action:'avatar_image', id:userInstance.id)}" />
			  	</g:if>
			  	<div class="reputation">
					<span>
						<g:fieldValue bean="${userInstance}" field="reputation"/>
					</span>
					reputation(s)
				</div>
			  </div>

				
				<div class="data">
		            <table>
		                <tbody>
		                    <tr>
		                        <th>bio</th>
		                        <td>website</td>
		                        <td><g:fieldValue bean="${userInstance}" field="website"/></td>
		                    </tr>
		                    <tr>
		                        <th></th>
		                        <td>location</td>
		                        <td class="label adr"><g:fieldValue bean="${userInstance}" field="location"/></td>
		                    </tr>
		                    <tr>
		                        <th></th>
		                        <td>email</td>
		                        <td><g:fieldValue bean="${userInstance}" field="login"/></td>
		                    </tr>
		                    <tr>
		                        <th></th>
		                        <td>real name</td>
		                        <td><g:fieldValue bean="${userInstance}" field="realName"/></td>
		                    </tr>
		                    <tr>
		                        <th></th>
		                        <td>birth date</td>
		                        <td><g:formatDate date="${userInstance?.birthDate}" format="dd/MM/yyyy" /></td>
		                    </tr>
		                </tbody>
		                <tbody>
		                    <tr>
		                        <th>visits</th>
		                        <td>register date</td>
		                        <td><g:formatDate date="${userInstance?.registerDate}" format="dd/MM/yyyy"/></td>
		                    </tr>
		                </tbody>
		            </table>
            	</div>
			</div>
			<div class="user-about-me">
                <p><g:fieldValue bean="${userInstance}" field="aboutMe"/></p>
	        </div>
	        <br>
		</div>
		
		
		<div id="user-panel-answers" class="user-panel user-panel-left">
		    <div class="subheader">
		        <h1><a href="/users/2062532/guie?tab=answers">
		    <span class='count'>0</span> Answers
		</a></h1>
		            <div class="subtabs user-panel-subtabs">
		            mettre tris
		        </div>
		    </div>
		
		    <div class="user-panel-content">
		        
		        <div class="empty">You have not answered any questions</div>
		
		    </div>
		
		    <div class="user-panel-footer">
		
		    </div>
		</div>
		<div id="user-panel-reputation" class="user-panel">
		    <div class="subheader">
		        <h1><a href="/users/2062532/guie?tab=reputation">
		    <span class="count">1</span> Reputation
		</a></h1>
		
		        </div>
		
		    <div class="user-panel-content">
		        
		
		
		        <div class="empty">You have no reputation changes</a></div>
		
		    </div>
		
		    <div class="user-panel-footer">
		
		    </div>
		</div>
		<div id="user-panel-questions" class="user-panel user-panel-left">
		    <div class="subheader">
		        <h1><a href="/users/2062532/guie?tab=questions">
		    <span class='count'>0</span> Questions
		</a></h1>
		            <div class="subtabs user-panel-subtabs">
		            mettre tris
		        </div>
		    </div>
		
		    <div class="user-panel-content">
		        
		        <div class="empty">You have not asked any questions</a></div>
		
		    </div>
		
		    <div class="user-panel-footer">
		
		    </div>
		</div>
		<div id="user-panel-tags" class="user-panel">
		    <div class="subheader">
		        <h1><a href="/users/2062532/guie?tab=tags">
		    <span class='count'>0</span> Tags
		</a></h1>
		        </div>
		
		    <div class="user-panel-content">
		        
		        <div class="empty">You have not participated in any tags</a></div>
		
		    </div>
		
		    <div class="user-panel-footer">
		
		    </div>
		</div>
		
		<div id="user-panel-badges" class="user-panel">
		    <div class="subheader">
		        <h1><a href="/users/2062532/guie?tab=badges">
		    <span class='count'>2</span> Badges
		</a></h1>
		        <div class="subtabs user-panel-subtabs">
		            mettre tris
		        </div>
		    </div>
		
		    <div class="user-panel-content">
		        
		        <table class="user-badges">
		            <tbody>
		                <tr>                
		                    <td>
		                        <a href="/badges/2600/informed?userid=2062532" title="bronze badge: Read the entire about page" class="badge"><span class="badge3"></span>&nbsp;Informed</a>
		
		                        
		                    </td>                                                                                           
		                    <td>
		                        <a href="/badges/1306/analytical?userid=2062532" title="bronze badge: Visited every section of the FAQ" class="badge"><span class="badge3"></span>&nbsp;Analytical</a>
		
		                        
		                    </td>                                                                                           
		                </tr>               
		            </tbody>
		        </table>
		
		    </div>
		
		    <div class="user-panel-footer">
		
		    </div>
		</div>
		
		<div id="user-panel-votes" class="user-panel">
		    <div class="subheader">
		        <h1>
		    <span class='count'>0</span> Votes Cast
		</h1>
		        </div>
		
		    <div class="user-panel-content">
		        
		        <div class="empty">You have not cast any votes</div>
		
		    </div>
		
		    <div class="user-panel-footer">
		
		    </div>
		</div>
		
		<div id="user-panel-vote" class="user-panel">
		    <div class="subheader">
		        <h1>
				    <span class='count'></span>
				</h1>
		        </div>
		
		    <div class="user-panel-content">
		        
		        <div class="empty"></div>
		
		    </div>
		
		    <div class="user-panel-footer">
		
		    </div>
		</div>

		
		
		
		<div id="buttonsBar" class="content scaffold-show">
			<g:form class="content scaffold-show">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${userInstance?.id}" />
					<g:editUserControl shownUserId="${userInstance?.id}"/>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
