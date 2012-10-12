<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="borderPost" class="ee.itcollege.piirivalve.model.BorderPost" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lisa piiripunkt</title>
</head>
<body>
	<h3>Sisesta piiripunkti andmed</h3>
	<form method="post" action="SaveBorderPost.jsp">
		Nimi: <input type="text" name="name" value="${borderPost.name}" /> <br/>
		Aadress: <input type="text" name="address" value="${borderPost.address}" /> <br/>
		Valvurite arv: <input type="text" name="guardCount" value="${borderPost.guardCount}" /> <br/>
		<button type="submit">Sisesta</button> 
	</form>
</body>
</html>