<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title> 
</head>
<body>
<h2>Register class by Semester</h2>
	<form action="createNewSemesterServlet" method="post">
		Semester Name: <input type="text" name="semesterName"> <br /> 
		<br />
		Start Date: <input type="text" name="month" placeholder="mm" size="4">
		<input type="text" name="day" placeholder="dd" size="4"> <input
			type="text" name="year" placeholder="yyyy" size="4"> 
			
			Student's First Name: <input type="text" name="firstName"><br /> 
			<br />
			Student's Last Name: <input type="text" name="lastName"><br /> 
			<br />
			 Available Classes:<br /> <select name="allItemsToAdd" multiple size="10">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value="${currentitem.classId}">${currentitem.className}|
					${currentitem.instructorId}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create List and Add Items">
	</form>
	<a href="index.html">Go add new items instead.</a>
</body>
</html>