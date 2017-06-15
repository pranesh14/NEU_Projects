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

#span {
	color: red;
}

h1 {
	text-align: center;
	font-family: "Georgia", Times, serif;
}
</style>
<script>
	function validate() {
		var pass = document.getElementById('pass').value;
		var pass1 = document.getElementById('pass1').value;
		if (pass != pass1) {
			document.getElementById('span').textContent = 'Password and Confirm password fields should match';
			return false;
		}
	}
</script>

<title>Register New Team Admin</title>
</head>
<body>
	<div class="container">
		<header>
			<br />
			<h1>Register Team Admin</h1>
		</header>
		<br />

		<form:form action="/transfer/user/register" commandName="user"
			method="post" onsubmit="return validate()">

	Name: <form:input path="name" class="form-control" />
			<font color="red"><form:errors path="name" /></font>
			<br />
			<br />
	User Name: <form:input path="username" class="form-control" />
			<font color="red"><form:errors path="username" /></font>
			<br />
			<br />
	Password: <form:password path="password" id="pass" class="form-control" />
			<font color="red"><form:errors path="password" /></font>
			<br />
			<br />
	Confirm Password: <input type="password" id="pass1"
				class="form-control" />
			<span id="span"></span>
			<br />
			<br />

			<input type="submit" value="Save" class="btn btn-default" />

		</form:form>
	</div>
</body>
</html>