<%@ page import="fr.isima.estouroDePilha.VoteDown" %>



<div class="fieldcontain ${hasErrors(bean: voteDownInstance, field: 'contributor', 'error')} required">
	<label for="contributor">
		<g:message code="voteDown.contributor.label" default="Contributor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="contributor" name="contributor.id" from="${fr.isima.estouroDePilha.User.list()}" optionKey="id" required="" value="${voteDownInstance?.contributor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: voteDownInstance, field: 'post', 'error')} required">
	<label for="post">
		<g:message code="voteDown.post.label" default="Post" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="post" name="post.id" from="${fr.isima.estouroDePilha.Post.list()}" optionKey="id" required="" value="${voteDownInstance?.post?.id}" class="many-to-one"/>
</div>

