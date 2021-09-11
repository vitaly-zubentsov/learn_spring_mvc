<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fbt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new car</title>
<link type="text/css"
href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="syelesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
</head>
<body>
<form method="POST" action="CarController?action=" name="frmAddCar">
	Car ID: <input type="text" readonly="readonly" name="carId" value="<c:out value="${car.carId}"/>" />
	<br>
	Manufacturer : <input type="text" name="manufacturer" value="<c:out value="${car.manufacturer}"/>" />
	<br>
	Model : <input type="text" name="model" value="<c:out value="${car.model}"/>" />
	<br>
	<input type="submit" value="sumbit"/>
</form>

</body>
</html>