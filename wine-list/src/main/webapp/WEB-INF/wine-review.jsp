<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> The Wine </title>
	</head>
	<body>
		
		<a href= "/wine-list">Wine List</a>
		<h2>${theWine.picture}</h2>
		<h1>${theWine.name}</h1>
		<h2>${theWine.year}</h2>
		<h2>${theWine.score}</h2>
		<h2>${theWine.type}</h2>
		<h2>${theWine.message}</h2>
		
		
	</body>
</html>