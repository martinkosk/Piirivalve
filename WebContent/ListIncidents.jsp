<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incidents</title>
</head>
<body>
	<table>
		<tr>
			<th>Start</th>
			<th>End</th>
			<th>Location</th>
			<th>Description</th>
			<th>Count of involved guards</th>
			<th>Status</th>
		</tr>
		<c:forEach items="${incidents}" var="incident">
			<tr>
				<td>${incident.start}</td>
				<td>${incident.end}</td>
				<td>${incident.location}</td>
				<td>${incident.description}</td>
				<td>${incident.involvedGuardCount}</td>
				<td>${incident.status}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>