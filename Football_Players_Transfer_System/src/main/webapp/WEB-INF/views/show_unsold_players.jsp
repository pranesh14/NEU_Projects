<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>

header {
	background-color: #4E342E;
	background-size: cover;
	background-position: center;
	height: 100px;
	color: white;
}

h1 {
	text-align: center;
	font-family: "Georgia", Times, serif;
}

#menu {
	background-color: #D7CCC8;
	list-style-type: none;
	text-align: left;
}

#menu:hover {
	background-color: #BCAAA4;
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
<title>Unsold Players</title>
</head>
<body>
	<div class="container">
		<header>
			<br />
			<h1>FIFA</h1>
		</header>
		<div id="menu">
			<span class="glyphicon glyphicon-home"></span> <a
				href="/transfer/org/home">HOME</a> <br />
		</div>
		<br />

		<c:set var="players" value="${unsoldPlayersByPage}"></c:set>
		<c:set var="count" value="${fn:length(players)}"></c:set>

		<c:choose>
			<c:when test="${count>0}">
				<table class="table">
					<tr>
						<th colspan="2"><b>PLAYERS</b></th>
					</tr>
					<c:forEach var="player" items="${unsoldPlayersByPage}">
						<tr>
							<td>${player.name}</td>
							<td><a
								href="/transfer/org/playersell.htm?playerid=${player.playerId}">Sell
									Player</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<span class="glyphicon glyphicon-remove-sign"></span>
				<label>No Players to list</label>
			</c:otherwise>
		</c:choose>

		<ul class="pagination">
			<c:forEach var="i" begin="1" end="${sessionScope.pages}">
				<li><a href="/transfer/org/unsoldpage.htm?number=${i}">${i}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
