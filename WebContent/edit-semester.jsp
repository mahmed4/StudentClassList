<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Semester editing form</title>
</head>
<body>
<h2>Edit an Existing Class List for "${listToEdit.semesterName}" Semester</h2>
	<form action="editSemesterDetailsServlet" method="post">
		<input type="hidden" name="semesterId" value="${listToEdit.semesterId}"> Semester
		Name: <input type="text" name="semesterName"
			value="${listToEdit.semesterName}"><br /> 
			<br />Start Date: <input
			type="text" name="month" placeholder="mm" size="4" value="${month}">
		<input type="text" name="day" placeholder="dd" size="4"
			value="${date}"> <input type="text" name="year"
			placeholder="yyyy" size="4" value="${year}"><br /><br />Student's First Name: <input
			type="text" name="firstName"
			value="${listToEdit.student.firstName}"><br /><br /> Student's Last Name: <input
			type="text" name="lastName"
			value="${listToEdit.student.lastName}"><br /> Available
		Classes:<br /> <select name="allItemsToAdd" multiple size="10">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value="${currentitem.classId}">${currentitem.className}|
					${currentitem.instructorId}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Edit List and Add Class">
	</form>
	<a href="index.html">Go add new items instead.</a>
</body>
</html>