<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MDC</title>
</head>
<body>
<h2>Class Edit Form</h2>
	<form action = "editClassServlet" method = "post">
	Class-Name: <input type = "text" name = "className" value = "${classToEdit.className}">
	Instructor-Id: <input type = "text" name = "instructorId" value = "${classToEdit.instructorId}">
	<input type = "hidden" name = "classId" value ="${classToEdit.classId}">
	<input type = "submit" value= "Save Edited class">
 	</form>

</body>
</html>