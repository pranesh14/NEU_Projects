<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

header{
                background-color:#37474F;background-size:cover;background-position:center;height:100px;color:white;
            }


h1 {
	text-align: center;
	font-family: "Georgia", Times, serif;
}
</style>

<title>Register New Team</title>
</head>
<body>
<div class="container">
		<header>
			<br />
	<h1>Register Team and Account Details</h1>
	</header>
		<br />

	<form:form action="/transfer/team/register" commandName="team"
		method="post" enctype="multipart/form-data">

	Name: <form:input path="name" class="form-control"/>
		<font color="red"><form:errors path="name" /></font>
		<br />
		<br />
	Country:
		<select name="country" class="dropdown form-control">
			<c:forEach var="country" items="${sessionScope.countries}">
				<option value="${country}">${country}</option>
			</c:forEach>
		</select>
		<br />
		<br /> 
	Select team logo: <input type="file" name="photo" class="form-control"/>
		<br />
		<br />
	Account Number: <form:input path="account.accountNumber" class="form-control"/>
		<font color="red"><form:errors path="account.accountNumber" /></font>
		<br />
		<br />

		<input type="submit" value="Save" class="btn btn-default"/>

	</form:form>
</div>
</body>
</html>