<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DMC</title>
</head>
<body>
	<h2>You can Add, View, or Delete Classes</h2>
	<form method="post" action="navigationServlet">
		<tr>
			<th><strong>&nbsp;&nbsp;&nbsp;&nbsp;Class-Name&nbsp;&nbsp;&nbsp;&nbsp;</strong></th>
			<th><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Instructor-Id</strong></th>
		</tr>
		<table>
			<c:forEach items="${requestScope.allClass}" var="currentClass">
				<tr>
					<td><input type="radio" name="classId"
						value="${currentClass.classId}"></td>
					<td>${currentClass.className}&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${currentClass.instructorId}</td>
				</tr>
			</c:forEach>
		</table>
		<br> <input type="submit" value="edit" name="doThisToItem">
		<input type="submit" value="delete" name="doThisToItem"> <input
			type="submit" value="add" name="doThisToItem">
	</form>
</body>
</html>