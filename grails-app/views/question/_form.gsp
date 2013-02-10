<%@ page import="fr.isima.estouroDePilha.Question" %>


<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'subject', 'error')} ">
	<label for="subject">
		<g:message code="question.subject.label" default="Subject" />
		
	</label>
	<g:textField name="subject" value="${questionInstance?.subject}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'message', 'error')} ">
	<label for="message">
		<g:message code="question.message.label" default="Message" />
		
	</label>
	<g:textArea style="width:60%;" name="message" value="${questionInstance?.message}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'tags', 'error')} ">
	<label for="tags">
		<g:message code="question.tags.label" default="Tags" />

	</label>
	<g:select name="tags" from="${fr.isima.estouroDePilha.Tag.list()}" multiple="multiple" optionKey="id" optionValue="tagname" size="5" value="${questionInstance?.tags*.id}" class="many-to-many"/>
</div>

