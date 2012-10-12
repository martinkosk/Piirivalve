<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="borderPost" class="ee.itcollege.piirivalve.model.BorderPost" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Piiripunkti andmed</title>
</head>
<body>
	<h3>Piiripunkti andmed</h3>
	<table>
		<tr>
			<th>Nimi</th>
			<th>Aadress</th>
			<th>Valvurite arv</th>
		</tr>
		<tr>
			<td>${borderPost.name}</td>
			<td>${borderPost.address}</td>
			<td>${borderPost.guardCount}</td>
		</tr>
	</table>
</body>
</html>