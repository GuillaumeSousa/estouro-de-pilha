<%@ page import="fr.isima.estouroDePilha.Tag" %>



<div class="fieldcontain ${hasErrors(bean: tagInstance, field: 'questions', 'error')} ">
	<label for="questions">
		<g:message code="tag.questions.label" default="Questions" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: tagInstance, field: 'tagname', 'error')} ">
	<label for="tagname">
		<g:message code="tag.tagname.label" default="Tagname" />
		
	</label>
	<g:textField name="tagname" value="${tagInstance?.tagname}"/>
</div>

