<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
header {
	background-color: #37474F;
	background-size: cover;
	background-position: center;
	height: 100px;
	color: white;
}

h1 {
	text-align: center;
	font-family: "Georgia", Times, serif;
}

label{
	font-size: 16pt;
}

#menu {
	background-color: #CFD8DC;
	list-style-type: none;
	text-align: left;
}

#menu:hover {
	background-color: #B0BEC5;
	border-bottom: 2px solid black;
	color: white;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Team Players</title>
</head>
<body>
	<div class="container">
		<header>
			<br />
			<h1>${team.name}</h1>
		</header>
		<div id="menu">
			<span class="glyphicon glyphicon-home"></span>  <a href="/transfer/team/home">HOME</a> <br />
		</div>

		<h2>Team Players</h2>

		<c:set var="players" value="${teamPlayersByPage}"></c:set>
		<c:set var="count" value="${fn:length(players)}"></c:set>

		<c:choose>
			<c:when test="${count>0}">
				<table class="table">
					<tr>
						<th><b>PLAYERS</b></th>
						<th></th>
					</tr>
					<c:forEach var="player" items="${teamPlayersByPage}">
						<tr>
							<td>${player.name}</td>
							<td><a
								href="/transfer/team/playerview.htm?playerid=${player.playerId}">View
									Profile</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<span class="glyphicon glyphicon-remove-sign"></span>
				<label>No Players to list</label>
			</c:otherwise>
		</c:choose>
		<br />

		<ul class="pagination">
			<c:forEach var="i" begin="1" end="${sessionScope.pages}">
				<li><a href="/transfer/team/playerspage.htm?number=${i}">${i}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
