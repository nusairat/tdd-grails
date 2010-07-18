
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'player.label', default: 'Player')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
		<g:each var="team" in="${teams}"> 
			Team : ${team.name}<br/>
			<g:each var="player" in="${team.players}"> 			
				<dt:format name="${player.name}"/><br/>
			</g:each>
			<hr/>
		</g:each>
    </body>
</html>
