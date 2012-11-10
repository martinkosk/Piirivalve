<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report an incident</title>
</head>
<body>
	<form method="post" action="reportIncident">
		<table>
			<tr>
				<td><label>Start</label></td>
				<td><input type="text" name="start"></td>
			</tr>
			<tr>
				<td><label>End</label></td>
				<td><input type="text" name="end"></td>
			</tr>
			<tr>
				<td><label>Location</label></td>
				<td><input type="text" name="location"></td>
			</tr>
			<tr>
				<td><label>Description</label></td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td><label>Count of involved guards</label></td>
				<td><input type="text" name="involvedGuardCount"></td>
			</tr>
			<tr>
				<td><label>Status</label></td>
				<td><input type="text" name="status"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>