<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'logo_estouro_de_pilha.png')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css"> 
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<!--<link rel="stylesheet" href="/twitter-bootstrap/twitter-bootstrap-v2/docs/assets/css/bootstrap.css"> -->
		<g:layoutHead/>
		<g:javascript library="jquery"/>
		<r:layoutResources/>
	</head>
	<body>
		<div id="header" role="banner">
			<div class="topbar">
	          <div class="global-nav" data-section-term="top_nav">
	            <div class="global-nav-inner">
	              <div class="container">
	            	<div class="logbar">
						<ul>
							<li><g:loginControl/></li>
							<li><g:newUserControl/></li>
							<li><g:profileControl/></li>
						</ul>
					</div>
	              </div>
	             </div>
        		</div>
        	</div>

			<div class="nav">
				<ul>
					<li><a class="home" href="${createLink(uri: '/')}">${message(code: 'topbar.home.label', default:"Estouro De Pilha")}</a></li>
			 		<li><g:link controller="Question" action="list">${message(code: 'topbar.questions.label', default:"Questions")}</g:link></li>
					<li><g:link controller="User" action="list">${message(code: 'topbar.users.label', default:"Users")}</g:link></li>
					<li><g:link controller="Tag" action="list">${message(code: 'topbar.tags.label', default:"Tags")}</g:link></li>
					<li><g:link controller="Badge" action="list">${message(code: 'topbar.badges.label', default:"Badges")}</g:link></li>
					<li><g:link controller="Question" action="create" class="create">${message(code: 'topbar.askQuestion.label', default:"Ask Question")}</g:link></li>
				</ul>
			</div>
		</div>

		<g:layoutBody/>
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
		<r:layoutResources />
	</body>
</html>
