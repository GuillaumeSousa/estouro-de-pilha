<%@ page import="fr.isima.estouroDePilha.Vote" %>



<div class="fieldcontain ${hasErrors(bean: voteInstance, field: 'contributor', 'error')} required">
	<label for="contributor">
		<g:message code="vote.contributor.label" default="Contributor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="contributor" name="contributor.id" from="${fr.isima.estouroDePilha.User.list()}" optionKey="id" required="" value="${voteInstance?.contributor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: voteInstance, field: 'post', 'error')} required">
	<label for="post">
		<g:message code="vote.post.label" default="Post" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="post" name="post.id" from="${fr.isima.estouroDePilha.Post.list()}" optionKey="id" required="" value="${voteInstance?.post?.id}" class="many-to-one"/>
</div>

