<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
</style>
<title>FIFA Home</title>
</head>
<body>
	<div class="container">
		<header> <br />
		<h1>FIFA</h1>
		</header>
		<div id="menu">
			<span class="glyphicon glyphicon-log-out"></span> <a
				href="/transfer/user/logout">LOG OUT</a>
		</div>
		<br /> <br />

		<div>
			<img height="200" width="250" src="/images/fifa.jpg" />
		</div>
		<br /> 
		
		<span class="glyphicon glyphicon-hand-right"></span> <a href="/transfer/org/playeradd">Add Players</a><br /><br />
		<span class="glyphicon glyphicon-hand-right"></span> <a href="/transfer/org/closedeals">Close Deals</a><br /><br /> 
		<span class="glyphicon glyphicon-hand-right"></span> <a href="/transfer/org/unsoldplayers">Sell unsold players</a><br /> <br />
		<span class="glyphicon glyphicon-hand-right"></span> <a href="/transfer/org/reports">Sales Report</a><br /><br />
		 
	</div>
</body>
</html>