<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
	font-size: 14pt;
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
<title>Search Players</title>
</head>
<body>
	<div class="container">
		<header>
			<br />
			<h1>${team.name}</h1>
		</header>
		<div id="menu">
			<span class="glyphicon glyphicon-home"></span> <a
				href="/transfer/team/home">HOME</a><br />
		</div>

		<br/>
		<span class="glyphicon glyphicon-search"></span><label>Search
			Players</label> <br />
		<br />

		<form action="/transfer/team/searchplayers" method="post">

			Type:<br /> <select name="type" class="form-control">
				<option value="">--Select--</option>
				<c:forEach var="type" items="${sessionScope.types}">
					<option value="${type.type}">${type.type}</option>
				</c:forEach>
			</select> <br /> 
			
			Position:<br /> <select name="position" class="form-control">
				<option value="">--Select--</option>
				<c:forEach var="position" items="${sessionScope.positions}">
					<option value="${position.position}">${position.position}</option>
				</c:forEach>
			</select> <br /> <input type="submit" value="Search" class="btn btn-default"/>

		</form>
	</div>

</body>
</html>

