<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
</style>

<script>
	function validation() {
		var numbers = /^\d+$/;
		var pace = document.getElementById("pace").value;
		if (!numbers.test(pace)) {
			alert('Please enter numeric value for Pace');
			return false;
		}
		var shooting = document.getElementById("shooting").value;
		if (!numbers.test(shooting)) {
			alert('Please enter numeric value for shooting');
			return false;
		}
		var dribbling = document.getElementById("dribbling").value;
		if (!numbers.test(dribbling)) {
			alert('Please enter numeric value for dribbling');
			return false;
		}
		var defending = document.getElementById("defending").value;
		if (!numbers.test(defending)) {
			alert('Please enter numeric value for defending');
			return false;
		}
		var passing = document.getElementById("passing").value;
		if (!numbers.test(passing)) {
			alert('Please enter numeric value for passing');
			return false;
		}
		var physical = document.getElementById("physical").value;
		if (!numbers.test(physical)) {
			alert('Please enter numeric value for physical');
			return false;
		}
	}
</script>
<title>Add New Player</title>
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

		<h2>Add a new player</h2>

		<form:form action="/transfer/org/playeradd" commandName="player"
			method="post" enctype="multipart/form-data"
			onsubmit="return validation()">

			<table>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" size="45" class="form-control" /> <font color="red"><form:errors
								path="name" /></font></td>
				</tr>
				<tr>
					<td>Upload player picture:</td>
					<td><input type="file" name="photo" class="form-control" /></td>
				</tr>
				<tr>
					<td>Country:</td>
					<td><select name="country" class="form-control">
							<c:forEach var="country" items="${sessionScope.countries}">
								<option value="${country}">${country}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Pace:</td>
					<td><form:input path="playerAttributes.pace" id="pace"
							class="form-control" /> <font color="red"><form:errors
								path="playerAttributes.pace" /></font></td>
				</tr>
				<tr>
					<td>Shooting:</td>
					<td><form:input path="playerAttributes.shooting" id="shooting"
							class="form-control" /> <font color="red"><form:errors
								path="playerAttributes.shooting" /></font></td>
				</tr>
				<tr>
					<td>Passing:</td>
					<td><form:input path="playerAttributes.passing" id="passing"
							class="form-control" /> <font color="red"><form:errors
								path="playerAttributes.passing" /></font></td>
				</tr>
				<tr>
					<td>Dribbling:</td>
					<td><form:input path="playerAttributes.dribbling"
							id="dribbling" class="form-control" /> <font
						color="red"><form:errors path="playerAttributes.dribbling" /></font></td>
				</tr>
				<tr>
					<td>Defending:</td>
					<td><form:input path="playerAttributes.defending"
							id="defending" class="form-control" /> <font
						color="red"><form:errors path="playerAttributes.defending" /></font></td>
				</tr>
				<tr>
					<td>Physical:</td>
					<td><form:input path="playerAttributes.physical" id="physical"
							class="form-control" /> <font color="red"><form:errors
								path="playerAttributes.physical" /></font></td>
				</tr>
				<tr>
					<td>Type:</td>
					<td><form:select path="playerTypeCnfg.type"
							items="${sessionScope.types}" required="required"
							class="form-control" /></td>
				</tr>
				<tr>
					<td>Position:</td>
					<td><form:select path="playerPositionCnfg.position"
							items="${sessionScope.positions}" required="required"
							class="form-control" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Add Player"
						class="btn btn-default" /></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>