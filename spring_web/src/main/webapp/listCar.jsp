<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fbt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Cars</title>
</head>
<body>
	<table border=1>
	<thead>
		<tr>
			<th>Car Id</th>
			<th>Manufacturer</th>
			<th>Model</th>
			<th colspan=2>Action</th> 
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items= "${cars}" var="car">
			<tr>
				<td><c:out value="${car.carId}" /> </td>
				<td><c:out value="${car.manufacturer}" /> </td>
				<td><c:out value="${car.model}" /> </td>
				<td><a href="CarController?action=edit&carId=<c:out value="${car.carId}" />">Update</a></td>
				<td><a href="CarController?action=delete&carId=<c:out value="${car.carId}" />">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<p><a href="CarController?action=insert">Add car</a></p> 

</body>
</html>