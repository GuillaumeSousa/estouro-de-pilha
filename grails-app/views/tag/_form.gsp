<%@ page import="fr.isima.estouroDePilha.Tag" %>

<div class="fieldcontain ${hasErrors(bean: tagInstance, field: 'tagname', 'error')} ">
	<label for="tagname">
		<g:message code="tag.tagname.label" default="Tagname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="tagname" required="" value="${tagInstance?.tagname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tagInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="tag.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" value="${tagInstance?.description}"/>
</div>



