<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Car</title>
</head>
<body>
	<h1>Edit Car</h1>
	<form:form method="POST" action="/springmvc/editAndSave">
		<table>
			<tr>
				<td>Car ID:</td>
				<td><form:input path="carId" readonly="true" /></td>
			</tr>
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