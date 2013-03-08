<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>User answer List</title>
</head>
<body>
  	<div class="body">
		<!-- List answers -->
		<ol class="property-list question">
			<div id="answers">
				<g:render template="/answer/listAnswersToQuestion" var="answer" collection="${answerInstanceList}"/>
			</div>	
		</ol>
	</div>
</body>
</html>