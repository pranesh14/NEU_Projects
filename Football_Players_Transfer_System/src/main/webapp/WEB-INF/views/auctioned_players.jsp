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
<title>Auctioned Players</title>
</head>
<body>
	<div class="container">
		<header>
			<br />
			<h1>${team.name}</h1>
		</header>
		<div id="menu">
			<span class="glyphicon glyphicon-home"></span> <a
				href="/transfer/team/home">HOME</a> <br />
		</div>

		<c:set var="players" value="${auctionedPlayersByPage}"></c:set>
		<c:set var="count" value="${fn:length(players)}"></c:set>

		<c:choose>
			<c:when test="${count>0}">
				<table class="table">
					<tr>
						<th><b>NAME</b></th>
						<th><b>COUNTRY</b></th>
						<th><b>START BID AMOUNT</b></th>
					</tr>
					<c:forEach var="player" items="${auctionedPlayersByPage}">
						<tr>
							<td>${player.name}</td>
							<td>${player.country}</td>
							<td>${player.startBid}</td>
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
				<li><a href="/transfer/team/auctionpage.htm?number=${i}">${i}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
