<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Team Home</title>

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
</head>
<body>
	<div class="container">
		<header> <br />
		<h1>${team.name}</h1>
		</header>
		<div id="menu">
			<span class="glyphicon glyphicon-log-out"></span> <a
				href="/transfer/user/logout">LOG OUT</a>
		</div>
		<br /> <br />

		<div>
			<img height="200" width="250" src="/teams/${team.logo}" />
		</div>
		<br /> <span class="glyphicon glyphicon-hand-right"></span> <a
			href="/transfer/team/players">View team players</a> <br />
		<br /> <span class="glyphicon glyphicon-hand-right"></span> <a
			href="/transfer/team/searchplayers">Search players</a> <br />
		<br /> <span class="glyphicon glyphicon-hand-right"></span> <a
			href="/transfer/team/auction">Show auctioned team players</a> <br />
		<br />
	</div>
</body>
</html>