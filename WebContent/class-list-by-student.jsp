<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student class Lists</title>
</head>
<body>
	<form method="post" action="semesterNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentlist">
				<tr>
					<td><input type="radio" name="semesterId" value="${currentlist.semesterId}"></td>
					<td><h2>${currentlist.semesterName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Start Date: ${currentlist.startDate}</td>
				</tr>
				<tr>
					<td colspan="3">Student's First Name: ${currentlist.student.firstName}</td>
				</tr>
				<tr>
					<td colspan="3">Student's Last Name: ${currentlist.student.lastName}</td>
				</tr>
				<c:forEach var="listVal" items="${currentlist.listOfClass}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.className}, ${listVal.instructorId}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		</br>
		<input type="submit" value="edit" name="doThisToList"> <input
			type="submit" value="delete" name="doThisToList"> <input
			type="submit" value="add" name="doThisToList">
	</form>
	 <br />
	<a href="addClassForSemesterServlet">Create a new List</a> <br />
	<a href="index.html">Insert a new item</a>
</body>
</html>