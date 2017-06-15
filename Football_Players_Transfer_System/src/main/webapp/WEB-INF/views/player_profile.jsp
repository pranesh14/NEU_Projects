<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<span class="glyphicon glyphicon-home"></span>  <a href="/transfer/team/home">HOME</a>
	<br /></div><br />

	<form action="/transfer/player/sell" method="post">

		<div>
			<img height="200" width="250" src="/players/${player.image}" />
		</div>
		<br />
		
		<input type="hidden" name="id" value="${player.playerId }" />

		<table class="table">
			<tr>
				<td>Name:</td>
				<td>${player.name}</td>
			</tr>
			<tr>
				<td>Country:</td>
				<td>${player.country}</td>
			</tr>
			<tr>
				<td>Position:</td>
				<td>${position.position}</td>
			</tr>
			<tr>
				<td>Type:</td>
				<td>${type.type}</td>
			</tr>
			<tr>
				<td>Pace:</td>
				<td>${attributes.pace}</td>
			</tr>
			<tr>
				<td>Shooting:</td>
				<td>${attributes.shooting}</td>
			</tr>
			<tr>
				<td>Passing:</td>
				<td>${attributes.passing}</td>
			</tr>
			<tr>
				<td>Dribbling:</td>
				<td>${attributes.dribbling}</td>
			</tr>
			<tr>
				<td>Defending:</td>
				<td>${attributes.defending}</td>
			</tr>
			<tr>
				<td>Physical:</td>
				<td>${attributes.physical}</td>
			</tr>
			<tr>
				<td colspan="2"><span class="glyphicon glyphicon-open-file"> </span><a href="/transfer/team/playercontract">View
						Contract</a></td>
			</tr>
			<tr>
				<td><input type="number" name="startBid" max="1000000" class="form-control"/></td>
				<td><input type="submit" value="Sell Player" class="btn btn-default"/></td>
			</tr>
		</table>

	</form>
</div>
</body>
</html>
