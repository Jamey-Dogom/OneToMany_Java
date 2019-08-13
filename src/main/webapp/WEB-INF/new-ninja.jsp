<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>' type="text/css"/>
	<script type="text/javascript" src="js/myscript.js"></script>
	<meta charset="UTF-8">
	<title>Title</title>
</head>
<body>
<div class = "container">
<h1>New Ninja</h1>
<form action = "/create-ninja" method = "POST">
<div class="form-group">
    <label for="exampleFormControlSelect1">Dojo:</label>
    <select name = "dojo" class="form-control" id="exampleFormControlSelect1">
     <c:forEach items="${dojos}" var="dojo">
        <option value = "${dojo.id}">${dojo.name} Location</option>
</c:forEach>
    </select>
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput">First Name:</label>
    <input type="text" name = "firstName" class="form-control" id="formGroupExampleInput" >
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput">Last Name:</label>
    <input type="text" name = "lastName" class="form-control" id="formGroupExampleInput" >
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput">Age:</label>
    <input type="number" name = "age" class="form-control" id="formGroupExampleInput" >
  </div>
  
  <button type="submit" class="btn btn-primary">Create</button>
</form>

</div>

</body>
</html>