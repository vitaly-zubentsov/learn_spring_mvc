<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Car</title>
</head>
<body>
	<h1>Add Car</h1>
	<form:form method="POST" action="addCar">
		<table>
			<tr>
				<td>Manufacturer:</td>
				<td><form:input path="manufacturer" /></td>
			</tr>
			<tr>
				<td>Model:</td>
				<td><form:input path="model" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td>Registration Number:</td>
				<td><form:input path="registrationNumber" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>