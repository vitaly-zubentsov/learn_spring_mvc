<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Car list</title>
</head>
<body>
	<h1>Car list</h1>
	<table border="2" width="60%" cellpadding="2">
		<thead>
			<tr>
				<th>Car ID:</th>
				<th>Manufacturer:</th>
				<th>Model:</th>
				<th>City:</th>
				<th>Registration Number:</th>
				<th>Edit:</th>
				<th>Delete:</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="car">
				<tr>
					<td><c:out value="${car.carId}" /></td>
					<td><c:out value="${car.manufacturer}" /></td>
					<td><c:out value="${car.model}" /></td>
					<td><c:out value="${car.city}" /></td>
					<td><c:out value="${car.registrationNumber}" /></td>
					<td><a href="editCar/${car.carId}">Edit</a></td>
					<td><a href="deleteCar/${car.carId}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="addCar">Add new car</a>
	</p>
</body>
</html>