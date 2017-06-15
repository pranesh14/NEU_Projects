<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Final Project</title>

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
h1 {
	color: white;
	text-align: center;
	font-family: "Georgia", Times, serif;
}

body {
	background: url("http://i.imgur.com/yRYbDNi.jpg") no-repeat center;
}

tr td {
	padding-top: 15px;
}

.text {
	color: white;
	font-size: 12pt;
}

span {
	background-color: white;
}

a {
	font-size: 12pt;
	color:#FAFAFA;
}
</style>

</head>

<body>

	<div class="container">
		<h1>FIFA 2020</h1>
		<br /> <br />

		<form action="user/login" method="post">

			<table>
				<tr>
					<td class="text"><b>User Name:</b></td>
					<td><input name="username" size="30" required="required"
						class="form-control" /></td>
				</tr>
				<tr>
					<td class="text"><b>Password:</b></td>
					<td><input type="password" name="password" size="30"
						required="required" class="form-control" /></td>
				</tr>
				<tr>
					<td colspan="2"><span class="glyphicon glyphicon-user"></span>
						<input type="submit" value="Login" class="btn btn-default" /></td>

				</tr>
				<tr>
					<td colspan="2"><b><a href="user/register">Register
								new team</a></b></td>
				</tr>
			</table>

		</form>
	</div>


</body>
</html>

