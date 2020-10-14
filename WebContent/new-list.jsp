<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new Class List</title>
</head>
<body>
<form action = "createNewClassListServlet" method="post">
Class List Name: <input type ="text" name = "listName"><br />
Start date: <input type ="text" name = "month" placeholder="mm" size="4"> <input type ="text" name = "day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4">
Instructor Id: <input type = "text" name = "instructorId"><br />

Available Classes:<br />

<select name="allClassesToAdd" multiple size="6">
<c:forEach items="${requestScope.allClass}" var="currentClass">
   <option value = "${currentClass.classId}">${currentClass.className} | ${currentClass.instructorId}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create List and Add Items">
</form>
<a href = "index.html">Go add new classes instead.</a>
</body>
</html>