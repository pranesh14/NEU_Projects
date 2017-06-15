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

label {
	font-size: 14pt;
	color:#E57373;
}

ul {
	background-color: #CFD8DC;
	list-style-type: none;
	text-align: left;
}

li {
	width: 100px;
	display: inline-block;
	padding: 10px;
}

ui li:hover {
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
<script>
	window.onload = function() {
		var bool = document.getElementById("hid_active").value;
		var same = document.getElementById("sameTeam").value;
		if (bool == "true" || same == "true") {
			document.getElementById("bid").disabled = true;
			document.getElementById("sub").disabled = true;
		}
		setInterval(ajax, 1000);
	}

	function ajax() {
		var url = "/transfer/ajaxcall";
		var request = new HttpRequest(url, displayTime_callBack);
		request.send();
	}

	function displayTime_callBack(sResponseText) {
		document.getElementById('time').textContent = sResponseText;
	}

	function HttpRequest(sUrl, fpCallback) {
		this.request = this.createXmlHttpRequest();
		this.request.open("GET", sUrl, true);
		var tempRequest = this.request;
		function request_readystatechange() {
			if (tempRequest.readyState == 4) {
				if (tempRequest.status == 200) {
					fpCallback(tempRequest.responseText);
				}
			}
		}
		this.request.onreadystatechange = request_readystatechange;
	}

	HttpRequest.prototype.createXmlHttpRequest = function() {
		if (window.XMLHttpRequest) {
			var oHttp = new XMLHttpRequest();
			return oHttp;
		} else if (window.ActiveXObject) {
			var versions = [ "MSXML2.XmlHttp.6.0", "MSXML2.XmlHttp.3.0" ];
			for (var i = 0; i < versions.length; i++) {
				try {
					var oHttp = new ActiveXObject(versions[i]);
					return oHttp;
				} catch (error) {
					//do nothing here
				}
			}
		}
		return null;
	}

	HttpRequest.prototype.send = function() {
		this.request.send(null);
	}
</script>
<title>View Player</title>
</head>
<body>
	<div class="container">
		<header>
			<br />
			<h1>${team.name}</h1>
		</header>
		<ul>
			<li><span class="glyphicon glyphicon-home"></span> <a
				href="/transfer/team/home">HOME</a></li>
		</ul>
		<br />
		<span class="glyphicon glyphicon-refresh"></span><a href="/transfer/team/playerbid.htm?playerid=${player.playerId}" class="btn btn-default">Refresh</a>
		<br/><br/>
		<form action="/transfer/team/playerbid" method="post">

			<input type="hidden" id="hid_active" name="active" value="${bidOver}" />
			<input type="hidden" id="sameTeam" name="same" value="${sameTeam}" />

			<div>
				<img height="200" width="250" src="/players/${player.image}" /> <br />
			</div>
			<br />
			<label>Time left:<span id="time"></span></label> <br />

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
					<td>Current Bid Amount:</td>
					<td>${bid}</td>
				</tr>
				<tr>
					<td><input type="number" id="bid" name="bidAmount"
						min="${bid}" max="10000000" class="form-control" /></td>
					<td><input type="submit" id="sub" value="Bid on Player"
						class="btn btn-default" /></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>
