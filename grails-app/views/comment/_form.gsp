<%@ page import="fr.isima.estouroDePilha.Comment" %>



<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'message', 'error')} ">
	<label for="message">
		<g:message code="comment.message.label" default="Message" />
		
	</label>
	<g:textArea name="message" cols="40" rows="5" maxlength="10000" value="${commentInstance?.message}"/>
</div>

<div hidden="true" class="fieldcontain ${hasErrors(bean: commentInstance, field: 'post', 'error')} required">
	<label for="post">
		<g:message code="comment.post.label" default="Post" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="post.id" from="${postId}"required="" value="${commentInstance?.post?.id}" class="many-to-one"/>
</div>


