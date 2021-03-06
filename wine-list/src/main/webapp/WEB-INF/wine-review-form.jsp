<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Review</title>
	</head>
	<body>
		<h1>Add A New Wine</h1>
	<a href= "/wine-list">Wine List</a>
	
	<form:form method="post" action="/add-review" modelAttribute="newWine">
		<form:label path="name">Name</form:label>
		<form:input path="name"/>
		
		<form:label path="type">Type</form:label>
		<form:input path="type"/>
		
		<form:label path="year">Year</form:label>
		<form:input path="year"/>
		
		<form:label path="score">Score</form:label>
		<form:input path="score"/>
		
		<form:label path="message">Comments</form:label>
		<form:textarea path="message" cols="25" rows="5"/>
		
		<form:label path="picture">Add Picture</form:label>		
		

		<form:button>Submit</form:button>
	</form:form>
	</body>
</html>