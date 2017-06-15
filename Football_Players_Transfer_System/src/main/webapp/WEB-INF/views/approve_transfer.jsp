<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous">

<style type="text/css">
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

label{
	font-size: 16pt;
}
</style>
<title>Approve Transfer</title>
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

		<h2>Approve transfers</h2>
		<br />

		<c:choose>
			<c:when test="${not empty  transferredPlayersByPage}">
				<table class="table">
					<tr>
						<th colspan="2"><b>Player Name</b></th>
					</tr>
					<c:forEach var="player" items="${transferredPlayersByPage}">
						<tr>
							<td>${player.name}</td>
							<td><span class="glyphicon glyphicon-transfer"></span> <a
								href="/transfer/org/transfercomplete.htm?playerid=${player.playerId}">Approve
									Transfer</a></td>
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
				<li><a href="/transfer/org/approvalpage.htm?number=${i}">${i}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
