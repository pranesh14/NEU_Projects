<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Sell Player</title>

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
<style>

header {
	background-color: #4E342E;
	background-size: cover;
	background-position: center;
	height: 100px;
	color: white;
}

tr td {
	padding-top: 15px;
}


h1 {
	text-align: center;
	font-family: "Georgia", Times, serif;
}

table {
	border-collapse: collapse;
}

</style>
</head>
<body>
<div class="container">
		<header>
			<br />
			<h1>FIFA</h1>
		</header>
		<br/>
	<h2>Sell ${player.name}</h2><br/>
	<form action="/transfer/player/sell" method="post">
		<table>
			<tr>
				<td>Amount:</td>
				<td><input type="number" name="startBid" max="1000000" required class="form-control" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Put on Auction" class="btn btn-default" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>