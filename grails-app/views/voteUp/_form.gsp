<%@ page import="fr.isima.estouroDePilha.VoteUp" %>



<div class="fieldcontain ${hasErrors(bean: voteUpInstance, field: 'contributor', 'error')} required">
	<label for="contributor">
		<g:message code="voteUp.contributor.label" default="Contributor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="contributor" name="contributor.id" from="${fr.isima.estouroDePilha.User.list()}" optionKey="id" required="" value="${voteUpInstance?.contributor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: voteUpInstance, field: 'post', 'error')} required">
	<label for="post">
		<g:message code="voteUp.post.label" default="Post" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="post" name="post.id" from="${fr.isima.estouroDePilha.Post.list()}" optionKey="id" required="" value="${voteUpInstance?.post?.id}" class="many-to-one"/>
</div>

