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
<h1>${dojo.name} Location Ninjas</h1>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
    </tr>
  </thead>
  <tbody>
    
    
    <c:forEach items="${ninjas}" var="ninja">
    <tr>
      <td>${ninja.firstName}</td>
      <td>${ninja.lastName}</td>
      <td>${ninja.age}</td>
      </tr>
</c:forEach>

      
    
  </tbody>
</table>
</div>

</body>
</html>